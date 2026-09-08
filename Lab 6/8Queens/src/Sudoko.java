public class Sudoko {
    public static int[][] board = {{5,3,0,0,7,0,0,0,0},
                                  {6,0,0,1,9,5,0,0,0},
                                  {0,9,8,0,0,0,0,6,0},
                                  {8,0,0,0,6,0,0,0,3},
                                  {4,0,0,8,0,3,0,0,1},
                                  {7,0,0,0,2,0,0,0,6},
                                  {0,6,0,0,0,0,2,8,0},
                                  {0,0,0,4,1,9,0,0,5},
                                  {0,0,0,0,8,0,0,7,9}};

    public static boolean solve(int row, int col){
        if(col == board.length) { // If reached last column move to next row
            col = 0;
            row++;
        }
        if(row == board.length){ // Board is solved
            return true;
        }
        if(board[row][col] != 0){ // Checks if the cell is filled and then moved to the next
            return solve(row, col+1);
        }
        for(int num = 1; num <= board.length;num++){
            if(isValid(row, col, num)) {
                board[row][col] = num;
                if(solve(row, col+1)){
                    return true;
                }
                board[row][col] = 0;
            }

        }
        return false;
    }
    public static boolean isValid(int row, int col, int num){
        // Get the start of the 3x3 grid
        int localRow = row - row % 3;
        int localCol = col - col % 3;
        for(int i = 0; i < board.length; i++){ // Row check
            if(board[row][i] == num){
                return false;
            }
        }
        for(int i = 0; i < board.length; i++) { // Column Check
            if(board[i][col] == num){
                return false;
            }
        }
        for(int i = localRow; i < localRow + 3; i++){ // Verify Box
            // Grab localrow index and goes checks the next 3
            for(int j = localCol; j < localCol + 3; j++){
                // Grab localCol index and checks the next 3
                if(board[i][j]== num) {
                    return false;
                }
            }

        }
        return true;
    }
    /*
         Sudoku Puzzle
    -- 5 3 0 0 7 0 0 0 0
    -- 6 0 0 1 9 5 0 0 0
    -- 0 9 8 0 0 0 0 6 0
    -- 8 0 0 0 6 0 0 0 3
    -- 4 0 0 8 0 3 0 0 1
    -- 7 0 0 0 2 0 0 0 6
    -- 0 6 0 0 0 0 2 8 0
    -- 0 0 0 4 1 9 0 0 5
    -- 0 0 0 0 8 0 0 7 9
     */

    public static void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Sudoko Puzzle");
        printBoard();
        solve(0,0);
        System.out.println("\nSolved Puzzle");
        printBoard();
    }
}
