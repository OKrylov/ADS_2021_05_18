package lesson4;

import lesson3.deque.Deque;
import lesson3.queue.Queue;
import lesson3.stack.Stack;

import java.util.Iterator;

public class TestMain4 {

    public static void main(String[] args) {
//        testSimpleLinkedList(); //foreach iterator
//        testTwoSideLinkedList(); //foreach iterator
//        testLinkedStack();
//        testLinkedQueue();
        testLinkedDeque();

    }

    private static void testSimpleLinkedList() {
        System.out.println("------------testSimpleLinkedList-------------");
        LinkedList_my_two_side_node<Integer> linkedList = new SimpleLinkedListImpl_my<>();
        System.out.println("isEmpty = " + linkedList.isEmpty());
        System.out.println("size = " + linkedList.size());
        System.out.println("insertFirst 6");
        for (int i = 1; i < 7; i++) {
            linkedList.insertFirst(i);
        }

        linkedList.display();
        System.out.println("size = " + linkedList.size());
//
        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));
//
        System.out.println("remove value 3 = " + linkedList.remove(3));
        System.out.println("remove value 33 = " + linkedList.remove(33));
        System.out.println("getFirst = " + linkedList.getFirst());
        System.out.println("isEmpty = " + linkedList.isEmpty());
        System.out.println("size = " + linkedList.size());
        linkedList.display();
        System.out.println("size = " + linkedList.size());
        System.out.println("removeFirst 7");
        for (int i = 1; i < 8; i++) {
            System.out.println("removeFirst = " + linkedList.removeFirst());
            System.out.println("size = " + linkedList.size());
        }

        linkedList.display();

        System.out.println("size = " + linkedList.size());
        System.out.println("insertFirst 6");
        for (int i = 1; i < 7; i++) {
            linkedList.insertFirst(i);
        }

        linkedList.display();
        System.out.println("test foreach");
        for (Integer item: linkedList) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("test iterator remove 6,4,1");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item == 6 || item == 4 || item == 1){
                iterator.remove();
            }
        }
        linkedList.display();
        System.out.println("size = " + linkedList.size());
    }

    private static void testTwoSideLinkedList() {
        System.out.println("---------------testTwoSideLinkedList----------------");
        TwoSideLinkedList_my<Integer> linkedList = new TwoSideLinkedListImpl_my<>();
        System.out.println("isEmpty = " + linkedList.isEmpty());
        System.out.println("size = " + linkedList.size());
        System.out.println("insertFirst 4");
        for (int i = 1; i < 5; i++) {
            linkedList.insertFirst(i);
        }
        System.out.println("insertLast 3");
        for (int i = 5; i < 8; i++) {
            linkedList.insertLast(i);
        }

        linkedList.display();
        System.out.println("size = " + linkedList.size());
//
        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));
//
        System.out.println("remove value 4 = " + linkedList.remove(4));
        System.out.println("remove value 2 = " + linkedList.remove(2));
        System.out.println("remove value 7 = " + linkedList.remove(7));
        System.out.println("remove value 33 = " + linkedList.remove(33));
        System.out.println("getFirst = " + linkedList.getFirst());
        System.out.println("getLast = " + linkedList.getLast());
        System.out.println("isEmpty = " + linkedList.isEmpty());
        System.out.println("size = " + linkedList.size());
        linkedList.display();
        System.out.println("size = " + linkedList.size());
        System.out.println("removeFirst 7");
        for (int i = 1; i < 8; i++) {
            System.out.println("removeFirst = " + linkedList.removeFirst());
            System.out.println("size = " + linkedList.size());
        }
        System.out.println("insertLast 4");
        for (int i = 5; i < 9; i++) {
            linkedList.insertLast(i);
        }
        linkedList.display();
        System.out.println("removeRight 4");
        for (int i = 1; i < 5; i++) {
            System.out.println("removeRight = " + linkedList.removeRight());
            System.out.println("size = " + linkedList.size());
        }
//
        linkedList.display();

        System.out.println("size = " + linkedList.size());
        System.out.println("insertFirst 6");
        for (int i = 1; i < 7; i++) {
            linkedList.insertFirst(i);
        }

        linkedList.display();
        System.out.println("test foreach");
        for (Integer item: linkedList) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("size = " + linkedList.size());
        System.out.println();
        System.out.println("test iterator remove 6,4,1");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item == 6 || item == 4 || item == 1){
                iterator.remove();
            }
        }
        linkedList.display();
        System.out.println("size = " + linkedList.size());
    }

    private static void testLinkedStack() {
        System.out.println("------------testLinkedStack-------------");
        Stack<Integer> stack = new LinkedStackImpl_my<>();
        System.out.println("isEmpty = " + stack.isEmpty());
        System.out.println("size = " + stack.size());
        System.out.println("isFull = " + stack.isFull());
        System.out.println("push 6");
        for (int i = 1; i < 7; i++) {
            stack.push(i);
        }
        stack.display();
        System.out.println("pop 3");
        for (int i = 1; i < 4; i++) {
            System.out.println("pop = " + stack.pop());
        }
        System.out.println("peek = " + stack.peek());
        stack.display();
        System.out.println("isEmpty = " + stack.isEmpty());
        System.out.println("size = " + stack.size());
        System.out.println("isFull = " + stack.isFull());


        System.out.println("pop 3");
        for (int i = 1; i < 4; i++) {
            System.out.println("pop = " + stack.pop());
        }
        System.out.println("peek = " + stack.peek());
        stack.display();
        System.out.println("isEmpty = " + stack.isEmpty());
        System.out.println("size = " + stack.size());
        System.out.println("isFull = " + stack.isFull());

    }

    private static void testLinkedQueue() {
        System.out.println("------------testLinkedQueue-------------");
        Queue<Integer> queue = new LinkedQueueImpl_my<>();
        System.out.println("isEmpty = " + queue.isEmpty());
        System.out.println("size = " + queue.size());
        System.out.println("isFull = " + queue.isFull());
        for (int i = 1; i < 7; i++) {
            System.out.println("insert " + i + " " + queue.insert(i));
            System.out.println("size = " + queue.size());
        }
        System.out.println("peekFront " + queue.peekFront());
        System.out.println("isEmpty = " + queue.isEmpty());
        System.out.println("size = " + queue.size());
        System.out.println("isFull = " + queue.isFull());
        for (int i = 1; i < 10; i++) {
            System.out.println("remove " + queue.remove());
            System.out.println("size = " + queue.size());
        }
        System.out.println("isEmpty = " + queue.isEmpty());
        System.out.println("size = " + queue.size());
        System.out.println("isFull = " + queue.isFull());

    }

    private static void testLinkedDeque() {
        System.out.println("------------testLinkedDeque-------------");
        Deque<Integer> deque = new LinkedDequeImpl_my<>();
        System.out.println("isEmpty = " + deque.isEmpty());
        System.out.println("size = " + deque.size());
        System.out.println("isFull = " + deque.isFull());

        System.out.println("---------insert remove peekFront");
        for (int i = 1; i < 7; i++) {
            System.out.println("insert " + i + " " + deque.insert(i));
            System.out.println("size = " + deque.size());
        }
        System.out.println("peekFront " + deque.peekFront());
        System.out.println("isEmpty = " + deque.isEmpty());
        System.out.println("size = " + deque.size());
        System.out.println("isFull = " + deque.isFull());
        for (int i = 1; i < 10; i++) {
            System.out.println("remove " + deque.remove());
            System.out.println("size = " + deque.size());
        }
        System.out.println("isEmpty = " + deque.isEmpty());
        System.out.println("size = " + deque.size());
        System.out.println("isFull = " + deque.isFull());


        System.out.println("---------insertLeft removeLeft");
        for (int i = 1; i < 7; i++) {
            System.out.println("insertLeft " + i + " " + deque.insertLeft(i));
            System.out.println("size = " + deque.size());
        }
        System.out.println("isEmpty = " + deque.isEmpty());
        System.out.println("size = " + deque.size());
        System.out.println("isFull = " + deque.isFull());
        for (int i = 1; i < 10; i++) {
            System.out.println("removeLeft " + deque.removeLeft());
            System.out.println("size = " + deque.size());
        }
        System.out.println("isEmpty = " + deque.isEmpty());
        System.out.println("size = " + deque.size());
        System.out.println("isFull = " + deque.isFull());


        System.out.println("---------insertRight removeRight");
        for (int i = 1; i < 7; i++) {
            System.out.println("insertRight " + i + " " + deque.insertRight(i));
            System.out.println("size = " + deque.size());
        }
        System.out.println("isEmpty = " + deque.isEmpty());
        System.out.println("size = " + deque.size());
        System.out.println("isFull = " + deque.isFull());
        for (int i = 1; i < 10; i++) {
            System.out.println("removeRight " + deque.removeRight());
            System.out.println("size = " + deque.size());
        }
        System.out.println("isEmpty = " + deque.isEmpty());
        System.out.println("size = " + deque.size());
        System.out.println("isFull = " + deque.isFull());

    }
}
