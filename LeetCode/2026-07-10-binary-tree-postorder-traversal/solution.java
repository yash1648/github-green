class Solution {
    // Time complexity: O(n), where n is the number of nodes in the tree
    // Space complexity: O(n), where n is the number of nodes in the tree
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalHelper(root, result);
        return result;
    }

    private void postorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorderTraversalHelper(node.left, result);
        postorderTraversalHelper(node.right, result);
        result.add(node.val);
    }
}