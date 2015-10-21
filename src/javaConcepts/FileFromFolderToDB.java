package javaConcepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FileFromFolderToDB {

	final static File	folder	= new File("/home/ankur/Desktop/App_Photos");

	public static void main(String[] args) {
		// storeIntoDB(folder);
		// retriveFromDB();
		copyFromOneFolderToAnother();
	}

	private static void copyFromOneFolderToAnother() {
		Path from = Paths.get("/home/ankur/Desktop/App_Photos/");
		Path to = Paths.get("/home/ankur/Desktop/Temp/");

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				storeIntoDB(fileEntry);
			} else {

				System.out.println(fileEntry.getName());
				try {
					Files.copy(fileEntry.getAbsoluteFile().toPath(), to, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}

	private static void retriveFromDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MyApp_DB", "root", "asd");
			String sql = "Select image from image_test";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Blob blob = rs.getBlob(1);
				System.out.println(blob);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private static void storeIntoDB(File folder) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MyApp_DB", "root", "asd");
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					storeIntoDB(fileEntry);
				} else {

					System.out.println(fileEntry.getName());
					String sql = "INSERT INTO image_test (image) values (?)";
					PreparedStatement statement = con.prepareStatement(sql);
					FileInputStream is = new FileInputStream(
							fileEntry.getAbsoluteFile());
					// statement.setInt(1, count++);

					statement.setBinaryStream(1, is,
							(int) new File(fileEntry.getAbsolutePath())
									.length());
					int row = statement.executeUpdate();

					if (row > 0) {
						System.out
								.println("A contact was inserted with photo image.");
					}
				}
			}
			con.close();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
