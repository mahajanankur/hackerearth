package datastructure.utils;

public class ArrayUtil {

	/**
	 * This method is used to print any array in [ 1, 2, 3] format.
	 * 
	 * @param arr
	 * @return str
	 */
	public static String printArray(Object[] arr) {
		String str = "[";
		for (int i = 0; i < arr.length - 1; i++) {
			str += arr[i] + ", ";
		}
		str = str + arr[arr.length - 1] + "]";

		return str;
	}

}
