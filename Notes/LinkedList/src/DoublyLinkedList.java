public class DoublyLinkedList <E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList(){
        size = 0;
    }


    public boolean add(E item){
        this.add(size,item);
        return true;
    }
    // out of bounds
    // adding to empty list
    // adding a new head
    // adding a new tail
    // adding anywhere else
    public void add(int index, E item){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node <E> adding = new Node(item);
        if(size == 0){
            this.head = adding;
            this.tail = adding;
        } else if(index == 0){
            adding.next = head;
            head.prev = adding;
            head = adding;
        } else if(index == size){
            adding.prev = tail;
            tail.next = adding;
            tail = adding;
        } else {
            Node <E> before = getNode(index-1); 
            adding.next = before.next;
            adding.prev = before;
            before.next.prev = adding;
            before.next = adding;

        }
        size++;

    }
    public int size(){
        return size;
    }
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E toReturn = null;
        if(size == 1){
            toReturn = head.data;
            head = null;
            tail = null;

        } else if(index == 0){
            toReturn = head.data;
            head = head.next;
            head.prev = null;

        } else if(index == size){
            toReturn = tail.data;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<E> before = getNode(index - 1);
            toReturn = before.next.data;
            before.next = before.next.next;
            before.next.prev = before; 

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
            out += " <-> ";
            current = current.next;
        }
        return out;
    }
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
    }
}
