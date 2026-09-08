import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinalExamHashQuestion {
    /*
    Given file formatted
    username loginLength
    alice 15
    bob 20
    alice 45
    bob 20
    ...
    Return average log in time for eadh user
     */

    public static Map<String, Double> calcAverage(String filename) throws Exception{
        Map<String,Double> totalTime = new HashMap<>();
        Map<String,Integer> numLogins = new HashMap<>();
        Map<String,Double> averages = new HashMap<>();

        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String [] part = line.split(" ");
            String username = part[0];
            Double time = Double.parseDouble(part[1]);

            if(totalTime.containsKey(username)){
                totalTime.put(username,totalTime.get(username) + time);
                numLogins.put(username,numLogins.get(username) + 1);
            } else {
                totalTime.put(username,time);
                numLogins.put(username,1);
            }

        }
        for(String user: numLogins.keySet()){
            averages.put(user,totalTime.get(user) / numLogins.get(user));
        }
        

        return averages;

    }
    public static void main(String[] args) throws Exception {
    }
}
