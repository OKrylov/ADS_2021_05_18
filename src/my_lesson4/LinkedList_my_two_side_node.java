package my_lesson4;

public interface LinkedList_my_two_side_node<E> extends Iterable<E> {
    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class MyNode<E> {
        E item;
        MyNode<E> next;
        MyNode<E> previous;

        public MyNode(E item, MyNode<E> next, MyNode<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

}
