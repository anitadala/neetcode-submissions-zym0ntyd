class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
/*
1. sort the word and see if it is already present in the list
2. if present, append in the already present list
    2.1 
3. if not, create a new list with that word
t.c. 
    O(1000) - sorting and O(n) for traversing 

act = resultGroup[]

*/
