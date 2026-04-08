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
        return end;
    }
    public int search(int[] nums, int target) {
        int start = 0 , end = nums.length-1,mid=(end-start)/2;
        if(nums.length==1 ){
            if(start==end && nums[0]==target)
            return start;
            else return -1;}

        if(nums.length==2)
        {
            if(target==nums[0])
                return 0;
             else if(target==nums[1])
                return  1;
            else return -1;
        }
        if(nums.length==3)
        {
            if(target==nums[0])
                return 0;
             else if(target==nums[1])
                return  1;
            else if(target==nums[2])
                return  2;
            else return -1;
        }

        int minidx = findMin(nums);
        //System.out.println("minidx"+minidx);
        if(target==nums[minidx])
            return minidx;
        int len = nums.length;
        if(target<nums[minidx] || target>nums[(minidx+len-1)%len])
            return -1;

        start = minidx; 

        if(target>nums[start] && target<nums[len-1]){
                end = len-1;
                while(start<=end){
                    mid = start + (end-start)/2;
                    if(nums[mid]==target)
                        return mid;
                    else if(nums[mid]<target)
                        start = mid+1;
                    else end = mid-1;
                }
        }
        else{
                start = 0;
                end = (minidx+len-1)%len;
                while(start<=end){
                    mid = start + (end-start)/2;
                    if(nums[mid]==target)
                        return mid;
                    else if(nums[mid]<target)
                        start = mid+1;
                    else end = mid-1;
                }
        }
        return -1;
    }
}
