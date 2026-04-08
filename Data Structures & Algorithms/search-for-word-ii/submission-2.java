class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // non-null only at end of a word
    }

    private List<String> result;
    private char[][] board;
    private int rows;
    private int cols;

    public List<String> findWords(char[][] board, String[] words) {
        this.result = new ArrayList<>();
        this.board = board;
        this.rows = board.length;
        if (rows == 0) return result;
        this.cols = board[0].length;

        TrieNode root = buildTrie(words);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, root);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                int idx = ch - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = w; // mark end of word
        }
        return root;
    }

    private void dfs(int r, int c, TrieNode node) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;

        char ch = board[r][c];
        if (ch == '#') return; // already visited

        int idx = ch - 'a';
        TrieNode next = node.children[idx];
        if (next == null) return; // no word with this prefix

        if (next.word != null) {
            result.add(next.word);
            next.word = null; // avoid duplicates
        }

        board[r][c] = '#'; // mark visited

        dfs(r + 1, c, next);
        dfs(r - 1, c, next);
        dfs(r, c + 1, next);
        dfs(r, c - 1, next);

        board[r][c] = ch; // backtrack
    }
}
