/*
Team Slightly Under-ripe Bananas (Joshua Yagupsky, Marcus Wu, Ivina Wang)
APCS pd7
HW68 -- ...and T-, Tr-, Tri-, Tries Again Until It's Done
2022-03-1
time spent: 1 hr
*/
/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO
 * 1. If the solution has been found, stop.
 * 2. If this is past the last move, the solution has been found. Exit.
 * 3. If the knight makes an illegal move (outside the board or onto another existing knight), backtrack
 * 4. Place the knight at its designated spot
 * 5. Try adding a knight at every possible knight's move away from the current location. If none work, backtrack.
 * DISCO
 *  We don't need to check every possible knight's move seperately. We can instead look in a 5x5 grid and only look at the valid
 *  knight's moves.
 *
 * QCC:
 * Is there a way to run this code faster? Like if you want to test n > 7
 *
 * Mean execution times for boards of size n*n:
 * n=5   2.25s    across 2 executions
 * n=6   31.9s    across 2 executions
 * n=7   25.5s    across 2 executions
 * n=8   63m    across 1 executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    //int startX = (int) (n * Math.random() + 2.0);
    //int startY = (int) (n * Math.random() + 2.0);
    //tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[_sideLength + 4][_sideLength + 4];

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
    for(int x = 0; x < _sideLength + 4; x++){
    	for(int y = 0; y < _sideLength + 4; y++){
    		if(x < 2 || x > _sideLength+1 || y < 2 || y > _sideLength+1){
    			_board[x][y] = -1;
    		}
    	}
    }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if (_solved) {
      System.exit(0);
    }

    //primary base case: tour completed
    if (moves > _sideLength * _sideLength) {
      _solved = true;
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
    if (_board[x][y] != 0) {
      return;
    }
    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;

      System.out.println( this ); //refresh screen

      //delay(100); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
       *
       *     Distance from center:
       *     4 3 2 3 4
       *     3 2 1 2 3
       *     2 1 0 1 2
       *     3 2 1 2 3
       *     4 3 2 3 4
      ******************************************/
      //Loop through all possible relative positions
      for (int i = -2; i <= 2; i++) {
        for (int j = -2; j <= 2; j++) {
          //Check if this position is a knight's move away from the center square:
          if(Math.abs(i) + Math.abs(j) == 3) {
            findTour(x + i, y + j, moves+1);
            if(_solved){
              return;
            }
          }
        }
      }

      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell
