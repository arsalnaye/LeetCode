class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                char value = board[i][j];

                // Check row
                for (int col = 0; col < 9; col++) {
                    if (col != j && board[i][col] == value) {
                        return false;
                    }
                }

                // Check column
                for (int row = 0; row < 9; row++) {
                    if (row != i && board[row][j] == value) {
                        return false;
                    }
                }

                // Check 3x3 box
                int startRow = i - i % 3;
                int startCol = j - j % 3;

                for (int row = startRow; row < startRow + 3; row++) {
                    for (int col = startCol; col < startCol + 3; col++) {

                        if ((row != i || col != j) &&
                            board[row][col] == value) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}