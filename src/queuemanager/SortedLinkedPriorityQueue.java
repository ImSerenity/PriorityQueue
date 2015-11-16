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

    public SortedLinkedPriorityQueue() {
        head = null;
    }

    @Override
    public void add(T item, int priority) {
        //System.out.println("Node1: " + newNode);
        Node<T> node = new Node<>(item, priority);
        //System.out.println("Node: " + newN.getItem() + "Node Priority: " + newN.getPriority());
        //Loop until target found
        while (node.getNext() != null && !node.getNext().equals(node)) {
            Node<T> newN = head;

            if(newN.getPriority() > head.getPriority()) {
                newN.setNext(head);
                head = newN;        
                System.out.println("Head: " + head.getItem());
            }   
        }
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return head.getItem();
        }     
    }
       

    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()) {
           throw new QueueUnderflowException();
        } else {
            head = head.getNext();
        }       
    }

    @Override
    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
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
                result += ", head() = " + head;
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
