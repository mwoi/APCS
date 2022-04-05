

/***
* Purple Pineapples: Jason Zhou, Russell Goychayev, Marcus Wu
* APCS
* HW87: The English Do Not Wait In Line for Soup
* 04/3/2022
* time spent: 0.3 hours
**/



import thing.*;

public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LList<SWASHBUCKLE> queue;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    this.queue = new LList<SWASHBUCKLE>();
    this._size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    queue.add(enQVal);
    _size++;
  }

  public SWASHBUCKLE dequeue() {
    if (!isEmpty()) {
        _size--;
        return queue.remove(_size);
    }
    return null;
    
    
}

public SWASHBUCKLE peekFront() {
    return queue.get(0);
}


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   < YOUR SUCCINCT SUMMARY HERE >
   * 
   * Takes first item and queue and finds a random place to put it and does this n times
   **/
  public void sample ()
  {
    for (int k = _size; k > 0; k--) {
    
      int randoR = (int) (Math.random() * (_size));
      
      queue.add(randoR, queue.remove(0));
   

      System.out.println(this);
		}
  }//O(N)

  public boolean isEmpty()
  {
    return _size == 0;
  } //O(1)


  // print each node, separated by spaces
  public String toString()
  {
    String retVal = "First for Soup -> ";
    for (int i = _size - 1; i >= 0; i--) {
        retVal += queue.get(i) + ", ";
    }
    return retVal + " <- Last for Soup";

  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

      
    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing..."); 
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()..."); 
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("now shuffling");
    ((RQueue<String>) PirateQueue).sample();
    System.out.println(PirateQueue);

    System.out.println("\nnow dequeuing..."); 
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n"); 
    System.out.println( PirateQueue.dequeue() );
/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
