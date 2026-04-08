class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int max_amount = Math.max(helper(nums,0,n-1),helper(nums,1,n));
        return max_amount;
    }
    public int helper(int[] nums,int idx,int n){
        int prev2 = 0;
        int prev1 = nums[idx];
        for(int i=idx+1;i<n;i++){
            int pick = nums[i] + prev2;
            int notpick = prev1;
            int curr = Math.max(pick,notpick);
            prev2 = prev1;
            prev1 = curr;

        }        
        return prev1;
    }
}
