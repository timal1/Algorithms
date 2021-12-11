package deque;

import queue.Queue;

public interface Deque<E> extends Queue<E> {

    E peekFront();

    boolean isFull();

    void display();

    boolean insertLeft(E value);
    boolean insertRight(E value);


    E removeLeft();
    E removeRight();

}
