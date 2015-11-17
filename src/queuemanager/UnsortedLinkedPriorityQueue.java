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

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        Node<T> node = new Node<>(item, priority);
        Node<T> newN = null;
        
        newN = node;
        newN.setNext(head);
        head = newN;
    }

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

    @Override
    public boolean isEmpty() {
        return head == null;
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
         result += ", isEmpty() = " + isEmpty();
         if (!isEmpty()) {
                result += ", head() = " /** For testing purpose this is removed as it errors 
                 * + head */;
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
}
