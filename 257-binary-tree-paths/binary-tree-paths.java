class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }
    
    private void dfs(TreeNode node, String path, List<String> result) {
        // If it's a leaf node, append the value and add to result
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }
        
        // Traverse left and right children, appending "->" to the path
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", result);
        }
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", result);
        }
    }
}