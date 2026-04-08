class Solution {
    public boolean canJump(int[] nums) {
        int currptr = 0;
        int reachable = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            currptr = i + nums[i];
            if(i>reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
            if(reachable>=len-1)
                return true;
            
        }
        return false;
    }
}
