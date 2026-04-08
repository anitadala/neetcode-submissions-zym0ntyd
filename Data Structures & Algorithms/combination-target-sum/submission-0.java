class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target) { 
        List<List<Integer>> result = new ArrayList<>();
        combination_sum(0,nums,result,target,new ArrayList<>());
        return result;
    }
    private void combination_sum(int index,int[] nums,List<List<Integer>>result,int target,List<Integer>currentList){
        if(target==0 ){
            result.add(new ArrayList<>(currentList));
            return;
        }
        if(target<0 || index==nums.length){
            return;
        }
        currentList.add(nums[index]);
        combination_sum(index,nums,result,target-nums[index],currentList);
        
        currentList.remove(currentList.size()-1);
        combination_sum(index+1,nums,result,target,currentList);
    }
}
