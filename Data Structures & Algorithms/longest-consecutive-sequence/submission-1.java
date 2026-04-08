class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int cnt=1;
        if(nums.length==0)
            return 0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int streak = 1;
                int curr = num;
                while(set.contains(curr+1)){
                    streak++;
                    curr++;
                }
                cnt = Math.max(cnt,streak);
            }
        }
        return cnt;
    }
}