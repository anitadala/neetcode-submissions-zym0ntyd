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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "a#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                sb.append("a#");
                continue;
            }
            else 
            sb.append(node.val).append("#");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("a#")) return null;
        String[] values = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<values.length){
            TreeNode parent = q.poll();
            if(!values[i].equals("a")){
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.left);
            }
            i++;
            if(!values[i].equals("a")){
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.right);
            }
            i++;
        }
        return root;
    }
}
