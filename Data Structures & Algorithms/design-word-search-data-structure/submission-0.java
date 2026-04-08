class TrieNode{
    public Map<Character,TrieNode> children;
    boolean isEndOfWord;
    public TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        int index;
        for(char ch : word.toCharArray()){
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchDFS(word, 0, root);
    }
   private boolean searchDFS(String word, int index, TrieNode node) {
       // Base Case: We have successfully traversed the entire word
        if (index == word.length()) {
            // The search is successful only if the current node marks the end of a valid word
            return node.isEndOfWord;
        }
        char currentChar = word.charAt(index);
        
        if (currentChar != '.') {
            if (node.children.containsKey(currentChar)) {
                return searchDFS(word, index + 1, node.children.get(currentChar));
            } else {
                return false;
            }
        }
        else {
            for (TrieNode childNode : node.children.values()) {
                if (searchDFS(word, index + 1, childNode)) {
                    return true;
                }
            }
            return false;
        }
    }
}
