class Solution {
    public boolean isPalindrome(String s) {
        String modified_s = s.replaceAll("\\s+", "");
        modified_s = modified_s.toLowerCase();
        StringBuilder modified_ss = new StringBuilder();
        for(int i=0;i<modified_s.length();i++){
            if(Character.isLetterOrDigit(modified_s.charAt(i))){
                modified_ss.append(modified_s.charAt(i));
            }
        }
        int len = modified_ss.length();
        int half = len/2;
        for(int i=0;i<half;i++){
            if(modified_ss.charAt(i) != (modified_ss.charAt(len-i-1)))
                return false;
        }
        return true;
    }
}
