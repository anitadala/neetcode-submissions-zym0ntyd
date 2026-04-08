class Solution {

    public String encode(List<String> strs) {
        String encoded = new String();
        for(String str: strs){
            encoded +=str + "|";
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        String word="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='|'){
                decoded.add(word);
                word="";
            }
            else{
                word = word + str.charAt(i);
            }
            
        }
        return decoded;
    }
}
