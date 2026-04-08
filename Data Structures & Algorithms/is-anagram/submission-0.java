class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int cnt = 0;
        if(s.length() != t.length())
            return false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            arr[ch-'a']--;
            if(arr[ch-'a']==-1)
            return false;
        }
        for(int i=0;i<25;i++)
        if(arr[i]!=0)
            return false;
        
        return true;

    }
}
