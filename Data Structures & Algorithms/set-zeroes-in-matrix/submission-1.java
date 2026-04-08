class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Detect if first row or column contain zero
        for (int r = 0; r < ROWS; r++) {
            if (matrix[r][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Use first row/col as markers
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;  // mark row
                    matrix[0][c] = 0;  // mark col
                }
            }
        }

        // Step 3: Zero out based on markers
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Step 4: Handle first row and first column separately
        if (firstRowZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstColZero) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
