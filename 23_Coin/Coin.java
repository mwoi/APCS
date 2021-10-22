/***
 *  end sky ( Nina Jiang + Marcus Wu )
 *  APCS
 *  HW23 -- What Does Equality Look Like?
 *  2021-10-22
 *  time spent: 1.2
 ***/
 
 /*
 DISCO: 
	- putting the class name in the parameter of a method works: equals( Coin other ), and can be used to compare objects.
	- Math.random() can be used for probability and generating random integers or floating-point numbers.
 QCC:
	- The skeleton says the value of instance variable bias should be 1.0 for always heads and 0.0 for always tails, but
		Math.random() creates a floating-point number in interval [0.0,1.0), so there cannot be a value 1.0. 
 */

public class Coin {
//attributes aka instance vars
	private double value, bias;
	private String upFace, name;
	private int flipCtr, headsCtr, tailsCtr;
/***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
	public Coin() {
		upFace = "heads"; //default coin face is heads
		bias = 0.5; //default 50% heads 50% tails
		flipCtr = 0; //number total coinflips
		headsCtr = 0; //number total heads
		tailsCtr = 0; //number total tails
	}


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  
	public Coin( String s ) {
		if ( s.equals("penny") || s.equals("nickel") || s.equals("dime") || s.equals("quarter") || s.equals("half dollar") || s.equals("dollar") ) {
			name = s;
			upFace = "heads";
			bias = 0.5;
			flipCtr = 0;
			headsCtr = 0;
			tailsCtr = 0;
		}
	}


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
	public Coin( String s, String nowFace ) {
		name = s;
		upFace = nowFace;
		bias = 0.5;
		flipCtr = 0;
		headsCtr = 0;
		tailsCtr = 0;
	}


  // Accessors...
  // ----------------------------
	public String getUpFace() {
		return upFace;
	}

	public int getFlipCtr() {
		return flipCtr;
	}

	public double getValue() {
		return value;
	}

	public int getHeadsCtr() {
		return headsCtr;
	}

	public int getTailsCtr() {
		return tailsCtr;
	}

  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
	private double assignValue(String s) {
		if ( s.equals("penny") || s.equals("nickel") || s.equals("dime") || s.equals("quarter") || s.equals("half dollar") || s.equals("dollar") ) {
			if ( s.equals("penny") ) {
				value = 0.01;
			} else if ( s.equals("nickel") ) {
				value = 0.05;
			} else if ( s.equals("dime") ) {
				value = 0.10;
			} else if ( s.equals("quarter") ) {
				value = 0.25;
			} else if ( s.equals("half dollar") ) {
				value = 0.50;
			} else {
				value = 1.00;
			}
		}
		return value;
	}


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset(String s, double d) {
  		
		if ( d >= 0.0 && d < 1.0 && ( s.equals("heads") || s.equals("tails") ) ) {
			upFace = s;
			bias = d;
			value = 0;
			flipCtr = 0;
			headsCtr = 0;
			tailsCtr = 0;
		}
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
	public String flip() {
		String result; //will return heads or tails
		double coinflip = Math.random(); //the coin flip [0.0,1.0), determines upFace
		if (coinflip < bias) { //if [0.0,0.5), tails
			result = "tails";
			flipCtr += 1;
			tailsCtr += 1;
		} else { //if [0.5, 1.0), heads
			result = "heads";
			flipCtr += 1;
			headsCtr += 1;
		}
		upFace = result;
		return result;
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
		if ( other.name.equals(null) ) {
			return false;
		} else if ( upFace.equals(other.upFace) ) {
			return true;
		} else {
			return false;
		}
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
   
  public String toString() {
		String retStr = name + " -- " + upFace; 
		return retStr;
  }
  
}//end class