"""Stage 2: LLM Documentation Writer — produces a humanized dev journal."""

from __future__ import annotations

import logging

from src.execution.llm_client import LLMClient
from src.models.problem import ProblemContext

log = logging.getLogger(__name__)

# System prompt for the documentation stage
DOC_WRITER_SYSTEM_PROMPT = """You are a senior software engineer writing a personal development journal entry 
about solving a DSA problem. Write in a natural, first-person voice — as if jotting down thoughts 
after a coding session.

CRITICAL CONSTRAINTS:
- Write in a genuine human voice. Never use these words or phrases: 
  "Furthermore", "Crucial", "Let's dive in", "Moreover", "In conclusion",
  "It is worth noting", "Robust", "Leverage", "Navigate", "Delve".
- Do NOT sound like an AI textbook or tutorial.
- DO sound like an experienced engineer reflecting on a problem they just solved.
- Be conversational but professional — like a thoughtful dev blog post.

Structure:
1. **The Problem** — What the problem asks in your own words (1-2 paragraphs)
2. **Initial Thoughts** — First reactions, brute-force ideas, false starts (1 paragraph)
3. **The Core Trick** — What makes the problem interesting (1 paragraph)
4. **Complexity** — Time & space analysis
5. **Key Takeaway** — What you'd remember for next time (1-2 sentences)

Do NOT repeat the problem statement verbatim. Do NOT list the code. Keep it under 500 words.
"""


class DocWriter:
    """Stage 2 of the LLM pipeline — generates humanized documentation.

    Takes the ProblemContext AND the generated solution code, producing
    a natural "dev journal" README.
    """

    def __init__(self, llm_client: LLMClient):
        self.llm = llm_client

    def generate_doc(self, problem: ProblemContext, solution_code: str) -> str:
        """Generate a humanized dev journal README for the problem.

        Args:
            problem: The problem context.
            solution_code: The generated solution code (for reference).

        Returns:
            Markdown documentation as a string.
        """
        log.info("Generating dev journal for: %s", problem.title)

        user_prompt = self._build_prompt(problem, solution_code)
        doc = self.llm.generate(
            system_prompt=DOC_WRITER_SYSTEM_PROMPT,
            user_prompt=user_prompt,
            temperature=0.7,  # Higher temp for creative/natural writing
            max_tokens=1500,
        )

        return doc.strip()

    def _build_prompt(self, problem: ProblemContext, solution_code: str) -> str:
        """Build the documentation prompt with problem + code context."""
        return f"""Here's the problem I solved today and the code I wrote. Write a dev journal entry.

Problem: {problem.title}
Difficulty: {problem.difficulty.value}
Source: {problem.source_url}

My solution code:
```{problem.language}
{solution_code}
```"""
