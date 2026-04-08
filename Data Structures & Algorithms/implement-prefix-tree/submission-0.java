class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node!=null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node!=null;
    }

    private TrieNode findNode(String s) {
        TrieNode node = root;
        for(char c: s.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null)
                return null;
            node = node.children[index];
        }
        return node;
    }
}
