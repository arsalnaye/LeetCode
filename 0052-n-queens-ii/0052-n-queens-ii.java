class Solution {

    static boolean isSafeToPlace(int row, int col, int n, char[][] board) {

        // Check left
        int c = col;
        while (c >= 0) {
            if (board[row][c] == 'Q') {
                return false;
            }
            c--;
        }

        // Check left upper diagonal
        int r = row;
        c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // Check left lower diagonal
        r = row;
        c = col;

        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r++;
            c--;
        }

        return true;
    }

    static int solve(char[][] board, int n, int col) {

        // All queens placed successfully
        if (col == n) {
            return 1;
        }

        int count = 0;

        // Try every row in current column
        for (int row = 0; row < n; row++) {

            if (isSafeToPlace(row, col, n, board)) {

                board[row][col] = 'Q';

                count += solve(board, n, col + 1);

                // Backtrack
                board[row][col] = '.';
            }
        }

        return count;
    }

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        return solve(board, n, 0);
    }
}