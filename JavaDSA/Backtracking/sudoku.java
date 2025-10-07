class sudoku {
    
    public void solveSudoku(int[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][] boxUsed = new boolean[9][10];

        // Step 1: fill helper arrays with initial board numbers
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = board[r][c];
                if (num != 0) {
                    rowUsed[r][num] = true;
                    colUsed[c][num] = true;
                    boxUsed[(r / 3) * 3 + (c / 3)][num] = true;
                }
            }
        }

        // Step 2: start solving
        solve(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean solve(int[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][] boxUsed, int r, int c) {
        if (r == 9) return true;        // reached end, solved
        if (c == 9) return solve(board, rowUsed, colUsed, boxUsed, r + 1, 0);

        if (board[r][c] != 0) return solve(board, rowUsed, colUsed, boxUsed, r, c + 1);

        int boxIndex = (r / 3) * 3 + (c / 3);

        for (int num = 1; num <= 9; num++) {
            if (!rowUsed[r][num] && !colUsed[c][num] && !boxUsed[boxIndex][num]) {
                board[r][c] = num;
                rowUsed[r][num] = colUsed[c][num] = boxUsed[boxIndex][num] = true;

                if (solve(board, rowUsed, colUsed, boxUsed, r, c + 1)) return true;

                // backtrack
                board[r][c] = 0;
                rowUsed[r][num] = colUsed[c][num] = boxUsed[boxIndex][num] = false;
            }
        }

        return false;
    }

    // Helper method to print the sudoku board
    public void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("------+-------+------");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        sudoku solver = new sudoku();
        
        // Example Sudoku puzzle (0 represents empty cells)
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        
        System.out.println("Original Sudoku puzzle:");
        solver.printBoard(board);
        
        System.out.println("Solving...\n");
        solver.solveSudoku(board);
        
        System.out.println("Solved Sudoku:");
        solver.printBoard(board);
    }
}
