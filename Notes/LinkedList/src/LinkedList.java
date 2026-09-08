public class LinkedList<E> {
    private int size;
    private Node <E> head;
    
    public LinkedList(){
        size = 0;
        head = null;
    }
    public int size(){
        return size;
    }
    public boolean add(E item){
        this.add(size,item);
        return true;

    }
    // index out of bounds
    // adding a new head
    // adding anywhere else
    public void add(int index, E item){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node <E> adding = new Node(item);
        if(index == 0){
            adding.next = head;
            head = adding;

        } else {
            Node <E> before = getNode(index - 1);
            adding.next = before.next;
            before.next = adding;
        }
        size++;


    }
    // index out of bounds
    // removing the head
    // removing anywhere else
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E toReturn = null;
        if(index == 0){
            toReturn = head.data;
            head = head.next;
        } else {
            Node<E> before = getNode(index-1);
            toReturn = before.next.data;
            before.next = before.next.next;
        }

        size--;
        return toReturn;
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return getNode(index).data;

    }
    public E set(int index, E item){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> target = getNode(index);
        E oldData = target.data;
        target.data = item;
        return oldData;
    }
    public Node <E> getNode(int index){
        Node <E> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;


    }
    public String toString(){
        String out = " ";
        Node<E> current = head;
        while(current!= null){
            out += current.data;
            out += " -> ";
            current = current.next;
        }
        return out;
    }
    private static class Node<E>{ // Inner class
        private E data;
        private Node <E> next; // Has a reference to the memory location of the node after this one

        public Node(E data){
            this.data = data;
        }

    }
    public static void main(String[] args) {
        LinkedList <Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(2,2);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }
}
