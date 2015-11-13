/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 09004316
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>{
    
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
        capacity = size;
        tailIndex = -1;
        head = null;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (tailIndex == capacity - 1) {
            throw new QueueOverflowException();
        } else {   
            //System.out.println("Node1: " + newNode);
            Node<T> newN = new Node<>(item, head, priority);
            System.out.println("Node: " + newN.getItem() + "Node Priority: " + newN.getPriority());
            //Loop until target found
            for (Node<T> node = head; node != null; node = node.getNext())
            {
                newN.setNext(head);
                head = newN;
                node = node.next;
                newN.setNext(node.next);
                node.setNext(newN);             
        
            }
        }
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {   
            
            for(int i = 1; i <= tailIndex; i++)
            {
                //if(node.next.getItem() >= head.next.getItem())
                {
                    Node<T> node = head;
                    head = node.getNext();
                }
            }
        }
        return head;
    }
       

    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()) {
           throw new QueueUnderflowException();
        } else {
            Node<T> node = head;
            head = node.getNext();
            head = null;
            node.getNext();
            node.setNext(node.next);
        }       
    }

    @Override
    public boolean isEmpty() {
        return tailIndex <= -1;
    }
    
    @Override
    public String toString() {
        String result = "LinkedStack: size = " + size();
        result += ", contents = [";
        //for (int i = 0; i <= tailIndex; i++) {
        //    if (i > 0) {
        //        result = result + ", ";
        //    }
           // result = result + storage[i];
      //  }
        
         for (Node<T> node = head; node != null; node = node.getNext()) {
            if (node != head) {
                
                result += ", ";
            }
            result += node.getItem();    
            result = result + "]";  
        }
         result += "], isEmpty() = " + isEmpty();
         if (!isEmpty()) {
            try {
                result += ", head() = " + head();
            } catch (QueueUnderflowException ex) {
                Logger.getLogger(SortedLinkedPriorityQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         return result;
    }
    
    private int size() {
        Node<T> node = head;
        int result = 0;
        while (node != null) {
            result = result + 1;
            node = node.getNext();
        }
        return result;
    }
    
    //Example code so I can kind of maybe understand how to do the code
    //Search stack for identical item to target and remove it
    public void removeSpec(T target) {
        
        if(head != null) {
            if (head.getItem().equals(target))
            {
                head = head.getNext();
            } else {
                
                //List is not empty and the first item is not the targer
                Node<T> node = head;

                //Loop until target found
                while (node.getNext() != null && !node.getNext().getItem().equals(target)) {
                    node = node.getNext();
                }

                if(node.getNext() != null) {
                    node.setNext(node.getNext().getNext());
                }
            }
        }
    }
}
