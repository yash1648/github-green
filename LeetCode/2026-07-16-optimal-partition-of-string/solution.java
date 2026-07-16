class Solution {
    // Time complexity: O(n), where n is the length of the string s.
    // Space complexity: O(1), as we only use a constant amount of space.
    public int partitionString(String s) {
        int count = 1;
        int unique = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int mask = 1 << (s.charAt(i) - 'a');
            if ((unique & mask) != 0) {
                unique = mask;
                count++;
            } else {
                unique |= mask;
            }
        }
        
        return count;
    }
}