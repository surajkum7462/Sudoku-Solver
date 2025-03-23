class SudokuSolver {
  public static void main(String[] args) {
      char[][] board = {
          {'.', '.', '.', '2', '4', '.', '.', '.', '1'},
          {'3', '6', '.', '.', '.', '5', '.', '6', '.'},
          {'3', '6', '.', '.', '.', '.', '5', '7', '4'},
          {'.', '.', '3', '.', '8', '.', '.', '1', '.'},
          {'5', '.', '4', '.', '.', '.', '.', '.', '8'},
          {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
          {'.', '.', '.', '6', '.', '9', '.', '.', '.'},
          {'.', '.', '8', '.', '.', '.', '6', '.', '.'},
          {'.', '7', '.', '.', '4', '.', '.', '9', '2'}
      };

      System.out.println("Original Sudoku Board:");
      printBoard(board);

      if (solveSudoku(board)) {
          System.out.println("\nSolved Sudoku Board:");
          printBoard(board);
      } else {
          System.out.println("\nNo solution exists!");
      }
  }

  // Function to solve Sudoku using backtracking
  public static boolean solveSudoku(char[][] board) {
      for (int row = 0; row < 9; row++) {
          for (int col = 0; col < 9; col++) {
              if (board[row][col] == '.') {
                  for (char num = '1'; num <= '9'; num++) {
                      if (isValid(board, row, col, num)) {
                          board[row][col] = num;

                          if (solveSudoku(board)) {
                              return true;
                          } else {
                              board[row][col] = '.'; // Backtrack
                          }
                      }
                  }
                  return false; // No valid number found, backtrack
              }
          }
      }
      return true; // Solved successfully
  }

  // Function to check if placing a number is valid
  public static boolean isValid(char[][] board, int row, int col, char num) {
      for (int i = 0; i < 9; i++) {
          if (board[i][col] == num) return false; // Check column
          if (board[row][i] == num) return false; // Check row
          if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false; // Check 3x3 box
      }
      return true;
  }

  // Function to print the Sudoku board
  public static void printBoard(char[][] board) {
      for (int i = 0; i < 9; i++) {
          if (i % 3 == 0 && i != 0) {
              System.out.println("------+-------+------");
          }
          for (int j = 0; j < 9; j++) {
              if (j % 3 == 0 && j != 0) System.out.print("| ");
              System.out.print(board[i][j] + " ");
          }
          System.out.println();
      }
  }
}
