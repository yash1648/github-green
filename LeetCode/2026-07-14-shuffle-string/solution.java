class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public String restoreString(String s, int[] indices) {
        char[] t = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            t[indices[i]] = s.charAt(i);
        }
        return new String(t);
    }
}