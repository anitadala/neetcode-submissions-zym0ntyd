class Solution {
    private TreeNode prev = null; 
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    public boolean inorder(TreeNode root){
        if(root==null)
            return true;
        if(!inorder(root.left)) return false;
        
        if(prev != null && root.val<=prev.val)  return false;
        prev = root;
        if(!inorder(root.right)) return false;
        return true;
    }
}
