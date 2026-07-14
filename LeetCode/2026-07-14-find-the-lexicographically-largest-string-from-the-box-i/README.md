# Find the Lexicographically Largest String From the Box I

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

Given a string `word` of length `n` and an integer `numFriends`, find the lexicographically largest string from the box of substrings of length `numFriends`.

**Initial Thoughts**

At first, I tried a brute-force approach, generating all possible substrings of length `numFriends`, comparing each one to the current result, and returning the largest one. This solution has a time complexity of `O(n^2)` and a space complexity of `O(n)`. However, this is not efficient enough for larger inputs.

**The Core Trick**

The key to solving this problem is to generate only the substrings that can become the largest string. Since `numFriends` is smaller than `n`, there are `n - numFriends + 1` substrings of length `numFriends`. We can generate these substrings and compare each one to the current result without generating all possible substrings.

**Complexity**

Time complexity: `O(n - numFriends + 1)`, where `n` is the length of the word. This is an improvement from the brute-force approach's `O(n^2)` complexity.

Space complexity: `O(1)`, as we only use a fixed amount of space for the result string.

**Key Takeaway**

This problem teaches us that when dealing with a specific limit or constraint, we should think about how to generate only the necessary substrings or combinations to find the solution efficiently.