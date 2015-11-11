/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author 09004316
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>{
    
    private final Object[] storage;
    private Node<T> head;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public SortedLinkedPriorityQueue(int size) {
        storage = new Object[size];
        head = null;
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (tailIndex == capacity - 1) {
            throw new QueueOverflowException();
        } else {   
            Node<T> newNode = null;   
            Node<T> prevNode = null;
            Node<T> node = head;
            
            while(node != null)
            {
                newNode.next = prevNode.next;
                prevNode.next = newNode;
                
                if(newNode.getPriority() > prevNode.getPriority())
                {
                    node.setNext(head);
                }
                //node.setNext(head);
                //head = newNode;
                //node = node.getNext();
                //newNode.setNext(node.getNext());
                //node.setNext(newNode);
                
                //node.getNext();
            }

        }
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {   
            Node<T> node = null;
            int maxIndex = 0;
            
            for(int i = 1; i <= tailIndex; i++)
            {
                Node<T> getNode = node;
                if(getNode.getPriority() > node.getPriority())
                {
                    node = getNode;
                    maxIndex = i;
                    node.getNext();
                 }
            }
        }
        return null;
    }
       

    @Override
    public void remove() throws QueueUnderflowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return tailIndex <= -1;
    }
    
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
    
}
