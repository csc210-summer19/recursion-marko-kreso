/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Your Name
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
    if(k == 1)
    	return n;
    if(n==k)
    	return 1;
    return combinations(n-1,k-1) + combinations(n-1,k);
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
    // TODO: Implement this method using recursion. Do not use a loop
	
	if(n/1000 == 0) {
		return Integer.toString(n);
	}
	
	String ones = Integer.toString(n%10);
	String tens = Integer.toString((n/10)%10);
	String hundreds = Integer.toString((n/100)%10);
    return intWithCommas(n/1000) + "," + hundreds + tens + ones;
    
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
    // TODO: Complete this method with a recursive algorithm. 
    // Do NOT use a loop.
	if(index < (len-1-index)) {
		int temp = x[index];
		 x[index]= x[len-1-index];
		 x[len-1-index] = temp;
		reverseArray(x, index+1, len);
	}
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
    return arrayRangeHelper(a, 0, a.length, a[0], a[0]);
  }
  private int arrayRangeHelper(int[]a, int index, int len, int max, int min) {
	  if(index == len) 
		  return max - min;
	  
	  if(a[index] > max) 
		  return arrayRangeHelper(a, index+1, len, a[index], min);
	  
	  if(a[index] < min) 
		  return arrayRangeHelper(a, index+1, len, max, a[index]);
	  
	  else
		  return arrayRangeHelper(a, index+1, len, max, min);
  }

  // Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
    // Need to send down 0 to keep track of the index
    return isSortedHelper(nums, 0, nums.length, Integer.MIN_VALUE);
  }
  private boolean isSortedHelper(int[] nums, int index, int len, int prev) {
	  if(index == len) {
		  return true;
	  }
	  if(nums[index] < prev) {
		  return false;
	  }
	  return isSortedHelper(nums, index+1, len, nums[index]);
  }

  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
     return foundHelper(search, strs, 0, strs.length); 
  }
  private boolean foundHelper(String search, String[] strs, int index, int len){
	  if(index == len)
		  return false;
	  if(strs[index].equals(search))
		  return true;
	  return foundHelper(search, strs, index+1, len);
  }
}
