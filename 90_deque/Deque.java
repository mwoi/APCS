/*
Team Purple Pineapples: Jason Zhou, Marcus Wu, Russell Goychayev
APCS
HW90 - Swabbing the Deque
04/12/2022
time spent: 69 centuries
*/
public interface Deque<T> {
  public void addFirst(T e);
  public void addLast(T e);
  public T getFirst();
  public T getLast();
  public T removeFirst();
  public T removeLast();
  public boolean isEmpty();
  public int size();
  public boolean contains(Object e);
  public boolean remove(Object e);
}
