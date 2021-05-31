package lesson4;

import lesson3.deque.Deque;

public class MyLinkedDequeImpl<E> implements Deque<E> {
    private final TwoSideLinkedList<E> data;

    public MyLinkedDequeImpl(){
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insertLeft(E value) {
        this.data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        this.data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return this.data.removeFirst();
    }

    @Override
    public E removeRight() {
        return this.data.re;
    }

    @Override
    public boolean insert(E value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
