class Solution {
    public int characterReplacement(String s, int k) {
        int[] charcount = new int[26];
        int len = 0, maxc = 0, maxlen = 0, left = 0, right = 0;
        int strlen = s.length();
        while(right<strlen){ 
                int idx = s.charAt(right)-'A';
                charcount[idx]++;
                // Update the max frequency in the current window
                maxc =  Math.max(maxc, charcount[idx]);
               
            // If window is invalid, shrink from left
           if ((right - left + 1) - maxc > k){
                charcount[s.charAt(left)-'A']--;
                left++;
            }
                right++;
                len = right-left;
                maxlen = Math.max(maxlen,len);
        }
       return maxlen; 
    }
}
