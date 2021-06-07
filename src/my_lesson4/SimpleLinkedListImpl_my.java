package my_lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl_my<E> implements LinkedList_my_two_side_node<E> {
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
        if (size != 1) {
            firstElement.previous = null;
        }

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

        MyNode<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (E item: this) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("----------");
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(MyNode<E> node) {
        return node != null ? node.item : null;
    }


    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator_my<>(this);
    }
}
