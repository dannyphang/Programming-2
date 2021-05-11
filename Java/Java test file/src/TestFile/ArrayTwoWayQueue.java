package TestFile;

@SuppressWarnings("unchecked")

public class ArrayTwoWayQueue<T> implements TwoWayQueueInterface<T>{
    private T[] array;
    private int length;
    private final static int MAX_CAPACITY = 50;
    
    public ArrayTwoWayQueue(){
        array = (T[]) new Object[MAX_CAPACITY];
        length = 0;
    }
    
    @Override
    public boolean addAtFront(T object) {
        length++;
        for(int i = length - 2; i < length - 1; i--){
            array[i] = array[i-1];
        }
        array[0] = object;
        return true;
    }

    @Override
    public boolean addAtEnd(T object) {
        array[length] = object;
        length++;
        return true;
    }
    
}
