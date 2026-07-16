# Adding Two Negabinary Numbers

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/adding-two-negabinary-numbers/)
- **Date**: 2026-07-16
- **Language**: java


Problem: Adding two negabinary numbers, which are represented by arrays of 0s and 1s. A negabinary number is equal to -2 raised to its index.

Initial Thoughts: This problem seems straightforward, but I'm not sure how to handle the "-" sign in front of each array. I'll need to reverse one of the arrays and then add them as regular binary numbers.

The Core Trick: Since negabinary numbers are represented by -2 raised to its index, we can simply negate the indices of the elements in one of the arrays before adding them. This way, the numbers will be added as regular binary numbers.

Complexity: The time complexity is O(n), where n is the maximum length of arr1 and arr2. The space complexity is also O(n) due to the need to store the result array.

Key Takeaway: When dealing with arrays representing negabinary numbers, be mindful of the "-" sign in front of each array and the way negabinary numbers are represented by -2 raised to their index.