// discordDucks (Marcus Wu + Nat, Gabriel Thompson + Iggy, Kartik Vanjani + Krrish)
// APCS pd8
// HW47 -- Guess Again
// 2021-12-14t
// time spent: _ hrs

/***
 * class GuessNumber -- fun fun fun!
 *
 * SKELETON
 *
 * eg, sample interaction with end user:
 *
 * Guess a # fr 1-100: 50
 * Too high
 * Guess a # fr 1-49: 25
 * Too low
 * Guess a # fr 26-49: 38
 * Correct! It took 3 guesses
 ***/

/***

    DISCO:
     * It is generally easier and more intuitive for us to write iterative functions
     * Functions called recursively can still modify global variables (like _guessCtr)

    QCC:
     * You can return without returning a value, just by using the "return" keyword
     * Where would you need to use the "break" keyword, where you couldn't just put the
       exit condition that triggers the "break" in the exit condition for the loop? Is
       "break", like try/except a last resort that shouldn't be used?
     * Is there any (reasonable) way to write our playRec() and playIter() functions so
       that we don't put the entire 3 cases inside of an "else" statement?
     * This exercise has expanded our understanding of what recursion is capable of. Is
       there anything that iteration can (or should) do that recursion can't (or
       shouldn't) do?

 ***/
import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:  instance variables have been created
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    //pick random number in range [a,b]
    _target = (int) (Math.random() * (_hi - _lo) + _lo);
  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec()
  {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo
    if (guess > _hi || guess < _lo) {
      System.out.println("Out of range! Enter in a valid number, idiot");
      _guessCtr++;
      playRec();
    } else {
      //3 cases: we either found it, too hi, too lo
      if (guess < _target) {
        System.out.println("Too low, try again...");
        _guessCtr++;
        _lo = guess + 1;
        playRec();

      } else if (guess > _target) {
        System.out.println("Too high, try again...");
        _guessCtr++;
        _hi = guess - 1;
        playRec();

      } else {
        System.out.println("Correct! It took " + _guessCtr + " guesses.");
        _guessCtr++;
        return;

      }

    }

  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {

    int guess;

    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();

      if (guess > _hi || guess < _lo) {
        System.out.println("Out of range! Enter in a valid number, idiot");
      } else {
        //3 cases: we either found it, too hi, too lo
        if (guess < _target) {
          System.out.println("Too low, try again...");
          _lo = guess + 1;
        } else if (guess > _target) {
          System.out.println("Too high, try again...");
          _hi = guess - 1;
        } else { // you found it
          System.out.println("Correct! It took " + _guessCtr + " guesses.");
          return;
        }
      }

      _guessCtr++;
    }
  }


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    playRec();
    //playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {
    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);

    //start the game
    g.play();
    /*-----------------------------
    -----------------------------*/
  }

}//end class GuessNumber
