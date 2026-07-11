# Partition Array Such That Maximum Difference Is K

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/)
- **Date**: 2026-07-11
- **Language**: java


**The Problem**
Given an array of integers `nums` and an integer `k`, partition the array into two non-empty subarrays such that the maximum absolute difference between the sums of all numbers in the first subarray and the second subarray is less than or equal to `k`.

**Initial Thoughts**
This problem seems tricky. At first, I thought about using a greedy approach to sort the array and then iterate through it, updating a variable to count the number of elements in each partition. However, the time complexity of this approach is O(n log n) due to sorting. I needed a more efficient solution.

**The Core Trick**
The key to solving this problem lies in understanding that we can achieve the maximum difference between the sums of elements in two partitions if and only if the maximum element in the first partition is equal to the minimum element in the second partition. This is because, for any other pair of maximum and minimum elements, we can always find another pair with a larger difference between the sums.

**Complexity**
To find the maximum difference between the sums of elements in two partitions, we can first calculate the sums of elements in both partitions (by iterating through the array and updating two variables for each). Then, we can compare these two sums and find the maximum absolute difference between them. The time complexity of this approach is O(n), where n is the length of the array.

**Key Takeaway**
When dealing with problems that involve finding a partition or a split, it's always a good idea to think about the maximum/minimum values and how they can be used to optimize the solution. By focusing on these key points, I was able to come up with a more efficient solution for this problem.