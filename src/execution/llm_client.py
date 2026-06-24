"""LLM API client — interfaces with OpenAI-compatible APIs."""

from __future__ import annotations

import logging
import os
import time
from typing import Optional

import openai

from src.execution.exceptions import ExecutionError

log = logging.getLogger(__name__)


class LLMClient:
    """Thin wrapper around OpenAI-compatible chat completion API.

    Supports any OpenAI-compatible provider (OpenAI, Azure, local LLMs, etc.)
    via the base_url parameter.
    """

    def __init__(
        self,
        model: str = "gpt-4o-mini",
        api_key: Optional[str] = None,
        base_url: Optional[str] = None,
        temperature: float = 0.2,
        max_tokens: int = 2048,
        retry_count: int = 3,
        retry_delay: int = 5,
    ):
        self.model = model
        # Check NVIDIA_API_KEY first (for NVIDIA NIM), fallback to OPENAI_API_KEY
        self.api_key = (
            api_key
            or os.environ.get("NVIDIA_API_KEY")
            or os.environ.get("OPENAI_API_KEY", "")
        )
        if not self.api_key:
            raise ExecutionError(
                "No API key found. Set NVIDIA_API_KEY (NVIDIA NIM) or "
                "OPENAI_API_KEY (OpenAI) env var, or pass via constructor."
            )

        self.client = openai.OpenAI(
            api_key=self.api_key,
            base_url=base_url,
        )
        self.temperature = temperature
        self.max_tokens = max_tokens
        self.retry_count = retry_count
        self.retry_delay = retry_delay

    def generate(
        self,
        system_prompt: str,
        user_prompt: str,
        temperature: Optional[float] = None,
        max_tokens: Optional[int] = None,
    ) -> str:
        """Send a chat completion request with retry logic.

        Args:
            system_prompt: System-level instruction for the model.
            user_prompt: User message content.
            temperature: Override default temperature for this call.
            max_tokens: Override default max_tokens for this call.

        Returns:
            Generated text response.

        Raises:
            ExecutionError: If all retries fail.
        """
        last_error: Optional[Exception] = None

        for attempt in range(1, self.retry_count + 1):
            try:
                log.debug(
                    "LLM request [attempt %d/%d] — model=%s, temp=%.1f",
                    attempt, self.retry_count, self.model,
                    temperature or self.temperature,
                )
                response = self.client.chat.completions.create(
                    model=self.model,
                    messages=[
                        {"role": "system", "content": system_prompt},
                        {"role": "user", "content": user_prompt},
                    ],
                    temperature=temperature if temperature is not None else self.temperature,
                    max_tokens=max_tokens if max_tokens is not None else self.max_tokens,
                )
                content = response.choices[0].message.content
                if content is None:
                    raise ExecutionError("LLM returned empty response")
                return content.strip()

            except openai.RateLimitError as e:
                last_error = e
                wait = self.retry_delay * attempt
                log.warning("Rate limited — retrying in %ds (%d/%d)", wait, attempt, self.retry_count)
                time.sleep(wait)

            except (openai.APIError, openai.APIConnectionError, openai.APITimeoutError) as e:
                last_error = e
                wait = self.retry_delay * attempt
                log.warning("LLM API error: %s — retrying in %ds (%d/%d)", e, wait, attempt, self.retry_count)
                time.sleep(wait)

        raise ExecutionError(
            f"LLM request failed after {self.retry_count} retries: {last_error}"
        ) from last_error
