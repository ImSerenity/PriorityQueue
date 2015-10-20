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
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    private final Object[] storage;
    
    private final int capacity;
    
    private int tailIndex;

    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if(tailIndex == capacity - 1)
        {
            throw new UnsupportedOperationException();
        }
        else
        {
            tailIndex = tailIndex + 1;
            int i = tailIndex;
            while (i > 0 && ((Wrapper<T>) storage[i - 1]).getPriority() == item)
            {
                storage[i] = storage[i - 1];
                i = i - 1;
            }
            storage[i] = new Wrapper<>(item, priority);
        }
    }

    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty())
        {
            throw new UnsupportedOperationException();
        }
        else
        {
            return ((Wrapper<T>) storage[0]).getItem();
        }
        
    }

    @Override
    public void remove() throws QueueUnderflowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return tailIndex <= -1;
    }
    
}
