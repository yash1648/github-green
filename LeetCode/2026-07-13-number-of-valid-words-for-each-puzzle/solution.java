class Solution {
    // Time complexity: O(n*m) where n is the number of words and m is the maximum length of a word
    // Space complexity: O(n) where n is the number of words
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            wordMap.put(mask, wordMap.getOrDefault(mask, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            int subMask = mask;
            int count = 0;
            do {
                if ((subMask & (1 << (puzzle.charAt(0) - 'a'))) != 0 && wordMap.containsKey(subMask)) {
                    count += wordMap.get(subMask);
                }
                subMask = (subMask - 1) & mask;
            } while (subMask != mask);
            result.add(count);
        }
        return result;
    }
}