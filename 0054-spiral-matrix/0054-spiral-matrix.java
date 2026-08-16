class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int strow = 0;
        int endrow = m - 1;
        int stcol = 0;
        int endcol = n - 1;

        while (strow <= endrow && stcol <= endcol) {

            // Top row
            for (int col = stcol; col <= endcol; col++) {
                result.add(matrix[strow][col]);
            }
            strow++;

            // Right column
            for (int row = strow; row <= endrow; row++) {
                result.add(matrix[row][endcol]);
            }
            endcol--;

            // Bottom row
            if (strow <= endrow) {
                for (int col = endcol; col >= stcol; col--) {
                    result.add(matrix[endrow][col]);
                }
                endrow--;
            }

            // Left column
            if (stcol <= endcol) {
                for (int row = endrow; row >= strow; row--) {
                    result.add(matrix[row][stcol]);
                }
                stcol++;
            }
        }

        return result;
    }
}