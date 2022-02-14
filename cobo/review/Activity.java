import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
/**
Team Slightly Under-ripe Bananas (Joshua Yagupsky, Marcus Wu, Ivina Wang)
APCS pd7
L06 -- Read/Review/Expand
2022-02-13
time spent: -- 5 hrs
**/
public class Activity
{
  static Scanner scanner = new Scanner(System.in);

  //gets picks a random word from words.txt
  public static String randomWord()
  {
    String wordstxt = Review.textToString("words.txt");
    String[] words = wordstxt.split(" ");
    int index = (int)(Math.random() * words.length);
    return words[index];
  }

  public static String shuffle( String word )
  {
    for ( int i = 0; i < 10; i++ )
    {
      String str;
      int index = (int)( Math.random() * word.length() );
      str = word.substring(0,index) + word.substring(index+1,word.length()) + word.charAt(index);
      word = str;
    }
    return word;
  }

  public static void main (String[] args)
  {
    String word = randomWord();
    System.out.println( "your word is... " + shuffle(word) );
    int guesses = 0;
    while ( guesses < 5 )
    {
      String input = scanner.nextLine();
      if ( input.equals(word) ) {
        System.out.println( "congratz you got the word " + word );
        break;
      }
      else {
        if ( guesses == 4 )
          System.out.println( "you lost :)" );
        else
          System.out.println( "sorry try again :(" );
        guesses++;
      }
    } //ends while loop
  } //ends main
} //ends Activity
