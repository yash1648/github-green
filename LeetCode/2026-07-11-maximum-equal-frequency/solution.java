class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int maxEqualFreq(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int[] freq = new int[n + 1];
        int maxFreq = 0, res = 0;
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (count[num] > 0) {
                freq[count[num]]--;
            }
            count[num]++;
            freq[count[num]]++;
            maxFreq = Math.max(maxFreq, count[num]);
            
            if (maxFreq == 1 || freq[maxFreq] == 1 && maxFreq == i + 1 - (freq[maxFreq - 1] > 0 ? maxFreq - 1 : maxFreq) || 
                freq[maxFreq] > 1 && freq[maxFreq - 1] == 1 && maxFreq - 1 == i + 1 - maxFreq) {
                res = i + 1;
            }
        }
        
        return res;
    }
}