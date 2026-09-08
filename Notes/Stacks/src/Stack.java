public class Stack <E> {
    private Node<E> top;

    public E pop(){
        E toReturn = top.item;
        top = top.next;
        return toReturn;
    }

    public void push(E item){
        Node<E> adding = new Node<>(item);
        adding.next = top;
        top = adding;

    }
    public E peek(){
        return top.item;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        } else {
            return false;
        }
    }
    private static class Node<E> {
        Node<E> next;
        E item;
        public Node(E item){
            this.item = item;
        }
    }
}
