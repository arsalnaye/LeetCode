class Solution {

    static boolean isSafeToPlace(int rowidx, int colidx, int n, char[][] board) {

        // Check left
        int row = rowidx;
        int col = colidx;

        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        // Check left upper diagonal
        row = rowidx;
        col = colidx;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        // Check left lower diagonal
        row = rowidx;
        col = colidx;

        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    static void solve(char[][] board, int n, int colidx,
                      List<List<String>> ans) {

        // All queens placed
        if (colidx >= n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try placing queen in every row of current column
        for (int rowidx = 0; rowidx < n; rowidx++) {

            if (isSafeToPlace(rowidx, colidx, n, board)) {

                board[rowidx][colidx] = 'Q';

                solve(board, n, colidx + 1, ans);

                // Backtrack
                board[rowidx][colidx] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();

        solve(board, n, 0, ans);

        return ans;
    }
}