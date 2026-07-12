class Solution {
    // Time complexity: O(sqrt(k))
    // Space complexity: O(1)
    public int minOperations(int k) {
        if (k == 1) return 0;
        
        int ops = 0;
        int curr = 1;
        
        while (curr < k) {
            ops++;
            curr *= 2;
        }
        
        if (curr > k) {
            int diff = curr - k;
            ops += diff;
        }
        
        return ops;
    }
}