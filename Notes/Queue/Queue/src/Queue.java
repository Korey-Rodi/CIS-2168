public class Queue<E> {
    private Node<E> front;
    private Node<E> back;

    public boolean isEmpty(){
        return front == null;
    }
    public E peek(){
        return front.item;
    }
    // removes front of queue
    public E poll(){
        E toReturn = front.item;
        if(front == back){
            front = null;
            back = null;
        } else {
            front = front.next;
        }
        return toReturn;
    }
    // adds to back
    public boolean offer(E item){
        Node<E> temp = new Node<>(item);
        if(this.isEmpty()) {
            front = temp;
            back = temp;
        } else {
            back.next = temp;
            back = temp;
        }
        return true;
    }
    private static class Node<E> {
        Node<E> next; // Technically points to the node behind you
        E item;

        private Node(E item){
            this.item = item;
        }
    }


    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        for(int i = 0; i < 10; i++){
            q.offer(i);
        }
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
        // 0 goes in first and is the first one printed.

    }
}
