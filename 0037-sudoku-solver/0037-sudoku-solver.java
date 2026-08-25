class Solution {

    static boolean findEmpty(char[][] board, int[] emptycell) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptycell[0] = i;
                    emptycell[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean safe(char[][] board, char chvalue,
                        int rowidx, int colidx) {

        // Check same row
        for (int col = 0; col < 9; col++) {
            if (board[rowidx][col] == chvalue) {
                return false;
            }
        }

        // Check same column
        for (int row = 0; row < 9; row++) {
            if (board[row][colidx] == chvalue) {
                return false;
            }
        }

        // Check 3x3 sub-box
        int strow = rowidx - rowidx % 3;
        int stcol = colidx - colidx % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int actrow = strow + i;
                int actcol = stcol + j;

                if (board[actrow][actcol] == chvalue) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solveSudoku(char[][] board) {

        int[] emptycell = new int[2];

        // No empty cell => Sudoku solved
        if (!findEmpty(board, emptycell)) {
            return true;
        }

        int rowidx = emptycell[0];
        int colidx = emptycell[1];

        // Try values 1 to 9
        for (int value = 1; value <= 9; value++) {

            char chvalue = (char) (value + '0');

            if (safe(board, chvalue, rowidx, colidx)) {

                // Place value
                board[rowidx][colidx] = chvalue;

                // Recursively solve
                if (solveSudoku(board)) {
                    return true;
                }

                // Backtrack
                board[rowidx][colidx] = '.';
            }
        }

        return false;
    }
}