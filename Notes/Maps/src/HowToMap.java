import java.util.HashMap;
import java.util.Map;

public class HowToMap {
    public static char mostCommonChar(String text){
        Map<Character, Integer> counts = new HashMap<>();
        for(char c : text.toCharArray()){
            if(counts.containsKey(c)){
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        int mostCount = 0;
        char mostLetter = ' ';
        for(Character c : counts.keySet()){
            int count = counts.get(c);
            if(count > mostCount){
                mostCount = count;
                mostLetter = c;
            }
        }
        return mostLetter;
    }
    public static boolean isPermutation(String wordA, String wordB){
        if(wordA.length() != wordB.length()){
            return false;
        }
        Map<Character, Integer> countA = new HashMap<>();
        Map<Character, Integer> countB = new HashMap<>();

        for(Character c: wordA.toCharArray()){
            if(!countA.containsKey(c)){
                countA.put(c,1);
            } else {
                countA.put(c,countA.get(c)+ 1);
            }
        }
        for(Character c: wordB.toCharArray()){
            if(!countB.containsKey(c)){
                countB.put(c,1);
            } else {
                countB.put(c,countB.get(c)+ 1);
            }
        }
        return countA.equals(countB);
    }
    public static void main(String[] args) throws Exception {
       System.out.println(mostCommonChar("Hello RRRRR"));
       System.out.println(isPermutation("wolf", "flow"));
    }
}
