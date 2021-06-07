package my_lesson4;

import lesson3.stack.Stack;

public class LinkedStackImpl_my<E> implements Stack<E> {

    private final LinkedList_my_two_side_node<E> data;

    public LinkedStackImpl_my() {
        this.data = new SimpleLinkedListImpl_my<>();
    }

    @Override
    public void push(E value) {
        data.insertFirst(value);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
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

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedStackImpl_my{" +
                "data=" + data +
                '}';
    }
}
