class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int mostfreq = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            int count = map.get(num);
            map.put(num,count+1);
            if(count+1>mostfreq){
                mostfreq = count+1;
            }
        }
        List<Map.Entry<Integer,Integer>> frequencyList = new ArrayList<>(map.entrySet());
         Collections.sort(frequencyList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                // Sort in descending order of frequency
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
         int[] top_k_elements = new int[k];
         for(int i=0;i<k;i++){
            top_k_elements[i] = frequencyList.get(i).getKey();
         }
        
        return top_k_elements;
    }
}
