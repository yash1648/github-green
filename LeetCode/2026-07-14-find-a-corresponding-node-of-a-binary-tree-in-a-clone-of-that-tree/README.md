# Find a Corresponding Node of a Binary Tree in a Clone of That Tree

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/)
- **Date**: 2026-07-14
- **Language**: java


Today, I tackled a problem that required finding a corresponding node in a clone of a binary tree, which felt like an interesting twist on typical tree traversal questions. The challenge was to find the corresponding node in the cloned tree without knowing the mapping between the original and cloned nodes.

To tackle this, I decided to traverse the original tree and its clone simultaneously, comparing the nodes at each level. If a match is found, the corresponding node in the cloned tree is returned immediately. This approach ensures that the time complexity remains O(n), where n is the number of nodes in the tree, and the space complexity is O(h), where h is the height of the tree.

In my solution, I use a depth-first search (DFS) approach, where I explore both the original and cloned trees simultaneously. This ensures that the search is thorough and covers all nodes in the tree.

This problem taught me the importance of being creative with the problem statement and thinking outside the box to find a unique solution. By mapping the nodes in a clever way, I was able to solve the problem efficiently.