class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int mostfreq = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> map.get(a)- map.get(b)
        );


        for(Map.Entry<Integer,Integer> itr:map.entrySet()){
            pq.offer(itr.getKey());
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty())
            res[i++] = pq.poll();
        //int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
