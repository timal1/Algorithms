package queue;

public interface Queue<E> {



    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}
