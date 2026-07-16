# Knight Dialer

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/knight-dialer/)
- **Date**: 2026-07-16
- **Language**: java


**The Problem**

The Knight Dialer problem asks you to calculate the number of ways a knight (a chess piece) can land on a 10x10 grid after n steps, considering the restrictions on its movement. This problem is a variant of the Bellman-Ford algorithm, which is a technique for finding the shortest path in a weighted graph.

**Initial Thoughts**

Initially, I thought about using a dynamic programming approach, but I quickly realized that the time complexity would be too high for this problem. I then tried to apply the Bellman-Ford algorithm, but that didn't work out either. I was stuck for a while, but then I remembered that the problem had a specific pattern in its restrictions.

**The Core Trick**

The core trick in this problem is understanding the restrictions on the knight's movement. A knight can move two squares in one direction, then one square perpendicular to the first two. This restriction leads to a 2D array of size 10x10, where each element represents the number of ways a knight can land on a particular square after n steps.

**Complexity**

The time complexity of this solution is O(n), as we make a constant number of iterations for each of the n steps. The space complexity is also O(n), as we need to store the results for each step.

**Key Takeaway**

This problem taught me that sometimes, even when a problem seems unsolvable, there might be a clever trick or pattern that can lead to a straightforward solution. In this case, understanding the knight's movement restrictions proved to be the key to solving the problem efficiently.