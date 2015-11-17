/**
 * Getters and setters for using Node<> for LinkedList Implementations
 */
package queuemanager;

public class Node<T> {
    private T item;
    private Node<T> next;
    private int priority;
    
    public Node(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }
    
    public T getItem() {
        return item;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> node) {
        this.next = node;
    }

    public int getPriority() {
        return priority;
    }
     
}

