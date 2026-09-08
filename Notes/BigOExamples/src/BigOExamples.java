import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BigOExamples {
    // Bubble sort
    // 4 2 1 3 8 3 7 5 
    // 2 4 1 3 8 3 7 5 --> first pair sorted

    public static <T extends Comparable<T>> void bubbleSort(List<T> list){ // Quadratic sorting algorithm

        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for(int i = 0; i < list.size()- 1; i++){
            T left = list.get(i);
            T right = list.get(i + 1);
            if(left.compareTo(right) > 0) {
                list.set(i, right);
                list.set(i + 1, left);
                swapped = true;
            }

        }
        }

    }
    public static <E> int howBig(ArrayList<E> list) { // Constant Time O(1)
        return list.size();

    }
    public static int sum(ArrayList<Integer> list) { // Linear time O(n)
        int total = 0;
        for(int i = 0; i < list.size(); i++){ // n
            for(int j = 0; j < 10000; j++){
            System.out.println("");
        }
            total += list.get(i); // O(1)

        }
        return total;
    }
    public static <E> boolean in(ArrayList<E> list, E item) { // Linear Time O(n)
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < 10000; j++){
                System.out.print("");
            }
            if(list.get(i).equals(item)){
                return true;
            }
        }
        return false;
    }
    // public static <E> boolean allUnique(ArrayList<E> list) { // Quadratic Time O(n^2) 
    //     for(int i = 0; i < list.size(); i++){ // n
    //         E firstItem = list.get(i); // O(1)
    //         for(int j = 0; j < list.size(); j++){ // n
    //             if(i == j){
    //                 continue;
    //             }
    //             E secondItem = list.get(j); // O(1)
    //             if(firstItem.equals(secondItem)){ // O(1)
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    /*
    [1,2,3,4,5,6] --> true
    *
    **
    ***
    ****
    *****
    ******
    1 + 2 + 3 + 4 + 5 + 6 ... (n-1) + n = n(n+1)/2
    T(n) = O(n^2)
     */
    // public static <E> boolean allUnique(ArrayList<E> list) { // Quadratic Time O(n^2) 
    //     for(int i = 0; i < list.size(); i++){
    //         for(int j = i + 1; j < list.size(); j++){
    //             if(list.get(i).equals(list.get(j))){
    //                 return false;
    //             }
    //         }
    //     }
    //      return true;
    // }
    public static <E> boolean allUnique(ArrayList<E> list) { // Linear time O(n)
        Set<E> set = new HashSet<>();
        for( E item: list){
            boolean couldAdd = set.add(item);
            if(couldAdd == false){
                return false;
            }
        }
         return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 100000; i++){
            list.add(r.nextInt(1000000));
        }
        //ArrayList<Integer> list = new ArrayList<>();
        // for(int i = 0; i < 1000; i++){
        //     list.add(i);
        // }
        long start = System.currentTimeMillis();
        //howBig(list);
        //in(list, -13);
        //System.out.println(sum(list));
        //list.add(0);
        //System.out.println(allUnique(list));
        //bubbleSort(list);
        Collections.sort(list);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    
}
