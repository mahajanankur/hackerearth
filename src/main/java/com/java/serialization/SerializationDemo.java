/**
 * 
 */
package com.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author amahajan
 * 
 */
public class SerializationDemo {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// serialization();
		deserialization();
	}

	private static void serialization() throws IOException {
		FileOutputStream out = new FileOutputStream("C://var//serializable.txt");
		ObjectOutputStream outputStream = new ObjectOutputStream(out);
		outputStream.writeObject(new Student(1, "Ankur", 26, "Shimla"));
		outputStream.flush();
		System.out.println("Serialized");
		outputStream.close();

	}

	private static void deserialization() throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream("C://var//serializable.txt");
		ObjectInputStream inStream = new ObjectInputStream(in);

		Student student = (Student) inStream.readObject();
		System.out.println(student);
		// System.out.println(student.getHuman());
		inStream.close();
	}
}
