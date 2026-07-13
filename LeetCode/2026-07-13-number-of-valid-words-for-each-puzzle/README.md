# Number of Valid Words for Each Puzzle

- **Difficulty**: Hard
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/)
- **Date**: 2026-07-13
- **Language**: java


**The Problem**

Given an array of words and a list of puzzles, the problem is to find the number of valid words that can be formed using each puzzle, considering each puzzle as a masked word. A puzzle is a string where some characters are masked by a dot ('.'), and the remaining characters are letters. A word is considered valid if it contains all the letters present in the puzzle in the correct order.

**Initial Thoughts**

At first, I tried to solve this problem by checking each word against all the puzzles. However, this approach has a time complexity of O(n \* m \* k), where n is the number of words, m is the maximum length of a word, and k is the number of puzzles. This is not efficient enough for a large dataset.

**The Core Trick**

To improve the time complexity, I used a map to store the number of occurrences of each character in the words and then iterated through the puzzles. For each puzzle, I masked the letters by setting the corresponding bits in a mask, and then iterated through the mask to check if each letter was present in the word and was in the correct order. This approach reduced the time complexity to O(n \* m \* k/64) = O(n \* m), which is more efficient for large datasets.

**Complexity**

The time complexity of this solution is O(n \* m) where n is the number of words and m is the maximum length of a word. The space complexity is O(n) where n is the number of words.

**Key Takeaway**

This problem demonstrates how to optimize a brute-force approach by using a mask to represent the letters in a puzzle and then iterating through the mask to check if each letter was present in the word and was in the correct order.