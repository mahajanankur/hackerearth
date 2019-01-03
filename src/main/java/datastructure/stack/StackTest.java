/**
 * 
 */
package datastructure.stack;

/**
 * @author ankur.mahajan
 * @written 02-Jan-2019
 */
public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackUsingList<Integer> stack = new StackUsingList<>();
		
		stack.push(10);
		stack.push(12);
		stack.push(14);
		stack.push(0);
		stack.pop();
		stack.push(1);
		System.out.println(stack.getMinimum());
		
		
		
		
	}

}
