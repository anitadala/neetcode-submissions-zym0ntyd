class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0,i=0,j=0;
        int[] chars = new int[256];
        while(i<=j && j<s.length()){
            char ch = s.charAt(j);
            boolean exists = chars[ch]>0 ? true : false;
            if(exists){
                chars[s.charAt(i)]--;
                i++;    
            } else {
                chars[ch]++;
                j++;
                len = Math.max(len,j-i);
            }
        }
        return len;
    }
}
