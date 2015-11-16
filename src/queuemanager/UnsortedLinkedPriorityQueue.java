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
        
        while (node.getNext() != null) {
            node.setNext(node);
            node = node.getNext();
        }
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
           // for(Node<T> node = head; node != null; node = node.getNext()) {
              //  if(node.getNext().getPriority() > node.getPriority())
              //  {
              //      return node.getItem();
             //   }
          //  }
          return null;
        }
    } 
    
       

    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()) {
           throw new QueueUnderflowException();
        } else {
            if(head != null) {
    
                Node<T> node = head;
                
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
