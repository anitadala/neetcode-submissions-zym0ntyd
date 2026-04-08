class Solution {
    int Max_Sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return Max_Sum;
    }
    private int helper(TreeNode root){
        if(root==null)
            return 0;
       
        int left_sum = Math.max(helper(root.left),0);
        int right_sum = Math.max(helper(root.right),0);
        int curr_sum = root.val + left_sum + right_sum;
        Max_Sum = Math.max(Max_Sum,curr_sum);
        return root.val + Math.max(left_sum,right_sum);
    }
}
