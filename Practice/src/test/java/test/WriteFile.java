package test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {

	/**
	 * This class shows how to write file in java
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		try {
			writeUsingFileWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// String data = "I will write this String to File in Java";
	// int noOfLines = 10000;
	// writeUsingFileWriter(data);
	//
	// writeUsingBufferedWriter(data, noOfLines);
	//
	// writeUsingFiles(data);
	//
	// writeUsingOutputStream(data);
	// System.out.println("DONE");

	/**
	 * Use Streams when you are dealing with raw data
	 * 
	 * @param data
	 */
	private static void writeUsingOutputStream(String data) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("/Users/pankaj/os.txt"));
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Use Files class from Java 1.7 to write files, internally uses
	 * OutputStream
	 * 
	 * @param data
	 */
	private static void writeUsingFiles(String data) {
		try {
			Files.write(Paths.get("/Users/pankaj/files.txt"), data.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Use BufferedWriter when number of write operations are more It uses
	 * internal buffer to reduce real IO operations and saves time
	 * 
	 * @param data
	 * @param noOfLines
	 */
	private static void writeUsingBufferedWriter(String data, int noOfLines) {
		File file = new File("/Users/pankaj/BufferedWriter.txt");
		FileWriter fr = null;
		BufferedWriter br = null;
		String dataWithNewLine = data + System.getProperty("line.separator");
		try {
			fr = new FileWriter(file);
			br = new BufferedWriter(fr);
			for (int i = noOfLines; i > 0; i--) {
				br.write(dataWithNewLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Use FileWriter when number of write operations are less
	 * 
	 * @param data
	 * @throws IOException
	 */
	public static void writeUsingFileWriter() throws IOException {
		String data = "this is from eclipse \n";
		File file = new File("C:\\Users\\Administrator\\Desktop\\example.txt");
		FileWriter fr = null;
		fr = new FileWriter(file);

		for (int i = 0; i < 3; i++) {
			fr.write(data);
		}

		// close resources
		fr.close();
	}

}
