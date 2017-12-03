package com.pany.dump;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	/*
	 * Create class file
	 * @param bArray
	 * @param fileName
	 */
	public static void createFile(byte[] bArray, String fileName) {
		try {
			FileOutputStream out = new FileOutputStream("bci"+ fileName +".class");
			try {
				out.write(bArray);
				out.close();
				System.out.println("File Closed.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
