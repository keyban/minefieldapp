package com.navis.minefield.common;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileReaderTests {

	FileReader fileReader= new FileReader();
	
	@Test
	public void testReadFileFromClasspath_Ok_file_content() {
		try {
			List<String> content= fileReader.readFileFromClasspath("landMineTestOk.txt");
			List<String> expectedContent =  new ArrayList<String>();
			expectedContent.add("1 2 53");
			expectedContent.add("-32 40 100");
			expectedContent.add("10 15 25");
			expectedContent.add("-15 -15 200");
			assertEquals("Failure unexpected file content",expectedContent, content);
		} catch (URISyntaxException e) {
			fail("Failure for invalid path string");
			e.printStackTrace();
		} catch (IOException e) {
			fail("Failure for file not found");
			e.printStackTrace();
		}
	}

}
