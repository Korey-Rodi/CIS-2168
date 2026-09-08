import java.util.LinkedList;

import org.w3c.dom.Node;

public void BFS(){
    BFS(this.root);

}

public void BFS(Node<E> root){
    Queue<Node <E>> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()){
        Node<E> current = q.poll();
        if(current != null){
            System.out.println(current.item);
            q.offer(current.left);
            q.offer(current.right);
        }
    }
}