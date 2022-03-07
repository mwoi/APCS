// Jonathan Song, Max Schneider, Marcus Wu
// APCS pd7
// HW70 -- Thinkers of the Corn
// 2022-03-03r
// time spent: 1.0 hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 * Continuously check if there is a wall (" ") to the left of the hero.
 * If so, walk forward. If not, turn left and walk forward one space.
 * If the hero cannot walk forward because there is a wall in the way, turn left. If the hero has been in the same position more than once turn right.
 * This algorithm does not work if the maze is the walls are not completely connected. (i.e. a standalone island)
 *
 * DISCO
 * Pretty similar to knight's tour, so similar setup 
 *
 * QCC
 * Any parameters behind unsolvable mazes?
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  private int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
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
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable

    //primary base case
    if ( _solved == true ) { //if solved, exit
	System.exit(0);
    }

    //other base cases
    else if ( _maze[x][y] == EXIT ) { //if not solved but at exit, solved
	_solved = true;
      return;
    }

    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else { //if not solved and not on $,
	_maze[x][y] = HERO; //print a @, marking location
      System.out.println( this ); //refresh screen
	//if path up, go up
	if ( onPath( x, y-1 ) )
	{
		solve( x, y-1 );
	}
	//if path right, go right
	if ( onPath( x+1, y ) )
	{
		solve( x+1, y );
	}
	//if path down, go down
	if ( onPath( x, y+1 ) )
	{
		solve( x, y+1 );
	}
	//if path left, go left
	if ( onPath( x-1, y ) )
	{
		solve( x-1, y );
	}
	//no paths up, right, down, left
	_maze[x][y] = VISITED_PATH; //make a . to signal visited failed path when backtracking
      System.out.println( this ); //refresh screen
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) { //true if the path is # or $ (valid path to take)
      return ( _maze[x][y] == PATH || _maze[x][y] == EXIT );
  }

  public int getH() {
	return h;
  }

  public int getW() {
	return w;
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)
    // ThinkerTODO: comment next line out when ready to randomize startpos
    //ms.solve( 4, 3 );

    //drop our hero into maze at random location on path
    int startX = 0;
    int startY = 0;
    while ( !( ms.onPath( startX, startY ) ) ) {
	startX = (int) ( Math.random() * ms.getW() );
	startY = (int) ( Math.random() * ms.getH() );
    }
    ms.solve( startX, startY );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze
