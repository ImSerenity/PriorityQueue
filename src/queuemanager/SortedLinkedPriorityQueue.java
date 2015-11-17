package queuemanager;

/**
 *
 * @author 09004316
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>{
    
    private Node<T> head;

    public SortedLinkedPriorityQueue() {
        head = null;
    }

    
    /**
    * Method to loop through the list to find the correct position to add the new item in,
    * simply add it as the head if there is no other items
    * or set a new item as the head if it has a higher priority
    */
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

    /** 
     * Returns the head of the list quickly as it will
     * always be the first item
     * @return T
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return head.getItem();
        }     
    }
       

    /**
     * Removes the head of the list
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()) {
           throw new QueueUnderflowException();
        } else {
            head = head.getNext();
        }       
    }

    /**
     * Checks if the list is empty or not
     * @return true/false
     */
    @Override
    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Displays details about the list in a user friendly manner
     * @return String
     */
    @Override
    public String toString() {
        String result = "LinkedStack: size = " + size();
        result += ", contents = [";
        
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
    
    /**
     * Calculates the size of the list
     * @return int
     */
    private int size() {
        Node<T> node = head;
        int result = 0;
        while (node != null) {
            result = result + 1;
            node = node.getNext();
        }
        return result;
    }
}
