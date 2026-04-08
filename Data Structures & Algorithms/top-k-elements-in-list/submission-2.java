class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int mostfreq = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }//O(n)
        List<Map.Entry<Integer,Integer>> frequencyList = new ArrayList<>(map.entrySet());
         Collections.sort(frequencyList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                // Sort in descending order of frequency
                return entry2.getValue().compareTo(entry1.getValue());
            }
        }); //O(n log n)
         int[] top_k_elements = new int[k];
         for(int i=0;i<k;i++){
            top_k_elements[i] = frequencyList.get(i).getKey();
         }
        
        return top_k_elements;
    }
}
