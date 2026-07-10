# Print Binary Tree

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/print-binary-tree/)
- **Date**: 2026-07-10
- **Language**: java


**The Problem**

Given a binary tree, print the tree in a 2D level order manner. 

**Initial Thoughts**

I thought of a simple solution using recursion but it has a time complexity of O(n^2) due to the repeated calls inside the recursion. I decided to think of a more efficient solution using Breadth First Search (BFS).

**The Core Trick**

The key to this problem is to traverse the tree level by level using BFS. This allows me to store the nodes in a queue and then print them in a specific order, which is crucial for printing the tree in a 2D manner.

**Complexity**

The time complexity of this solution is O(m*n) where m is the height of the tree and n is the number of columns. This is because in each level of the tree, we need to visit all the nodes, and it takes O(n) time to print the nodes in a row. Also, the space complexity is O(m*n) since we are storing the nodes in a queue.

**Key Takeaway**

The key takeaway from this problem is the importance of using efficient algorithms to solve problems with large time constraints. This problem taught me the value of using BFS as a solution to problems like this, as it allows for a more efficient traversal of the tree.