/**
 * 
 */
package geeksofgeeks.arrays;

import java.util.Arrays;

/**
 * @author amahajan
 *
 * @written 29-Mar-2017
 */
public class RemoveDuplicateInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] removeDuplicates = removeDuplicates(new int[]{1,2,1,2,3,3,4,1});
		for (int i : removeDuplicates) {
			
			System.out.println(i);
		}

	}
	
	 public static int[] removeDuplicates(int[] array) {
		    int[] nums =new int[array.length];
		    int addedNum = 0;
		    int j=0;
		    for(int i=0;i<array.length;i++) {
		        if (addedNum != array[i]) {
		        nums[j] = array[i];
		        j++;
		        addedNum = nums[j-1];
		        }
		    }
		    return Arrays.copyOf(nums, j);
		}

}
