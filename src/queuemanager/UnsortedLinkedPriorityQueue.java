package queuemanager;

/**
 *
 * @author 09004316
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T>{
    
    private Node<T> head;

    public UnsortedLinkedPriorityQueue() {
        head = null;
    }

    /**
     * Add new items directly to the end of the list
     * @param item
     * @param priority
     * @throws QueueOverflowException 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        Node<T> node = new Node<>(item, priority);
        Node<T> newN = null;
        
        newN = node;
        newN.setNext(head);
        head = newN;
    }

    /**
     * Loops through the list to find the highest priority item
     * @return T
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            Node<T> current = head;
            
            while(current != null && current != head) {
                if(current.getNext().getPriority()>= current.getPriority())
                {
                    head = current;
                } else {
                    current = current.getNext();
                }       
            } 
            return head.getItem();
        }
    }

    /**
     * Loops through to find the head (highest priority) of the list and removes it
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()) {
           throw new QueueUnderflowException();
        } else {
            for(Node<T> node = head; node != null; node = node.getNext()) { 
                
                if(head.getPriority() > head.getNext().getPriority()) {
                    node.setNext(node.getNext().getNext());
                }
            }
        }
    }

    /**
     * Checks if the list is empty or not
     * @return true/false
     */
    @Override
    public boolean isEmpty() {
        return head == null;
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
         result += ", isEmpty() = " + isEmpty();
         if (!isEmpty()) {
                result += ", head() = " /** For testing purpose this is removed as it errors 
                 * + head */;
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
