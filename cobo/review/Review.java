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
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();


  private static final String SPACE = " ";

  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }


  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        //System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }
  }

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

  public static double totalSentiment(String fileName)
  {
    String str = textToString(fileName);
    Scanner input = new Scanner(str);
    double total = 0.0;
    while(input.hasNext()){
      total += sentimentVal(input.next());
    }
    return total;
  }

  public static int starRating( String fileName )
  {
    double rating = totalSentiment( fileName );
    if ( rating > 15.0 )
      return 4; //4 star
    else if ( rating > 10.0 )
      return 3; //3 star
    else if ( rating > 5.0 )
      return 2; //2 star
    else if ( rating > 0 )
      return 1; //1 star
    else
      return 0; //0 star
  }

  // public static String fakeReview( String fileName){
  //   String str = textToString(fileName);
  //   String review = "";
  //   int startIndex = 0;
  //   while(str.indexOf("*", startIndex) != -1){
  //     review += str.substring(startIndex, str.indexOf("*", startIndex));
  //       review += randomAdjective();
  //     startIndex = str.indexOf(" ", str.indexOf("*", startIndex));
  //   }
  //   review += str.substring(startIndex);
  //   return review;
  // }

  public static String fakeReview( String filename ){
    String str = textToString(filename);
    String[] words = str.split(" ");
    String review = "";
    String punc;
    boolean happy = totalSentiment(filename) > 0;
    for (String word : words){
      punc = getPunctuation(word);
      word = word.substring(0,word.length()-punc.length());
      if (word.substring(0,1).equals("*")){
        if (sentimentVal(word.substring(1)) > 0 && !happy){
          word = randomNegativeAdj();
        }
        else if (sentimentVal(word.substring(1)) <= 0 && happy){
          word = randomPositiveAdj();
        }
        else{
          word = word.substring(1);
        }
      }
      review += word + punc + " ";
    }
    return review;
  }

  public static void main( String[] args )
  {
    // System.out.println("REVIEWS AND STAR RATINGS:\n");
    // System.out.println( totalSentiment("SimpleReview.txt") );
    // System.out.println( starRating("SimpleReview.txt") );
    // System.out.println( totalSentiment("MeanReview.txt") );
    // System.out.println( starRating("MeanReview.txt") );
    // System.out.println( totalSentiment("BadReview.txt") );
    // System.out.println( starRating("BadReview.txt") );
    // System.out.println( totalSentiment("GreatReview.txt") );
    // System.out.println( starRating("GreatReview.txt") );
    System.out.println("FAKE REVIEWS:\n");
    System.out.println( fakeReview("SimpleReview.txt"));
    System.out.println( fakeReview("BadReview.txt"));
    System.out.println( fakeReview("GreatReview.txt"));
  }
}
