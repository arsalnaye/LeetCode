class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int trow=matrix.length;
        int tcol=matrix[0].length;
        int n=trow*tcol;
        int s=0,e=n-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int rowidx=mid/tcol;
            int colidx=mid%tcol;
            if(matrix[rowidx][colidx]==target){
                return true;
            }
            else if(matrix[rowidx][colidx]>target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }return false;
    }
}