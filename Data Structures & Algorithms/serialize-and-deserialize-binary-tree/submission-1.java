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

public class Codec {

    private String recserialize(TreeNode root, String str){
        if(root == null) str += "null,";
        else{
            str += str.valueOf(root.val + ",");
            str = recserialize(root.left, str);
            str = recserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recserialize(root, "");
    }

    private TreeNode recdeserialize(List<String> str){
        if(str.get(0).equals("null")){
            str.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(str.get(0)));

        str.remove(0);
        node.left = recdeserialize(str);
        node.right = recdeserialize(str);

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> strList = new LinkedList<String>(Arrays.asList(strArray));

        return recdeserialize(strList);
    }
}