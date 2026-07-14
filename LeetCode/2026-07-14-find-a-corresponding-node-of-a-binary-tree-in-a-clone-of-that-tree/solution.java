class Solution {
    // Time complexity: O(n), where n is the number of nodes in the tree
    // Space complexity: O(h), where h is the height of the tree
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = dfs(original.left, cloned.left, target);
        if (left != null) return left;
        return dfs(original.right, cloned.right, target);
    }
}