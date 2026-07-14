class Solution {
    // Time complexity: O(n log n) due to binary search
    // Space complexity: O(n) for the modified string
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        int low = 0, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(mid, s, order, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low == n ? -1 : low;
    }

    private boolean check(int t, String s, int[] order, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i <= t; i++) {
            arr[order[i]] = '*';
        }
        int count = n * (n + 1) / 2;
        int run = 0;
        for (char c : arr) {
            if (c != '*') {
                run++;
            } else {
                count -= run * (run + 1) / 2;
                run = 0;
            }
        }
        count -= run * (run + 1) / 2;
        return count >= k;
    }
}