/***

Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".


makeAbba("Hi", "Bye")  "HiByeByeHi"
makeAbba("Yo", "Alice")  "YoAliceAliceYo"
makeAbba("What", "Up")  "WhatUpUpWhat"

***/

public class makeAbba {
	public static String makeAbba(String a, String b) {
		String result = a + b + b + a;
		return result;
	}

	public static void main(String[] args){
		System.out.println( makeAbba("Hi", "Bye") );
		System.out.println( makeAbba("Yo", "Alice") );
		System.out.println( makeAbba("What", "Up") );
	}
}