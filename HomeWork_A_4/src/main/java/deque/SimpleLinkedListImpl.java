package deque;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E>{
    protected Node<E> first;
    protected int size;

    @Override
    public void insertFirst(E value) {
        first = new Node<E>(value, first);
        size++;

    }

    @Override
    public E removeFirst() {
        if (isEmpty()){
            return null;
        }
        Node<E> removeNode = first;
        first = removeNode.next;
        removeNode.next = null;
        size--;
        return removeNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
           if (current.item.equals(value)) {
               break;
           }
           prev = current;
           current = current.next;
        }
        if (current == null) {
            return  false;
        } else if (current == first) {
            removeFirst();
            return  true;
        }
        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while ((current != null)) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
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
    public void display() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;
        while (current != null){
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private SimpleLinkedListImpl<E> list;
        private Node<E> current;
        private Node<E> previos;

        public LinkedListIterator(){
            this.list = SimpleLinkedListImpl.this;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {

            if (!hasNext()) {
                return null;
            }

            E value = current.item;
            previos = current;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            if (previos == null){
                list.first = current.next;
                reset();
            } else {
                previos.next = current.next;
                if (!hasNext()){
                    reset();
                } else {
                    current.next = null;
                }
            }

        }

        public void reset() {
            current = list.first;
            previos = null;

        }
    }
}
