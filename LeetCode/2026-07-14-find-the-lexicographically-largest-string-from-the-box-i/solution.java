class Solution {
    // Time complexity: O(n^2) where n is the length of the word
    // Space complexity: O(n) for storing the result
    public String lexicographicallyLargestString(String word, int numFriends) {
        int n = word.length();
        String res = "";
        for (int i = 0; i < n - numFriends + 1; i++) {
            String curr = word.substring(i, Math.min(i + numFriends, n));
            if (curr.compareTo(res) > 0) {
                res = curr;
            }
        }
        return res;
    }
}