# Count Days Without Meetings

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/count-days-without-meetings/)
- **Date**: 2026-07-10
- **Language**: java


Today, I tackled a medium-difficulty problem on LeetCode, "Count Days Without Meetings." Given an integer `days` representing the total number of days in a month and a 2D array `meetings` where each inner array contains the start and end times of a meeting in the format `[start, end]`, the task is to calculate the number of days without meetings.

My initial thoughts were to sort the meetings by their start times, iterate through them, and merge overlapping meetings into a single meeting slot. Then, I'd calculate the number of days between the merged meetings. However, this approach has a time complexity of O(n log n) due to sorting, which isn't ideal for large datasets.

To optimize, I decided to sort the meetings first, then iterate through them to merge overlapping meetings. If a meeting overlaps with the last merged meeting, I'd merge the two; otherwise, I'd add the current meeting to the merged meetings. This approach has a time complexity of O(n^2) with a space complexity of O(n) for storing merged meetings.

The key trick is to track the merged meetings using a double-ended array (deque) to efficiently merge overlapping meetings. Once all meetings have been processed, I calculate the number of days available by summing the gaps between merged meetings.

This solution has a time complexity of O(n log n) with a space complexity of O(n) for storing merged meetings, which is more efficient than the previous approach for large datasets. The key takeaway is to focus on optimizing time complexity when dealing with large datasets, even if it requires a different approach.