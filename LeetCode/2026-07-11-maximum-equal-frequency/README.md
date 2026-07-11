# Maximum Equal Frequency

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-equal-frequency/)
- **Date**: 2026-07-11
- **Language**: java


**The Problem**

Given an array of integers `nums`, find the maximum possible size of a non-empty subset of nums that contains exactly one occurrence of every integer in the array.

**Initial Thoughts**

At first, I thought of using a hash table to count the frequency of each element in the array. Then, I tried to find a pair of elements with the same frequency and use them to form a subset. However, this approach did not work because it only considered pairs and not triplets or more.

**The Core Trick**

After some thinking, I realized that I could use a sliding window approach to find the longest contiguous subarray with exactly one occurrence of each integer. This idea came from the observation that if an integer appears more than once in the subarray, it must appear more than once in the entire array, which means there is no need to consider it further.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the array. This is because we are iterating through the array only once. The space complexity is also O(n) since we need to store all elements in the array at some point.

**Key Takeaway**

When solving problems involving arrays or graphs, it's essential to break down the problem into smaller subproblems and think about how to combine solutions to those subproblems to solve the overall problem. In this case, I needed to find a way to efficiently find the longest contiguous subarray with exactly one occurrence of each integer. By using a sliding window approach, I was able to solve this problem efficiently.