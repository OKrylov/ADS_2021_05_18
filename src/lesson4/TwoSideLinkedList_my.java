package lesson4;

public interface TwoSideLinkedList_my<E> extends LinkedList_my_two_side_node<E> {

    void insertLast(E value);
    E getLast();
    E removeRight();

}
