class Solution {
    public int lengthOfLongestSubstring(String s) {
       int len=0;
       int i=0,j=0;
       Set<Character> set = new HashSet<>();
       while(i<=j && j<s.length()){
            char ch = s.charAt(j);
            boolean exists = set.contains(ch);
            if(exists){
                set.remove(s.charAt(i));
                i++;
            }
            else{
                set.add(ch);
                j++;
                len = Math.max(len,j-i);
            }
       } 
       return len;
    }
}
/*
"pwwkew"
 i = 0 , j=0. // set=[p]
 i=0, j = 1.  // set = [p,w]
 i=0,j=2.     // set = [w] len = 2
 i=1, j=2.    // set = []
 i=2, j=2.    // set = [w]
 i=2, j=4.    // set = [w,k,e]
*/

