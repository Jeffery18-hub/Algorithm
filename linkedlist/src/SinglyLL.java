import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLL implements Iterable<Integer> {
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new It(head);
    }

    private static class It implements Iterator<Integer>{
        Node node;
        It(Node n){
            node = n;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return node!=null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            var ret = node.data;
            node = node.next;
            return ret;
        }
    }

    private static class Node{
        int data;
        Node next;

        Node (int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    Node head = null;
    // add the head node
    void prepend(int data){
        head = new Node(data, head);
    }

    //    //delete first occurrence of x in the list
    void removeFirst(int i){
        if(head == null) return;

        if( head !=null && head.data ==i){
            head = head.next;
            return;
        }

        for (Node n= head; n.next !=null; n= n.next){
            if (n.next.data == i){
                n.next = n.next.next;
                return;
            }
        }
    }

    //test
    public static void main(String[] args) {
        SinglyLL ssl = new SinglyLL();
        ssl.prepend(1);
        ssl.prepend(2);
        ssl.prepend(3);
        ssl.prepend(4);
        for (var x: ssl) {
            System.out.println(x);
        }

        System.out.println("--------------------------");

        // remove
        ssl.removeFirst(1);
        ssl.removeFirst(4);
        for (var x: ssl
             ) {
            System.out.println(x);

        }
    }
}
