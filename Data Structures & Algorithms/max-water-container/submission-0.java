class Solution {
    public int maxArea(int[] heights) {
        int max_water=0;
        int i=0,j=(heights.length)-1;
        while(i<j){
            int curr_water = (j-i)*Math.min(heights[i],heights[j]);
            if(heights[i]<heights[j]){
                i++;
            }
            else j--;
            max_water = Math.max(max_water,curr_water);
        }
        return max_water;
    }
}
