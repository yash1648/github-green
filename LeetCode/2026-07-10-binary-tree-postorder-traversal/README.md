# Binary Tree Postorder Traversal

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/binary-tree-postorder-traversal/)
- **Date**: 2026-07-10
- **Language**: java


The problem today was to write a function that performs postorder traversal of a binary tree. 
This is quite an easy problem compared to the rest of the DSA topics. The core trick here was to keep track of the nodes that we've visited in the recursion stack, so as to avoid revisiting the nodes we've already processed. 

The time complexity of this solution is O(n), where n is the number of nodes in the tree. The space complexity is also O(n), due to the recursion stack. The code is pretty straightforward, and it's a good practice to start with a simple solution before optimizing it.

In general, I'd remember to keep track of visited nodes in the recursion stack while traversing a tree, to avoid revisiting. This will help improve the time complexity and reduce space usage.