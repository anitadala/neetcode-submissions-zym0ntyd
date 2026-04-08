class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor_n = 0;
        for(int i=0;i<nums.length;i++){
            xor_n ^=i+1;
        }
        for(int j=0;j<nums.length;j++){
            xor_n ^=nums[j];
        }
        return xor_n;
    }
}

