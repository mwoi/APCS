/***
 * 
 * Team Purple Pineapples First Class Priority Queueueueueue
 *  
***/

import java.util.ArrayList;

public class ArrayPriorityQueueXtra {
    // x tra
    private class PriorityQueueElement {
        private int priority;
        private int value;

        public PriorityQueueElement(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return "(Priority: " + this.priority + " Value: " + this.value + "), ";
        }
    }

    private ArrayList<PriorityQueueElement> priorityQueue;

    private boolean SMALLEST_IN_EACH_PRIORITY_FIRST = false;

    public ArrayPriorityQueueXtra() {
        priorityQueue = new ArrayList<PriorityQueueElement>();
    }    

    public void enqueue(int element, int priority) {
        PriorityQueueElement tmp = new PriorityQueueElement(element, priority);
        if (isEmpty()) {
            priorityQueue.add(tmp);
            return;
        }
        for (int i = 0; i < priorityQueue.size(); i++) {
            if (SMALLEST_IN_EACH_PRIORITY_FIRST) {

            } else {
                if (tmp.getPriority() > priorityQueue.get(i).getPriority()) {
                    priorityQueue.add(i, tmp);
                    return;
                }
            } 
        } 
        priorityQueue.add(tmp);
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("No elements");
        return priorityQueue.remove(0).getValue();
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("No elements");
        return priorityQueue.remove(0).getValue();
    }

    public boolean isEmpty() {
        return priorityQueue.size() == 0;
    }

    public String toString() {
        String total = "";
        for (PriorityQueueElement e: priorityQueue) {
            total += e.toString();
        }
        return total;
    }

    public static void main(String[] args) {
        ArrayPriorityQueueXtra elmo = new ArrayPriorityQueueXtra();
        elmo.enqueue(16, 2);
        elmo.enqueue(1, 2);
        elmo.enqueue(16, 1);
        elmo.enqueue(16, 3);
        elmo.enqueue(6, 1);
        System.out.println(elmo);
    }


}
