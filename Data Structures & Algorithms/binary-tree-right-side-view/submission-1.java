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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int currentLevel = queue.size();
            int rightInt = 0;

            for(int i = 0; i < currentLevel; i++){
                TreeNode node = queue.poll();
                rightInt = node.val;

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(rightInt);
        }
        return ans;
    }
}