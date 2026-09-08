public class Queens {
    public static String[][] board = new String[8][8];


    public static boolean solve(int col){
        // If reached last col problem is solved
        if(col == board.length){
            return true;
        }
        // Trying every row in a column
        for (int row = 0; row < board.length; row++){
            if (isValid(row, col) == true){ // Check if place is possible
                board[row][col] = "[Q]";
                if (solve(col + 1)){ // Tries the next column
                    return true;
                }
                board[row][col] = "[X]"; // set back to OG
            }
        }
        return false; // backtrack
    }
    public static boolean isValid(int row, int col){
        for(int i = 0; i < col; i++){ // Left Check
            if(board[row][i].equals("[Q]")) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--){ // Upper Left check
             if(board[i][j].equals("[Q]")) {
                return false;
            }
        }
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++,j--){ // Lower Left check
             if(board[i][j].equals("[Q]")) {
                return false;
            }
        }
        return true;
    }
    public static void fillBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length;j++){
                board[i][j] = "[X]";
            }
        }
    }
    public static void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        fillBoard();
        System.out.println("Base Board \n");
        printBoard();
        System.out.println();
        solve(0);
        System.out.println("Solved board \n");
        printBoard();
    }

}
