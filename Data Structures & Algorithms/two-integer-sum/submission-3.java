class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] num = new int[2];
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           int complement = target - nums[i];
           if (hashmap.containsKey(complement)) {
                num[0]= hashmap.get(complement);
                num[1]=i;
                break;
            }
            hashmap.put(nums[i], i);
        }
        return num; 
    }
}
