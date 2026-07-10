class Solution {
    // Time complexity: O(m * n) where m is the height of the tree and n is the number of columns
    // Space complexity: O(m * n)
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int rows = height + 1;
        int cols = (1 << height) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(root, 0, 0, cols - 1, res);
        return res;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private void dfs(TreeNode root, int row, int left, int right, List<List<String>> res) {
        if (root == null) return;
        int mid = left + (right - left) / 2;
        res.get(row).set(mid, String.valueOf(root.val));
        dfs(root.left, row + 1, left, mid - 1, res);
        dfs(root.right, row + 1, mid + 1, right, res);
    }
}