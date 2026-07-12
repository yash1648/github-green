# Apply Operations to Make Sum of Array Greater Than or Equal to k

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/)
- **Date**: 2026-07-12
- **Language**: java


**The Problem**

Given an integer `k`, your task is to find the minimum number of operations required to make the sum of an array greater than or equal to `k`. In each operation, you can increase the value of any element in the array by 1.

**Initial Thoughts**

The problem seems straightforward, but I initially struggled with the time complexity. I thought of using a brute-force approach, trying all possible combinations and checking if the sum is greater than or equal to `k`. This method would take exponential time.

**The Core Trick**

The key insight is that we need to find the smallest power of 2 greater than `k`. This is because multiplying the array elements by 2 repeatedly will eventually result in a sum that's greater than or equal to `k`.

**Complexity**

Time complexity: O(sqrt(k))
Space complexity: O(1)

**Key Takeaway**

Always think about the smallest power of 2 that's greater than or equal to a number. This can help simplify problems and save time.