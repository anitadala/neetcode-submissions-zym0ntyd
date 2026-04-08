class Solution {
    private int rows, cols;
    private int[][] heights;
    private final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        // DFS from Pacific edges (top row and left column)
        for (int c = 0; c < cols; c++) dfs(0, c, pac);
        for (int r = 0; r < rows; r++) dfs(r, 0, pac);

        // DFS from Atlantic edges (bottom row and right column)
        for (int c = 0; c < cols; c++) dfs(rows - 1, c, atl);
        for (int r = 0; r < rows; r++) dfs(r, cols - 1, atl);

        // Collect intersection
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            // reverse traversal: we can go to neighbor only if neighbor height >= current
            if (!visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited);
            }
        }
    }
}
