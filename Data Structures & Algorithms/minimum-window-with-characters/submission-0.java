class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        if(s.equals(t))
            return s;
        
        int minlen = Integer.MAX_VALUE;
       
        Map<Character,Integer> t_map = new HashMap<>();
        for (char c : t.toCharArray()) {
                t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }
        int start =0, end = 0,have=0,required = t_map.size();
        int l = s.length();
        String str = "";
        Map<Character,Integer> have_map = new HashMap<>();

        while(end<l){
            char ch = s.charAt(end);
            have_map.put(ch,have_map.getOrDefault(ch,0)+1);
            
            if(t_map.containsKey(ch) && have_map.get(ch)==t_map.get(ch)){
                have++;   
            }

            while(have==required){
                if(end-start+1<minlen){
                    minlen = end-start+1;
                    str = s.substring(start,end+1);
                }
                char leftChar = s.charAt(start);
                have_map.put(leftChar,have_map.get(leftChar)-1);
                if(t_map.containsKey(leftChar) && have_map.get(leftChar)<t_map.get(leftChar)){
                    have--;    
                }
                start++;
            }
             end++; 
        } 
        return str;
    }
}
