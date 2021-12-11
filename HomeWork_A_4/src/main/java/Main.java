import deque.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        testDequeApp();
        testIterator();
        testHomeWork();
    }

    private static void testDequeApp() {

        LinkedDeque<Integer> deque = new LinkedDeque<>();

        System.out.println("add element: " + deque.insertLeft(34));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(12));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(20));
        deque.display();
        System.out.println("add element: " + deque.insertRight(16));
        deque.display();
        System.out.println("add element: " + deque.insertRight(14));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(17));
        deque.display();
        System.out.println("remove: " + deque.removeLeft());
        deque.display();
        System.out.println("remove: " + deque.removeRight());
        deque.display();
        System.out.println("remove: " + deque.removeRight());
        deque.display();


//        Iterator<Integer> iterator = deque.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            System.out.println(integer);
//        }


    }

    private static void testIterator() {

        List<Integer> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7 );

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }

    private static void testHomeWork() {
        //ДОЛЖНО РАБОТАТЬ! Iterable - LinkedListIterator impl Iterator
//        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
//       for (Integer value : linkedList) {
//            System.out.println("value: " + value);
//        }


    }

}
