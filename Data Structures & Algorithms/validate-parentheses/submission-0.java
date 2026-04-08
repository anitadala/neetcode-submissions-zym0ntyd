class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        s.push('#');
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(s.peek()=='#'){
                s.push(ch);
            }
            else if(ch=='[' || ch=='{' || ch=='(')
                s.push(ch);
            else if((s.peek()=='[' && ch==']' )|| (s.peek()=='(' && ch==')') || (s.peek()=='{' && ch=='}' ))
                    s.pop();
            else
                return false; 
    }
    return s.peek()=='#';
}
}