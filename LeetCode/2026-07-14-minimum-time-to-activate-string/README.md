# Minimum Time to Activate String

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-time-to-activate-string/)
- **Date**: 2026-07-14
- **Language**: java


The problem I solved today was "Minimum Time to Activate String." The task was to find the minimum number of steps to activate all characters in a string by replacing them with stars (*). Each step consists of replacing a subset of characters with stars and updating the count of activated characters. The count increases for each star and resets to 0 for each non-star character. The function must return -1 if it's impossible to activate all characters within the given time limit.

Initial thoughts: I initially thought about brute-forcing all possible subsets and checking if it's possible to activate all characters within the given time limit. However, this approach would be too slow for larger inputs. I then tried binary search to find a suitable time limit.

The core trick: Instead of checking the validity of each subset, I calculated the total count of activated characters and compared it to the given time limit. If the count is greater than the time limit, then it's impossible to activate all characters within the given time limit. Otherwise, the binary search can continue.

Complexity: Time complexity is O(n log n) due to binary search. Space complexity is O(n) for storing the modified string.

Key takeaway: Binary search is a powerful approach for optimizing time complexity when dealing with interval queries or searching for a suitable range within a given time limit.