class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;
        for(int[] it:intervals){
            if(it[1] < start){
                result.add(it);
            }
            else if(it[0]>end){
                if(!inserted){
                    result.add(new int[]{start,end});
                    inserted = true;
                }
                 result.add(it);
            }
            else{ 
                start = Math.min(start, it[0]);
                end = Math.max(end, it[1]);
            }
        }
       
        if (!inserted) {
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][]);
    }
}
