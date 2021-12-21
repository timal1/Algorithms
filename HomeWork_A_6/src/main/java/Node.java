public class Node<T extends Comparable<? super T>> {
    private T value;
    private int repeatCount;
    private boolean isRepeat;
    private boolean isRemove;

    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(T value) {
        return getValue().compareTo(value) > 0;
    }


    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
//        return getRightChild() == null && getLeftChild() != null
//                || getRightChild() != null && getLeftChild() == null;
        return getLeftChild() != null ^ getRightChild() != null;
    }



}
