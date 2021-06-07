package my_lesson4;

import lesson3.queue.Queue;

public class LinkedQueueImpl_my<E> implements Queue<E> {

    private final TwoSideLinkedList_my<E> data;

    public LinkedQueueImpl_my() {
        this.data = new TwoSideLinkedListImpl_my<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
