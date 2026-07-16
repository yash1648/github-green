# Optimal Partition of String

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/optimal-partition-of-string/)
- **Date**: 2026-07-16
- **Language**: java


**The Problem**

Given a string `s`, determine the minimum number of substrings into which the string can be optimally partitioned, such that the partition is lexicographically minimal.

**Initial Thoughts**

I started by trying to solve this problem using brute force, checking every possible partition of the string. This approach has a time complexity of O(n!), which is too slow for large inputs. I then tried to optimize this by using dynamic programming, but that approach also had a time complexity of O(n^2), which is still not good enough.

**The Core Trick**

After some thought, I realized that the problem can be solved using a technique called "bit manipulation." We can represent each character in the string as a bit and create a binary mask to keep track of the unique characters in each substring. By checking if a mask is present in the binary representation of the unique characters in a substring, we can determine whether a character is already present in the substring and skip it. This approach reduces the time complexity to O(n), making it more efficient.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the string s. The space complexity is O(1), as we only use a constant amount of space.

**Key Takeaway**

This problem demonstrates the power of bit manipulation as a technique for solving string problems. By representing characters as bits, we can quickly check if a character is already present in a substring, reducing the time complexity significantly.