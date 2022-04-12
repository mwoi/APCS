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


import java.util.LinkedList;

import thing.LLNode;
import thing.LList;

public class LLQueue<T> implements Queue<T> {
    private LList<T> _queue;
    private LLNode<T> _pointer;
    private int _size;

    public LLQueue() {
        this._queue = new LList<T>();
        this._pointer = null;
        this._size = 0;
    }

    public void enqueue(T element) {
        if (_size == 0) {
            _queue.add(element);
            _pointer = _queue.getNode(0);
            
        } else {
            _pointer.setNext(new LLNode<T>(element, null));
            _pointer = _pointer.getNext();
        }
        _size++;
    }

    public T dequeue() {
        T retVal = _queue.get(0);
        _queue.remove(0);
        _size--;
        return retVal;
    }

    public T peekFront() {
        return _pointer.getCargo();
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public String toString() {
        return _queue.toString();
    }
}
