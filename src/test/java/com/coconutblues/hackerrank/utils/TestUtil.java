package com.coconutblues.hackerrank.utils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public enum TestUtil {
	
	INSTANCE;
	
	public static String readFile(Path path) throws IOException{
		List<String> lines = Files.readAllLines(path);
		return lines.toString();
	}

}
