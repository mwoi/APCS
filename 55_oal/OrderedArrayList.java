/*
Oscar Breen -- Team Consonants2 -- Ari Gurovich , Marcus Wu
APCS
HW55 -- Never fear Big Oh is Here -- commenting the big ohs and best/worst cases of ArrayList methods
2021-01-11
time spent: 1
*/
import java.util.ArrayList;



public class OrderedArrayList{

 private ArrayList<Integer> data;


/* creates an array of x size

  ArrayList is empty, cannot be affected by any factors. O(1)

*/


 public OrderedArrayList(){ 
  data = new ArrayList<Integer>(20);
 }

/* populates array

  length is only factor. O(n)

*/

 public OrderedArrayList(ArrayList<Integer> array){ 
  data = new ArrayList<Integer>(array.size());
  for(int x : array){
     add(x);
 }
}
/* returns a string of the ArrayList

  No best or worst case, increases linearly for size of Array regardless O(n)

*/

 public String toString(){ 
  return data.toString();
 }

/* returns value at an index

  Is data insensitive O(1)

*/

 public Integer get(int index){ 
  return data.get(index);
 }

/* returns the size of the Array calling it

  Is data insensitive O(1)

*/

 public int size(){ 
  return data.size();
 }


/* set function is to remove value at index and adds a new value (not to the specific index)

  Worst Case: removes first elements and adds smallest element to a dataset 1 away from expansion. O(n)
	- Reasoning for adding down below, removing at the start causes the rets to have to be moved as well, 
	  combination of the two is slow.
  Best Case: removes only element in single size array and adds an element O(n)
	- remove requires no number shifting  neither does addition, as well as no iteration.
*/
 public Integer set(int index, int newVal){ 
  int oldVal = remove(index); 
  data.add(newVal); 
  return oldVal;
 }


/* add function is to add a element in the correct position so that the list remains sorted ascending

  Worst Case: The smallest element is added to a set at its expansioon point O(n)
        - As the list will be iterated through, once to add, twice after expansion and then has to push
          all other elements up one to accomodate for the new space added at the start of the array 
  Best Case: the element is added to an empty set O(n)
	- there is no set to iterate through and thus no comparisons to be made and no expansion
	  point to worry about, fastest possible outcome
*/

 public void add(int newVal){ 
  for (int index = 0; index < size(); index ++){
    if(0 < data.get(index).compareTo(newVal));
      data.add(index, newVal);
       break;
      }
  }
   data.add(newVal);
 }


 // public void add (int index, int newVal){
  // irrelevent for sorting arrays

/* remove function is to remove a specified element from an array list, and shifting all other numbers as to not have a gap.

  Worst Case: - removing the first element, O(n)
	- because the remove method now has to readjust every other element in the array
  Best Case: - removing last element O(1)
	- because no other elements have to be shifted
*/ 
 public Integer remove(int index){
    return data.remove(index);
 }

} // end class
