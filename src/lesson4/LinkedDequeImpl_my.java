package lesson4;

import lesson3.deque.Deque;

public class LinkedDequeImpl_my<E> implements Deque<E> {
    private final TwoSideLinkedList_my<E> data;

    public LinkedDequeImpl_my(){
        this.data = new TwoSideLinkedListImpl_my<>();
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
        return this.data.removeRight();
    }

    @Override
    public boolean insert(E value) {
        this.data.insertFirst(value);
        return true;
    }

    @Override
    public E remove() {

        return this.data.removeFirst();
    }

    @Override
    public E peekFront() {

        return this.data.getFirst();
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
