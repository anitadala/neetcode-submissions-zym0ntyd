class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        int flag = 0,count=0;
        for(int num: nums){
            if(num==0){
                flag=1;
                count++;
            }
            else
                product = product*num;
        }
        for(int i=0;i<nums.length;i++){
        if(count==1){
            if(nums[i]==0){
                res[i] = product;
            }
            else {
                res[i] =0;
            }
        }
        else if(count>1){
            res[i]=0;
        }
        else if(count==0){
            res[i] = product/nums[i];
        }
        }
        return res;
    }
}
/*  
[1,2,4,6]=== [1,2,8,48]. [48,48,24,6]

[-1,0,1,2,3]===== [-1,0,0,0,0] [0,0,6,6,3]*/