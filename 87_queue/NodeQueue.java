/***
* Purple Pineapples: Jason Zhou, Russell Goychayev, Marcus Wu
* APCS
* HW87: The English Do Not Wait In Line for Soup
* 04/3/2022
* time spent: 0.3 hours
**/

// Disco: manipulation can make this perform both stack functions or queue functions, its as simple as changing one param

// QCC: 
import thing.LList;


public class NodeQueue<T> implements Queue<T> {
    
    private LList<T> queue;
    private int size;

    public NodeQueue() {
        queue = new LList<T>();
        size = 0;
    }

    public void enqueue(T element) {
        queue.add(element);
        size++;
    }
    
    public T dequeue() {
        if (!isEmpty()) {
            size--;
            return queue.remove(size);
        }
        return null;
        
        
    }

    public T peekFront() {
        return queue.get(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String retVal = "First for Soup -> ";
        for (int i = size - 1; i >= 0; i--) {
            retVal += queue.get(i) + ", ";
        }
        return retVal + " <- Last for Soup";
    }

    public static void main(String[] args) {
        NodeQueue<String> elmeo = new NodeQueue<String>();
        elmeo.enqueue("sans");   
        System.out.println(elmeo);
        elmeo.enqueue("elmo");   
        System.out.println(elmeo);
        elmeo.enqueue("bigbird");   
        System.out.println(elmeo);
        elmeo.dequeue();
        System.out.println(elmeo);
        elmeo.dequeue();
        System.out.println(elmeo);
        elmeo.dequeue();
        System.out.println(elmeo);
    }
}
