class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        int[] reqFreq = new int[256];

        for(char c: t.toCharArray()){
            reqFreq[c]++;
        }

        int req = t.length();
        int i=0,j,minlength = 1001,lengthh,start=0;
        String res = "";
        
        for(j=0;j<s.length();j++){

            if(reqFreq[s.charAt(j)]>0){
                req--;
            }
            
            reqFreq[s.charAt(j)]--;
            
            while(req==0){
                
                lengthh = j-i+1;
                
                if(lengthh<minlength){
                    minlength = Math.min(minlength,lengthh);
                    start = i;
                }
                reqFreq[s.charAt(i)]++;
                if(reqFreq[s.charAt(i)]>0)
                    req++;    
                i++;
            }
        }
        return minlength == 1001 ? "" : s.substring(start, start + minlength);
    }
}
