class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int trow=matrix.length;
        int tcol=matrix[0].length;
        int row=0,col=tcol-1;
        while(row<trow && col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }return false;
    }
}