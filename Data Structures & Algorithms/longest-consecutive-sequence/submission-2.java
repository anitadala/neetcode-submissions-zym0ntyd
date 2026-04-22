class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        int maxx= 0;
        for(int num:nums){
            int count = map.getOrDefault(num-1,0)+1;
            maxx=Math.max(maxx,count);
            map.put(num,count);
        }
        return maxx;
    }
}
