class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        String ss = new String(sChar);
        String tt = new String(tChar);
        if(ss.equals(tt))
            return true;
        return false;
    }
}
