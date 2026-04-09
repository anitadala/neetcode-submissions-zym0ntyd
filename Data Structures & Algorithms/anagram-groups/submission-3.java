class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> hashMap = new HashMap<>();
        for(String str: strs){
            int[] freq = new int[26];
            for(char c : str.toCharArray())
                freq[c - 'a']++;
            String ss = Arrays.toString(freq);//toCharArray(freq));
            hashMap.putIfAbsent(ss,new ArrayList<>());
            hashMap.get(ss).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
}