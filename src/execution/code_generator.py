"""Stage 1: LLM Code Generator — produces production-grade solution code."""

from __future__ import annotations

import logging

from src.execution.llm_client import LLMClient
from src.models.problem import ProblemContext

log = logging.getLogger(__name__)

# System prompt for the code generation stage
CODE_GENERATOR_SYSTEM_PROMPT = """You are an expert competitive programmer. Your task is to write clean, 
efficient, and correct solution code for Data Structures and Algorithms problems.

Guidelines:
- Write production-grade code with proper error handling.
- Optimize for time and space complexity (specify complexity in comments).
- Use idiomatic language features — the code should look like a human wrote it.
- Include clear variable names and logic comments.
- Only output the solution code — no explanations, no markdown formatting.
- Wrap the code in the appropriate class/function signature as provided in the boilerplate.
"""


class CodeGenerator:
    """Stage 1 of the LLM pipeline — generates solution code.

    Takes a ProblemContext and produces a solution file string.
    """

    def __init__(self, llm_client: LLMClient):
        self.llm = llm_client

    def generate_code(self, problem: ProblemContext) -> str:
        """Generate solution code for the given problem.

        Args:
            problem: The problem context from ingestion.

        Returns:
            Solution source code as a string.
        """
        log.info("Generating solution code for: %s", problem.title)

        user_prompt = self._build_prompt(problem)
        code = self.llm.generate(
            system_prompt=CODE_GENERATOR_SYSTEM_PROMPT,
            user_prompt=user_prompt,
            temperature=0.2,  # Low temp for deterministic code
            max_tokens=2048,
        )

        # Clean up potential markdown fences from LLM output
        code = self._clean_code(code)
        log.debug("Generated %d bytes of solution code", len(code))
        return code

    def _build_prompt(self, problem: ProblemContext) -> str:
        """Construct the prompt for code generation."""
        examples_str = ""
        if problem.examples:
            examples_str = "\n".join(
                f"Example {i+1}:\n  Input: {ex['input']}\n  Output: {ex['output']}"
                for i, ex in enumerate(problem.examples)
            )

        return f"""Problem: {problem.title}
Difficulty: {problem.difficulty.value}

Description:
{problem.description}

Constraints:
{problem.constraints}

Examples:
{examples_str}

{("Boilerplate:\n" + problem.boilerplate) if problem.boilerplate else ""}

Write the complete solution in {problem.language}. Include time and space complexity analysis as comments at the top."""

    @staticmethod
    def _clean_code(code: str) -> str:
        """Remove markdown code fences if present."""
        code = code.strip()
        if code.startswith("```"):
            # Remove first fence line (``` or ```cpp etc.)
            first_newline = code.find("\n")
            if first_newline != -1:
                code = code[first_newline + 1:]
        if code.endswith("```"):
            code = code[:-3].rstrip()
        return code.strip()
