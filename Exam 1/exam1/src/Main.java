import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main<E extends Comparable<E>> {
    public class Node<E> {
        E item;
        Node<E> next;
        Node<E> head;
        Node<E> tail;
        Node<E> prev;
        int size;
    }
    E item;
    Node<E> head = null;
    Node<E> tail = null;
    Node<E> next = null;
    Node<E> prev = null;
    int size = 0;

    public int minPlusMax(List<Integer> list){ // if a single linked list it is just O(n) if it is a
        // doubly linked list then it is O(n^2)
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < list.size();i++){
            int num = list.get(i);
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        return min+max;
    }
    public List<String> reverseWords(List<String> list) { // O(n)
        List<String> output = new ArrayList<>();
        for(String word: list){
            String reversed = " ";
            for(char c: word.toCharArray()){
                reversed = c + reversed;
            }
            output.add(reversed);
        }
        return output;
    }
    public void deleteList(){ // Goes through and changes each head to be null and then it changes
    //the tail to be null
        while(head != null) {
            head.prev = null;
            head = head.next;
        }
        tail = null;
        size = 0;
    }
    public int count(E item){ // O(n) is the run time for this one
        int total = 0;
        Node<E> current = head;
        while(current != null){
            if(current.item.equals(item)){
                total++;
            }

            current = current.next;

        }


        return total;
    }
    public static LinkedList<Integer> merge(List<Integer> listA, List<Integer> listB){ ;// This is O(n)
        LinkedList<Integer> out = new LinkedList<>();
        while(listA.size() > 0 && listB.size() > 0){
            if(listA.get(0) < listB.get(0)){
                out.add(listA.remove(0));
            } else {
                out.add(listB.remove(0));
            }
    }


        return out;
    }
    public void reverse(){ // this is how to reverse a doubly linked list THIS IS ON THE EXAM and
        // it will be as a "parsons puzzle"


    }
    /* 
    index out of bounds
    empty list
    adding head
    adding tail
    anything else
    */
    public void add(E item){
        Node<E> adding = new Node<>();
        if(size == 0){
            head = adding;
            tail = adding;
        } else if (item.compareTo(head.item) <= 0){ // adding head
            adding.next = head;
            head = adding;
        } else if (item.compareTo(tail.item) > 0){ // adding tail
            tail.next = adding;
            tail = adding;
        } else {
            Node<E> current = head;
            boolean done = false;
            while(!done){
                if(item.compareTo(current.next.item) < 0){
                    adding.next = current.next;
                    current.next = adding;
                    done = true;

                }
                current = current.next;

            }
        }
        size++;

    }
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> mylist = new ArrayList<>();

    }
}
