"""Stage 1: LLM Code Generator — produces LeetCode-format solution code."""

from __future__ import annotations

import logging

from src.execution.llm_client import LLMClient
from src.models.problem import ProblemContext

log = logging.getLogger(__name__)

# System prompt for the code generation stage — strict LeetCode format
CODE_GENERATOR_SYSTEM_PROMPT = """You are an expert competitive programmer. Your task is to write clean, 
efficient, and correct LeetCode solution code.

CRITICAL — LeetCode Format Requirements:
- Output ONLY the `class Solution { public: ... };` block — nothing else.
- NO `#include` directives, NO `main()` function, NO I/O (cin/cout).
- The solution must be a valid LeetCode submission: a class with a public method.
- The method signature must match the standard LeetCode signature for this problem.
- Use the examples below to infer the correct parameter types and return type.

Guidelines:
- Write production-grade code with proper edge case handling.
- Optimize for time and space complexity (specify complexity in comments).
- Use idiomatic C++ features (STL containers, algorithms).
- Include clear variable names and logic comments.
- Only output the code — no explanations, no markdown formatting.
"""


class CodeGenerator:
    """Stage 1 of the LLM pipeline — generates solution code.

    Takes a ProblemContext and produces a solution file string
    in standard LeetCode format (class Solution with public method).
    """

    def __init__(self, llm_client: LLMClient):
        self.llm = llm_client

    def generate_code(self, problem: ProblemContext) -> str:
        """Generate solution code for the given problem.

        Args:
            problem: The problem context from ingestion.

        Returns:
            Solution source code as a string (LeetCode format).
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

Write the complete LeetCode solution in {problem.language}.

REMEMBER:
- ONLY output the `class Solution {{ public: ... }};` block
- NO #include, NO main(), NO cin/cout
- The method name and signature must match LeetCode's standard for this problem
- Infer the parameter types and return type from the examples above
- Include time/space complexity as comments at the top of the method"""

    @staticmethod
    def _clean_code(code: str) -> str:
        """Remove markdown code fences if present."""
        code = code.strip()
        if code.startswith("```"):
            first_newline = code.find("\n")
            if first_newline != -1:
                code = code[first_newline + 1:]
        if code.endswith("```"):
            code = code[:-3].rstrip()
        return code.strip()
