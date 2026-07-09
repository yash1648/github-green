class Solution {
    // Time complexity: O(n log n) due to binary string concatenation
    // Space complexity: O(n log n) for storing the concatenated binary string
    public int concatenatedBinary(int n) {
        int MOD = (int) 1e9 + 7;
        long result = 0;
        int length = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                length++;
            }
            result = ((result << length) | i) % MOD;
        }
        return (int) result;
    }
}