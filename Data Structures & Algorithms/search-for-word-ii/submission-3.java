class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode(){
        children = new TrieNode[26];
    }
}

class Solution {
    private TrieNode root;
    private void insert(String word){
        TrieNode node = root; 
         for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> result = new ArrayList<>();
        for(String str:words){
            insert(str);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i,j,board,root,result);
            }
        }
    return result;
    }
    
    public void dfs(int i,int j,char[][] board,TrieNode node,List<String> result){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length )
            return;
        char ch = board[i][j];
        // visited or no such child → stop
        if (ch == '#') return;
        int idx = ch - 'a';
        TrieNode next = node.children[idx];
        if (next == null) return; // no word with this prefix
        // move into trie
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }
        board[i][j] = '#';
        dfs(i + 1, j, board,next,result);
        dfs(i - 1, j, board,next,result);
        dfs(i, j + 1, board,next,result);
        dfs(i, j - 1, board,next,result);
        board[i][j] = ch;
    }
}
