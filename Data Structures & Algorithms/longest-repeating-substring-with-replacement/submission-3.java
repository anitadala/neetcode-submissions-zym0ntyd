class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqChar = new int[26];
        int i=0,j=0,len = s.length(),maxFreq=0,lenn=0;
        for( j=0;j<len;j++){
            char ch =  s.charAt(j);
            freqChar[ch-'A']++;
            maxFreq = Math.max(maxFreq,freqChar[ch-'A']);
            while((j-i+1)-maxFreq>k){
                freqChar[s.charAt(i)-'A']--;
                i++;
            }
            lenn = Math.max(lenn,j-i+1);
        }
        return lenn;
    }
}
