import LLists.*;

public class LLStack<T> implements Stack<T> {
    private LList<T> stack;
    private int size;

    public LLStack() {
      stack = new LList<T>();
      size = 0;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public T peekTop() {
      return stack.get(0);
    }

    public T pop() {
      size--;
      return stack.remove(0);
    }

    public void push(T element){
      size++;
      stack.add(0, element);
    }

    public String toString() {
      String retVal = "";
      for (int i = 0; i < size; i++) {
        retVal += stack.get(i) + ", ";
      }
      return retVal;
    }
}
