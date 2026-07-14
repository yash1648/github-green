# Shuffle String

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/shuffle-string/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

Given a string `s` and an array of integers `indices`, return the string which is formed by taking the substring of `s` with the indices given.

**Initial Thoughts**

At first, I thought about using a simple loop to build the new string by replacing characters with their corresponding indices. However, I soon realized that this approach would have a time complexity of O(n^2), which is too slow for large strings or arrays.

**The Core Trick**

The key to solving this problem efficiently is to use a character array to store the substring of `s`, and then build the new string by directly replacing characters with their corresponding indices. This approach reduces the time complexity to O(n), which is much faster and efficient for large inputs.

**Complexity**

Time complexity: O(n)
Space complexity: O(n)

**Key Takeaway**

When dealing with problems that involve string manipulation, it's essential to analyze the time and space complexity of each approach. Using an array to store the substring and then building the new string by directly replacing characters is a much more efficient and time-saving solution.