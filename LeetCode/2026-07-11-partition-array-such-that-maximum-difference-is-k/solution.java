class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for sorting in Java
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1, min = nums[0];
        for (int num : nums) {
            if (num - min > k) {
                count++;
                min = num;
            }
        }
        return count;
    }
}