package com.navis.minefield.common;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Class for read content from file in the classpath
 * @version 1.0, 09/03/2020
 * @author Keyban Arnoldo Martinez Payan
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
	/**
	 * Method to read content from file in the classpath return the content of the
	 * file landMine.txt in a list of string each element represent a line in the
	 * file
	 * 
	 * @param landMineFilePath the String of the path to the land mine file
	 * 
	 * @return StringList each element represent a line in the file.
	 * @throws URISyntaxException this exception is thrown when the string (path to
	 *                            the file) passed to be parse to a uri is invalid
	 * @throws IOException        this exception is thrown when the file is not
	 *                            found
	 */
	public List<String> readFileFromClasspath(String landMineFilePath) throws URISyntaxException, IOException {
		// get the path of the file in the classpath
		Path path = Paths.get(getClass().getClassLoader().getResource(landMineFilePath).toURI());

		// read the file content
		Stream<String> lines = Files.lines(path);
		// Collect the file content in a list by lines
		List<String> data = lines.collect(Collectors.toList());
		lines.close();
		return data;
	}
}
