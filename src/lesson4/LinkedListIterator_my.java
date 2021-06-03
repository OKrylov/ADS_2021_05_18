package lesson4;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListIterator_my<E> implements Iterator<E>{
    private final SimpleLinkedListImpl_my<E> linkedList;
    private LinkedList_my_two_side_node.MyNode<E> previousNode;
    private LinkedList_my_two_side_node.MyNode<E> removedNode;
    private LinkedList_my_two_side_node.MyNode<E> currentNode;



    public LinkedListIterator_my(SimpleLinkedListImpl_my<E> linkedList) {
        this.linkedList = linkedList;
        this.currentNode = linkedList.firstElement;

    }


    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public E next() {
        if (this.currentNode == null) {
            throw new NullPointerException();
        }
        E item = this.currentNode.item;
        if (this.removedNode != null){
            this.previousNode = this.removedNode;
        }
        this.removedNode = this.currentNode;
        this.currentNode = this.currentNode.next;
        return item;
    }

    @Override
    public void remove() {
        if (this.removedNode == null) {
            return;
        }
        if (this.previousNode == null) {
            this.removedNode.next = null;
            this.linkedList.firstElement = this.currentNode;
            this.linkedList.size--;
            return;
        }
        this.removedNode.next = null;
        this.previousNode.next = this.currentNode;
        this.linkedList.size--;
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        Iterator.super.forEachRemaining(action);
    }
}