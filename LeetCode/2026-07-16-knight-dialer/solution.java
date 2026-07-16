class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int knightDialer(int n) {
        int MOD = (int) 1e9 + 7;
        int[][] moves = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int[] dp = new int[10];
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int[] temp = new int[10];
            for (int j = 0; j < 10; j++) {
                for (int move : moves[j]) {
                    temp[j] = (temp[j] + dp[move]) % MOD;
                }
            }
            dp = temp;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }
}