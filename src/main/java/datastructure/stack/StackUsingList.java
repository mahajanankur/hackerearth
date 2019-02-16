/**
 * 
 */
package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankur.mahajan
 * @param <E>
 * @written 02-Jan-2019
 */
public class StackUsingList<E> {

	private int current = 0;

	private int minimum;

	// private int currentIndex = 0;

	private List<E> list = new ArrayList<>();

	public void push(E element) {
		if (current == 0) {
			minimum = (Integer) element;
		}
		else {
			if (minimum > (Integer) element) {
				minimum = (Integer) element;
			}
		}
		list.add(element);
		current++;
	}

	public E pop() {
		if (current - 1 == 0) {
			System.out.println("Stack is empty.");
		}
		E e = list.get(current - 1);
		list.remove(current - 1);
		current--;
		return e;

	}

	public int getMinimum() {
		return minimum;
	}

}
