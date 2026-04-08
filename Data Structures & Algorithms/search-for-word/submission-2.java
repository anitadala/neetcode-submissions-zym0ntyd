class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
         for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j]==word.charAt(0))
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
         }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // Base cases
        if (index == word.length()) 
            return true; // found the full word
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) 
            return false;
        if (board[i][j] != word.charAt(index)) 
            return false;
        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';
        // Explore 4 directions
        boolean found = dfs(board, i + 1, j, word, index + 1)
                     || dfs(board, i, j + 1, word, index + 1)
                     || dfs(board, i, j - 1, word, index + 1)
                     || dfs(board, i - 1, j, word, index + 1)
                     ;
        // Unmark visited
        board[i][j] = temp;

        return found;
    }
}
