class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];

        // row + col ranges from 0 to 2n - 2
        boolean[] diag1 = new boolean[2 * n];

        // row - col can be negative,
        // so we add n to shift it
        boolean[] diag2 = new boolean[2 * n];

        backtrack(0, n, board, cols, diag1, diag2);

        return result;
    }

    private void backtrack(
        int row,
        int n,
        char[][] board,
        boolean[] cols,
        boolean[] diag1,
        boolean[] diag2
    ) {

        // All queens have been placed
        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            result.add(current);
            return;
        }

        // Try every column in current row
        for (int col = 0; col < n; col++) {

            // Check if position is safe
            if (cols[col] ||
                diag1[row + col] ||
                diag2[row - col + n]) {

                continue;
            }

            // Place queen
            board[row][col] = 'Q';

            cols[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n] = true;

            // Move to next row
            backtrack(
                row + 1,
                n,
                board,
                cols,
                diag1,
                diag2
            );

            // BACKTRACK
            board[row][col] = '.';

            cols[col] = false;
            diag1[row + col] = false;
            diag2[row - col + n] = false;
        }
    }
}