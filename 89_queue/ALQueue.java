/**
 * Team Purple Pineapples: Jason Zhou, Russell Goychayev, Marcus Wu
 * APCS pd. 7
 * HW89: Queue Two Ways
 * 2022-4-11
 * time spent: 0.3 hrs
 * 
 * QCC:
 * 
 * Disco: Let's goooo. O(1) for all operations 
 */

// credit goes to Max Schneider, Oscar Breen, Perry Huang for showing this us in the class discussion group thingy
import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {
    private ArrayList<T> _queue;
    private int _size;
    private int _pointerHead;

    public ALQueue() {
        this._queue = new ArrayList<T>();
        this._size = 0;
        this._pointerHead = 0;
    }

    public void enqueue(T element) {
        _queue.add(element);
        _size++;
    }

    public T dequeue() {
        T retVal = _queue.get(_pointerHead);
        _pointerHead++;
        _size--;
        return retVal;
    }

    public T peekFront() {
        return _queue.get(_pointerHead);
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public String toString() {
        return "First in soup line -> " + _queue.toString() + " <- Last in soup line";
    }
}