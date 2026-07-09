# Concatenation of Consecutive Binary Numbers

- **Difficulty**: Medium
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/)
- **Date**: 2026-07-09
- **Language**: java


**The Problem**
Given an integer `n`, find and return the concatenated binary representation of all numbers from `1` to `n`, where consecutive numbers are concatenated without any separators.

**Initial Thoughts**
I started by thinking about how I could efficiently generate a binary string for each number in the range. I remembered that the binary representation of a number can be obtained by shifting a `1` left by the number of bits required to represent it and concatenating it with the previous binary string.

My initial code looked something like this:
```java
class Solution {
    // Time complexity: O(n^2) due to concatenation of binary strings
    // Space complexity: O(n) for storing the concatenated binary string
    public int concatenatedBinary(int n) {
        int MOD = (int) 1e9 + 7;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            while (i > 0) {
                sb.insert(0, (i & 1));
                i >>= 1;
            }
            long value = Long.parseLong(sb.toString(), 2);
            result = ((result << length) | i) % MOD;
        }
        return (int) result;
    }
}
```
**The Core Trick**
After some trial and error, I realized that I could avoid concatenating individual bits by using a bitwise operation to shift a `1` into the binary representation of each number. This would save me a lot of time and reduce the space complexity to `O(1)`.

**Complexity**
This solution has a time complexity of `O(n log n)`, as the concatenation of binary strings is expensive. The space complexity is `O(1)` due to the constant-time bitwise operations.

**Key Takeaway**
This problem taught me to be more mindful of the space complexity of my solutions. When working with bitwise operations, it's easy to forget that shifting a bit into a binary string can consume a lot of space. Going forward, I will be more careful to analyze the space requirements of my solutions, especially when dealing with operations on binary strings.