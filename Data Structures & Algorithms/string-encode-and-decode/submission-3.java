class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str: strs){
            encoded.append(str).append("|");
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        StringBuilder word = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='|'){
                decoded.add(word.toString());
                word = new StringBuilder();
            }
            else{
                word = word.append(str.charAt(i));
            }
            
        }
        return decoded;
    }
}
