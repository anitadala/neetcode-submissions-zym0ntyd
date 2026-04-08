class Solution {
    public void rotate(int[][] matrix) {
        // reverse the matrix 
        reverse(matrix);
        transpose(matrix);
    }
    
    public void reverse(int[][] matrix){
        int k= matrix[0].length-1;
        for(int i=0;i<matrix.length/2;i++){
            for(int j=0;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[k][j];
                matrix[k][j] = temp;
            }
            k--;
        }
    }
    private void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
