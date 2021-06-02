package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl_my<E> implements LinkedList_my<E> {
    protected int size;
    protected MyNode<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new MyNode<>(value, firstElement, null);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        MyNode<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;
        firstElement.previous = null;

        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        MyNode<E> current = firstElement;
        MyNode<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        }
        previous.next = current.next;
        previous.next.previous = previous;
        current.next = null;
        current.previous = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        return false;
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
    public void display() {

    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
