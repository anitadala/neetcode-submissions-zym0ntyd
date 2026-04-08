class Solution {
    //private TreeNode prev = null; 
    public boolean isValidBST(TreeNode root) {
        return inorder(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean inorder(TreeNode node,long min,long max){
        if(node==null)
            return true;
       
        if(node.val <= min || node.val>=max)  return false;

        return inorder(node.left,min,node.val)&&inorder(node.right,node.val,max);
    }
}
