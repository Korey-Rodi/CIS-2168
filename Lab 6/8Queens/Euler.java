import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Euler {
    public static int count = 0;
    public static int [][] Board = new int [9][9];


    public static void readBoard(Scanner scanner) throws FileNotFoundException{
        while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        if(line.contains("Grid")){
            populateBoard(scanner);
            break;
            }
        }
    }
    // This is not needed but was used to verify that it worked
    public static void printBoard(){
        for(int i = 0; i < Board.length; i++){
            for(int j = 0; j < Board.length;j++){
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void populateBoard(Scanner scanner){
        for(int i = 0; i < Board.length; i++){
            String line = scanner.nextLine();
            for(int j = 0; j < Board.length; j++){
                Board[i][j] = Character.getNumericValue(line.charAt(j)); // To convert from ascii value
                
            }
            }

    }
    public static boolean solve(int row, int col){
        if(col == Board.length) { // If reached last column move to next row
            col = 0;
            row++;
        }
        if(row == Board.length){ // Board is solved
            return true;
        }
        if(Board[row][col] != 0){ // Checks if the cell is filled and then moved to the next
            return solve(row, col+1);
        }
        for(int num = 1; num <= Board.length;num++){
            if(isValid(row, col, num)) {
                Board[row][col] = num;
                if(solve(row, col+1)){
                    return true;
                }
                Board[row][col] = 0;
            }

        }
        return false;
    }
    public static boolean isValid(int row, int col, int num){
        // Get the start of the 3x3 grid
        int localRow = row - row % 3;
        int localCol = col - col % 3;
        for(int i = 0; i < Board.length; i++){ // Row check
            if(Board[row][i] == num){
                return false;
            }
        }
        for(int i = 0; i < Board.length; i++) { // Column Check
            if(Board[i][col] == num){
                return false;
            }
        }
        for(int i = localRow; i < localRow + 3; i++){ // Verify Box
            // Grab localrow index and goes checks the next 3
            for(int j = localCol; j < localCol + 3; j++){
                // Grab localCol index and checks the next 3
                if(Board[i][j]== num) {
                    return false;
                }
            }

        }
        return true;
    }
    public static int returnCount(){
        int hundreds = Board[0][0] * 100;
        int tens = Board[0][1] * 10 ;
        int ones = Board[0][2];
        count += hundreds + tens + ones;
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/koreyrodi/Desktop/Programming/CIS 2168/Lab 6/Euler.txt";
        Scanner scanner = new Scanner(new File(fileName));
        for(int i = 0; i < 50;i++){
            readBoard(scanner);
            solve(0, 0);
            returnCount();
        }
        System.out.println(count);
    }
    
}
