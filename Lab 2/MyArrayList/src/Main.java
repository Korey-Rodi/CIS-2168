import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static <E> boolean uniqueness(List<E> list){
        for(int i = 0; i < list.size();i++) {
            E firstItem = list.get(i);
            for(int k = i + 1; k < list.size(); k++)
                if(firstItem.equals(list.get(k))){
                    return false;
                }

        }
        return true;
    }
    // create a new list
    public static List<Integer>  allMultiples(List<Integer> list, int i){
        List<Integer> newList = new ArrayList<>();
        for(int j = 0; j < list.size(); j++){
            if(list.get(j) % i == 0){
                newList.add(list.get(j));
            }
        }
        return newList;
    }
    // "for each" loop can be used
    // create new list
    public static List<String>  allStrings(List<String> list, int i){
        List<String> newList = new ArrayList<>();
        for(int j = 0; j < list.size(); j++){
            String word = list.get(j);
            if(word.length() > i) {
                newList.add(list.get(j));      
            }
        }
        return newList;
    }
    public static <E extends Comparable <E>> boolean  isPermutation(List<E> list, List<E> list2){
        if(list.size() != list2.size()){
            return false;
        }
        Collections.sort(list);
        Collections.sort(list2);
        for(int i = 0; i < list.size(); i++){
            E item = list.get(i);
            E item2 = list.get(i);
            if(!item.equals(item2)){
                return false;
            }
        }        return true;
    }


        // First solution
    //     if(list.size() != list2.size()){
    //         return false;
    //     }
    //     int countA = 0;
    //     int countB = 0;
    //     for(E item : list){
    //         for(int i = 0; i < list.size() ; i++){
    //             E itemA = list.get(i);
    //             if(item.equals(itemA)){
    //                 countA++;

    //             }
    //         }
    //         }
    //         for(int i = 0; i < list.size() ; i++){
    //             E itemB = list.get(i);
    //             if(itemB.equals(itemB)){
    //                 countB++;

    //     }
    //     if(countA != countB){
    //         return false;
    //     }
    // }
    //     return true;


        // My solution to this problem
//         if(list.size() != list2.size()){
//             return false;
//         }
//         for(int i = 0; i < list.size(); i++) {
//             E firstCheck = list.get(i);
//             for(int k = i + 1; k < list.size(); k++)
//                 if(firstCheck.equals(list.get(k))){
//                     list.remove(k);
//                     i--;
//         }
//         for(int j = 0; j < list.size(); j++) {
//             E secondCheck = list2.get(i);
//             for(int k = i + 1; k < list2.size(); k++)
//                 if(secondCheck.equals(list2.get(k))){
//                     list.remove(k);
//                     i--;
        
//         if(list.size() == list2.size()){
//             return true;

//         }
//     }
// }
//         }
        // return true;
    // }
    // takes in a string
    public static List<String>  stringToListOfWords(String word){
        String regex = "\\s+";
        // add regex more to make it so that it removes punctuation
        List <String> newList = new ArrayList<>();
        String[] newAdds = word.split(regex);
        for(int j = 0; j < newAdds.length; j++){
            newList.add(newAdds[j]);
        }
        
        return newList;
    }
    // "Adding" for array lists is efficient
    // just iterate from the end instead of having counteract shifting
    public static <E> void removeAllInstances(List<E> list, int i){
        for(int j = 0; j < list.size(); j++){
            while(list.get(j).equals(i)){ // Does not move on from index until the item is removed
                list.remove(j);
            }
        }
       
    }

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(3);
        myList.add(4);
        System.out.println(uniqueness(myList));
        List<Integer> myList2 = new ArrayList<>();
        myList2.add(5);
        myList2.add(10);
        myList2.add(14);
        System.out.println(allMultiples(myList2, 5));
        List<String> myList3 = new ArrayList<>();
        myList3.add("Foo");
        myList3.add("boo");
        myList3.add("Baz");
        myList3.add("Hello");
        System.out.println(allStrings(myList3, 3));
        List<Integer> myList4a = new ArrayList<>();
        myList4a.add(1);
        myList4a.add(3);
        myList4a.add(4);
        List<Integer> myList4b = new ArrayList<>();
        myList4b.add(3);
        myList4b.add(4);
        myList4b.add(1);
        //myList4b.add(1);
        System.out.println(isPermutation(myList4a, myList4b));
        String problem5 = "Korey is the one who takes java";
        System.out.println(stringToListOfWords(problem5));
        List<Integer> myList6 = new ArrayList<>();
        myList6.add(6);
        myList6.add(6);
        myList6.add(7);
        myList6.add(8);
        removeAllInstances(myList6, 6);
        System.out.println(myList6);

    }
}
