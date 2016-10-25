/**
 * 
 */
package javaConcepts.snarios;

/**
 * @author amahajan
 *
 * @written Sep 30, 2016
 */
public class EpcToSku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String epc = "00002ABE1000000000000062";
		String substring = epc.substring(9, 15);
		System.out.println(substring);

	}

}
