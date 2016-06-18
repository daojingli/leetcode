/**
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled 
 * with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only 
 * the filled cells need to be validated.
 */

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, i, 0, 8)) return false;
            if (!isValid(board, 0, 8, i, i)) return false;
        }
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                if (!isValid(board, i*3, i*3 + 2, j*3, j*3 + 2)) return false;
        return true;    
    }

    // index xhi,  yhi are inclusive;
    private boolean isValid (char[][] board, int xlo, int xhi, int ylo, int yhi) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = xlo; i <= xhi; i++) 
            for(int j = ylo; j <= yhi; j++) 
                if (char[i][j] != '.') 
                    if (!set.add(char[i][j])) return false;
        return true;
    }
}