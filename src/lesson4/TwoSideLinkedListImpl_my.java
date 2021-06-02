package lesson4;

import java.util.Iterator;

public class TwoSideLinkedListImpl_my<E> extends SimpleLinkedListImpl_my<E> implements TwoSideLinkedList_my<E> {

    private MyNode<E> lastElement;


    @Override
    public void insertLast(E value) {
        MyNode<E> newNode = new MyNode<>(value, null, lastElement);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }

        return removedValue;
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
            return removeFirst() != null;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }



    private E getValue(MyNode<E> node) {
        return node != null ? node.item : null;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return  null;
        }
        if (size == 1){
            E returned = lastElement.item;
            firstElement = null;
            lastElement = null;
            return returned;
        }
        E returned = lastElement.item;
        lastElement.previous.next = null;
        lastElement = lastElement.previous;
        lastElement.previous = null;

        return returned;
    }
}
