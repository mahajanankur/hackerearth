/**
 * 
 */
package com.java.collection.set;

import java.util.TreeSet;

/**
 * @author amahajan
 *
 * @written 07-Mar-2017
 */
public class TreeSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TreeSetTest().go();
	}

	public void go() {
		Book b1 = new Book("Bow cats Work");
		Book b2 = new Book("Remix your Body");
		Book b3 = new Book("Finding Emo");
		Book b4 = new Book("Aim High");
		TreeSet<Book> tree = new TreeSet<Book>();
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		tree.add(b4);
		for (Book book : tree) {

			System.out.println(book);
		}
	}

	class Book implements Comparable<Book> {
		// class Book {
		String title;

		public Book(String t) {
			title = t;

		}

		@Override
		public int compareTo(Book o) {
			return title.compareTo(o.title);
		}

		@Override
		public String toString() {
			return title;
		}
	}
}
