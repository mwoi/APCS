/*
Team Purple Pineapples: Jason Zhou, Marcus Wu, Russell Goychayev
APCS
HW90 - Swabbing the Deque
04/12/2022
time spent: 69 centuries
*/

import java.util.ArrayList;

public class ALDequeueue<T> implements Deque<T> {
  private ArrayList<T> _deque;

  public ALDequeueue() {
    this._deque = new ArrayList<T>();
  }

  public void addFirst(T e) {
    _deque.add(0, e);
  }

  public void addLast(T e) {
    _deque.add(_deque.size(), e);
  }

  public T getFirst() {
    return _deque.get(0);
  }

  public T getLast() {
    return _deque.get(_deque.size() - 1);
  }

  public T removeFirst() {
    return _deque.remove(0);
  }

  public T removeLast() {
    return _deque.remove(_deque.size() - 1);
  }

  public boolean isEmpty() {
    return _deque.size() == 0;
  }

  public int size() {
    return _deque.size();
  }

  public boolean contains(Object e) {
    return _deque.contains(e);
  }

  public boolean remove(Object e) {
    return _deque.remove(e);
  }

  public String toString() {
    return _deque.toString();
  }

}
