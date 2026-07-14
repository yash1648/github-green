# Simple Bank System

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/simple-bank-system/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

The problem asks to build a bank system where users can perform transfers, deposits, and withdrawals. The system has a limited number of accounts and only supports positive money amounts. The system should ensure all transactions are valid.

**Initial Thoughts**

I remembered that I had implemented a similar problem before, but this time it had to be more efficient. I thought about using a HashMap to store the balance of each account, but it would require more memory. I also considered using a custom data structure, like a doubly linked list or a segment tree, but they seemed overkill for this problem.

**The Core Trick**

The key to solving this problem was to use a simple, efficient data structure that allowed for fast access and modification of elements. Given that the problem statement mentions that all operations have time complexity O(1), I decided to use an array to store the balance of each account. This would allow for constant time access, insertion, and deletion of elements.

**Complexity**

The time complexity of the transfer method is O(1), as it only requires a constant amount of time to access and modify elements in the array. The deposit and withdraw methods have a time complexity of O(1) as well, because they only require a constant amount of time to access the balance of an account.

**Key Takeaway**

When solving problems with constant time complexity constraints, it's essential to choose data structures that allow for fast access and modification of elements. In this case, using an array with constant time complexity allowed me to implement a simple, efficient bank system.