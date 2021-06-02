package lesson4;

import lesson4.LinkedList_my;

public interface TwoSideLinkedList_my<E> extends LinkedList_my<E> {

    void insertLast(E value);
    E getLast();
    E removeRight();

}
