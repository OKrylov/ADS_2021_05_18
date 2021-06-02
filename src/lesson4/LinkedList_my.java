package lesson4;

public interface LinkedList_my<E> extends LinkedList<E> {


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
