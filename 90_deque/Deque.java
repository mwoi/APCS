public interface Deque<T> {
  public void addFirst(T e);
  public void addLast(T e);
  public T getFirst();
  public T getLast();
  public T removeFirst();
  public T removeLast();
  public boolean isEmpty();
  public int size();
}



