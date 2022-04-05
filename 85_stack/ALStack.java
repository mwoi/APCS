import java.util.ArrayList;

public class ALStack<T> implements Stack<T> {

    private ArrayList<T> stack;
    private int size;

    //Constructor
    public ALStack() {
      stack = new ArrayList<T>();
      size = 0;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public T peekTop() {
      return stack.get(size - 1);
    }

    public T pop() {
      size--;
      return stack.remove(size);
    }

    public void push(T x) {
      stack.add(x);
      size++;
    }
}
