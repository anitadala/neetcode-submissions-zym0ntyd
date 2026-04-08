class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        res[0]=1;
        for(int i=1;i<nums.length;i++){
           res[i] = res[i-1] * nums[i-1];
        }
        int suffix =1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] = res[i]*suffix;
            suffix = suffix * nums[i];
        }
        
        return res;
    }
}
/*  
[1,2,4,6]=== [1,1,2,8]. [48,24,6,1]

[-1,0,1,2,3]===== [1,-1,0,0,0] [0,6,6,3,1]*/