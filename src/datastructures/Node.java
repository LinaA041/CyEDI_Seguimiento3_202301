package datastructures;

public class Node <K,T> {

    public Node( K key,T value) {
        this.value = value;
        this.key = key;
    }

    private T value;

    private K key;

    private Node <K,T> left;

    private Node <K,T> right;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K, T> getLeft() {
        return left;
    }

    public void setLeft(Node<K, T> left) {
        this.left = left;
    }

    public Node<K, T> getRight() {
        return right;
    }

    public void setRight(Node<K, T> right) {
        this.right = right;
    }
}
