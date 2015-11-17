package queuemanager;


public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {

    private final Object[] storage;

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
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    /**
     * Loops through and finds the highest priority item in the array
     * @return T
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {   
            Wrapper<T> max = (Wrapper<T>) storage[0];
            int maxIndex = 0;
            
            for(int i = 1; i <= tailIndex; i++)
            {
                Wrapper<T> item = ((Wrapper<T>) storage[i]);
                if(item.getPriority() > max.getPriority())
                {
                    max = item;
                    maxIndex = i;
                }
            }
            return ((Wrapper<T>) storage[maxIndex]).getItem();
        }
    }

    /**
     * Add new items directly to the end of the array
     * @param item
     * @param priority
     * @throws QueueOverflowException 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (tailIndex == capacity - 1) {
            /* No resizing implemented, but that would be a good enhancement. */
            throw new QueueOverflowException();
        } else {
            tailIndex = tailIndex + 1;
            int i = tailIndex;
            while (i > 0 && ((Wrapper<T>) storage[i - 1]).getPriority() == priority) {
                storage[i] = storage[i - 1];
                i = i - 1;
                tailIndex = priority;
            }
            storage[i] = new Wrapper<>(item, priority);
        }
    }

    /**
     * Searches for and removes the highest priority item
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int i = tailIndex;
            while (i > 0 && ((Wrapper<T>) storage[i - 1] != null)) {
                if(i > tailIndex) {
                    tailIndex = -1;
                }
            }
        }
    }
           
    /**
     * /Checks if the array is empty or not
     * @return true/false
     */
    @Override
    public boolean isEmpty() {
        return tailIndex <= -1;
    }

    /**
     * Displays details about the array in a user friendly manner
     * @return String
     */
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
