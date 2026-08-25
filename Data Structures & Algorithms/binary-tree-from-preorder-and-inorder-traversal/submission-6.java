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

    private int preIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return rebuild(preorder, 0, inorder.length - 1);
    }

    private TreeNode rebuild(int[] preorder, int inLeft, int inRight){
        if(inLeft > inRight) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderIndexMap.get(rootVal);

        root.left = rebuild(preorder, inLeft, index - 1);
        root.right = rebuild(preorder, index + 1, inRight);

        return root;
    }
}