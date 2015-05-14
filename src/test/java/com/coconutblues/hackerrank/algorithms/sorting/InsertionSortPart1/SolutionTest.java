package com.coconutblues.hackerrank.algorithms.sorting.InsertionSortPart1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.junit.Test;

public class SolutionTest {

	private static PrintStream stdout = System.out;
	private static String rootDir = Solution.class.getName().replace(".", "/").replace("Solution","") ;
	
	@Test
	public void test() throws IOException, URISyntaxException {
		String data = getInput( rootDir + "in.0");
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(myOut));
		System.setIn(testInput);
		Solution.main(null);
		
		final String standardOutput = myOut.toString();
		System.setOut(stdout);
		System.out.println("My out is\n" + standardOutput);
		
	}
	
	private String getInput(String fileName){
		StringBuilder result = new StringBuilder("");
		 
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
	 
		try (Scanner scanner = new Scanner(file)) {
	 
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
	 
			scanner.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		return result.toString();
	 
	  }
	

}
