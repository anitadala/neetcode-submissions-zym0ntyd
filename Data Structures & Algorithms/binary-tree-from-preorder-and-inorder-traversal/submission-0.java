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
    HashMap<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
          if(len==1)
            return new TreeNode(preorder[0]);
          
         for(int i=0;i<len;i++){
            inorderMap.put(inorder[i],i);
         }
         return helper(preorder,0,len-1,0,len-1);
    }
    private TreeNode helper(int[] preorder,int preStr, int preEnd,int inStr,int inEnd){
        if(preStr>preEnd || inStr>inEnd)
            return null;
        
        int rootVal = preorder[preStr];
        TreeNode node = new TreeNode(rootVal);

        int inorder_rootidx = inorderMap.get(rootVal);
        int leftTreeSize = inorder_rootidx-inStr;

        node.left = helper(preorder,preStr+1,preStr+leftTreeSize,inStr,inorder_rootidx-1);
        node.right = helper(preorder,preStr+leftTreeSize+1,preEnd,inorder_rootidx+1,inEnd);
        return node;
    }
}
