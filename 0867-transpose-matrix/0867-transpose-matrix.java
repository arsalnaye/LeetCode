class Solution {
    public int[][] transpose(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0][0];
        }
        int trows=matrix.length;
        int tcols=matrix[0].length;
        int newtrows=tcols;
        int newtcols=trows;
        int ans[][]=new int [newtrows][newtcols];
        for(int i=0;i<trows;i++){
            for(int j=0;j<tcols;j++){
                ans[j][i]=matrix[i][j];
            }
        }
        return ans;
    }
}