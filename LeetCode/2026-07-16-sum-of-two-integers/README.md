# Sum of Two Integers

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/sum-of-two-integers/)
- **Date**: 2026-07-16
- **Language**: java


**The Problem**

Given two integers `a` and `b`, return their sum without using the `+` operator. You can use bitwise operations to solve this problem.

**Initial Thoughts**

At first, I thought about using a simple loop to add them together, but I realized that could have a time complexity of O(n), which is not efficient. I remembered a trick from a previous problem where we used bitwise operations to add numbers, and I thought that could be useful here.

**The Core Trick**

The key to this problem is to use a bitwise operation to keep track of the carry. We iterate through the least significant bit of `a` and `b`, and for each bit, we calculate the carry by adding the corresponding bits of `a` and `b`. Then, we update `a` and `b` by shifting them one bit to the right. This way, the carry is propagated through the bits, and we only need to add them up when the carry is 1.

**Complexity**

The time complexity of this solution is O(1), because we only iterate through the least significant bits of `a` and `b`. The space complexity is O(1) as well, because we only use a constant amount of space to store the results of the bitwise operations.

**Key Takeaway**

This problem is a good reminder that there are often clever ways to solve problems using the tools we have at our disposal. In this case, we used bitwise operations to efficiently add large integers without using the `+` operator.