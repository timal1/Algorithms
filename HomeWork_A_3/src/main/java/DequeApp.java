

public class DequeApp<E> implements Deque<E> {

    protected final int DEFAULT_TAIL = -1;
    protected final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;
    protected int tail;
    protected int head;
    protected int start = 0;
    protected E x;

    public DequeApp(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public boolean insertLeft(Object value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        if (size < data.length) size++;
        for (int i = head; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[start] = (E) value;
        tail++;
        head++;
        return true;
    }

    @Override
    public boolean insertRight(Object value) {

        if (isFull()) {
            return false;
        }

        if (head == DEFAULT_TAIL) {
            head = data.length - 1;
        }

        data[++tail] = (E) value;
        size++;
        head++;
        return true;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (head == DEFAULT_TAIL) {
            head = data.length - 1;
        }

        E value = data[tail--];
        size--;
        head--;
        return value;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        if (tail == DEFAULT_TAIL) {
            tail = data.length - 1;
        }

        E value = data[start];
        for (int i = 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        tail--;
        head--;
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != (size - 1)) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
