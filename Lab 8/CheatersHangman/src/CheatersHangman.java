import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CheatersHangman {


    public static Map<Integer, List<String>> readWords(String filename) {
        Map<Integer, List<String>> wordsBySize = new HashMap<>();

        Scanner scanner;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e);
            return wordsBySize;
        }
        while(scanner.hasNextLine()){
            String word = scanner.nextLine();
            int length = word.length();
            if(wordsBySize.containsKey(length)) {
                wordsBySize.get(length).add(word);
            } else {
                List<String> l = new ArrayList<>();
                l.add(word);
                wordsBySize.put(length,l);
            }
        }
        return wordsBySize;
    }


    public static void game(List<String> wordList, int numGuesses) {
        int wordSize = wordList.get(0).length();
        Set<Character> guessedLetters = new HashSet<>();
        String boardState = "";
        for (int i = 0; i < wordSize; i++) {
            boardState+="_";
        }
        System.out.println("Current Board");
        System.out.println(boardState);
        Scanner scanner = new Scanner(System.in);
        boolean done =  false;
        while(!done){
            System.out.print("Take a guess: ");
            char guess = scanner.next().charAt(0);
            while(guessedLetters.contains(guess)){
                System.out.println("Letter already guessed!");
                System.out.print("Take a guess: ");
                guess = scanner.next().charAt(0);
            }
            
            guessedLetters.add(guess);
            Map<String, List<String>> families = new HashMap<>(genWordFamilies(wordList, guessedLetters));
            for (String family : families.keySet()) {
                System.out.println(family + " " + families.get(family));
            }
            
            String best = chooseBestFamily(families);
            
            String oldBoardState = boardState;
            boardState = best;
            if(oldBoardState.equals(boardState)){
                System.out.println("That letter is not part of the game");
                numGuesses--;
            }
            if(numGuesses == 0){
                System.out.println("Number of Guesses: " + numGuesses);
                System.out.println("Game Over!!");
                List<String> finalWords = families.get(boardState);
                String finalWord = finalWords.get(0);
                System.out.println("The word was: " + finalWord);
                done = true;
            }
            wordList = families.get(boardState);


            if(!boardState.contains("_")){
                System.out.println("You win the word was: " + boardState);
                done = true;
            }
            System.out.println("Number of Guesses: " + numGuesses);
            System.out.println(boardState);


        }
    }
    public static void gameSetup(){
        Map<Integer, List<String>> wordsBySize = readWords("/Users/koreyrodi/Desktop/Programming/CIS 2168/Lab 8/CheatersHangman/src/korey.txt");
        boolean done = false;
        while(!done){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose word length: ");
            int wordLength = scanner.nextInt();
            while(wordsBySize.containsKey(wordLength) == false){
                System.out.print("Try again: ");
                wordLength = scanner.nextInt();
        }
        System.out.println("Selected word length: " + wordLength);
        System.out.print("How many Guesses: ");
        int numGuesses = scanner.nextInt();
        System.out.println("Guesses: " + numGuesses);
        List<String> wordList = wordsBySize.get(wordLength);
        game(wordList, numGuesses);
        System.out.print("Do you want to keep playing? ");
        String keepPlaying = scanner.next();
        if(keepPlaying.equalsIgnoreCase("Yes")){
            gameSetup();
        } else {
            System.out.println("Thanks for playing!!");
            done = true;
        }

        }

    }

    public static Map<String, List<String>> genWordFamilies(List<String> wordList, Set<Character> guessedLetters){
        Map<String, List<String>> wordFamilies =  new HashMap<>();
        /* Go through each word in the word list; then go through each char in the word,
        if the char is in guessed letters you set add it to the pattern otherwise, its just "-"
        Then you add each word to the map with the associated pattern as the key */
        for(String word: wordList){
            String pattern = "";
            for(int i = 0; i < word.length();i++){
                if(guessedLetters.contains(word.charAt(i))){
                    pattern += word.charAt(i);
                } else {
                    pattern += "_";
                }
            }
            if(wordFamilies.containsKey(pattern)){
                wordFamilies.get(pattern).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                wordFamilies.put(pattern,list);

            }

        }
        return wordFamilies;
    }

    public static String chooseBestFamily(Map<String, List<String>>  wordFamilies) {
        /* Go through each word family, whichever 
        has the most number of values is the one you should pick 
        
        Set the initail size to 0 and then get the size of each list at each key,
        if it is more then you reset it to be that family*/
        String bestFamily = "";
        int initalSize = -1;
        for(String key: wordFamilies.keySet()){
            int size = wordFamilies.get(key).size();
            if(size > initalSize){
                initalSize = size;
                bestFamily = key;
            }

        }
        return bestFamily;
    }


    public static void main(String[] args) {
        gameSetup();


    }
}