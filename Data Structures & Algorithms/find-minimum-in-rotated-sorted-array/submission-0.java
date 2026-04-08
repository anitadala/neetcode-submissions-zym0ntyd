class Solution {
    public int findMin(int[] nums) {
        int start = 0 , end = nums.length-1,mid=(end-start)/2;
        while(start<end){
            mid = start + ((end-start)/2);
            if(nums[start]==nums[end]){
                break;
            }
            else if(nums[mid]>nums[end]){
                start = mid+1;
            }
            else if(nums[mid]<nums[end]){      
                end = mid;
            }
        }
        return nums[start];
    }
}
