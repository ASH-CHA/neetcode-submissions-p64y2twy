/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxMost){
        if(node == null) return 0;

        int count = 0;

        if(node.val >= maxMost){
            count = 1;
            maxMost = node.val;
        }

        count += dfs(node.left, maxMost);
        count += dfs(node.right, maxMost);

        return count;
    }
}