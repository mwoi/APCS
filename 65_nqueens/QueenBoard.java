/*
Team Slightly Under-ripe Bananas (Joshua Yagupsky, Marcus Wu, Ivina Wang)
APCS pd7
HW65 -- How Many Queens Can a Thinker Place, If a Thinker Can Place Queens...
2022-02-16r
time spent: 1 hr
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    if ( solveH(0) ) {
      printSolution();
      return true;
    } else {
      _board = new int[_board.length][_board.length];
      printSolution();
      return false;
    }
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if ( col >= _board.length )
      return true;

    for ( int row = 0; row < _board.length; row++ ) {
      if ( addQueen( row, col ) ) {
        if ( solveH( col + 1 ) )
          return true;
        else
          removeQueen( row, col );
      }
    } //ends for loop
    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    for ( int[] row : _board ) {
    	for ( int position : row ) {
	    if ( position > 0 )
	    	System.out.print( "Q  " );
	    else
	    	System.out.print( "_  " );
	}
	System.out.println();
    }
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * sets the value of a square on the board to 1, and decreases every value by 1 in the rightward
     and down-rightward directions
   * precondition: all of the currently placed queens are to the left of the queens we are adding
   * postcondition: queens added at [row][col] and all positions to the right, are marked so
     that a queens cannot be placed there
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * sets the value of a square on the board to 0, and increases every value by 1 in the rightward,
     uprightward, and down-rightward directions
   * precondition: all of the currently placed queens are to the left of the given we are removing
   * postcondition: queen removed at [row][col] and all of the positions marked are now reset
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * Prints out the arrays that make up the board, with 1's, 0's, and negative numbers indicating queens,
     possible positions of queens, and positions where queens cannot be placed, respectively.
   * precondition: A board has been created with size > 0
   * postcondition: The array of ints has been printed
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    b.solve();
    System.out.println();

    QueenBoard a = new QueenBoard(8);
    a.solve();
    System.out.println();

    QueenBoard c = new QueenBoard(2);
    c.solve();
    System.out.println();

    //System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    //b.addQueen(3,0);
    //b.addQueen(0,1);
    //System.out.println(b);
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    //b.removeQueen(3,0);
    //System.out.println(b);
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */


  }

}//end class
