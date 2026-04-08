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
    public int maxDepth(TreeNode root) {
        int height=0,l=0,r=0;
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        if(root.left!=null)
             l = maxDepth(root.left);
        if(root.right!=null)
             r = maxDepth(root.right);
        height = 1+ Math.max(l,r);
        return height;
    }
}
