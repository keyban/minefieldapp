package com.navis.minefield.controller;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Interface for specify all the operations related to the mine objects
 * 
 * @version 1.0, 09/03/2020
 * @author Keyban Arnoldo Martinez Payan
 */
public interface MineController {
	/**
	 * Specification of a method to determine if a mine has triggered by a Manually
	 * set off mine.
	 * 
	 * @param x1 Float value of the x coordinate of the Manually set off mine.
	 * @param y1 Float value of the y coordinate of the Manually set off mine.
	 * @param r  Float value of the blast radius of the Manually set off mine.
	 * @param x2 Float value of the x coordinate of the second mine to evaluate if
	 *           it is triggered.
	 * @param y2 Float value of the y coordinate of the second mine to evaluate if
	 *           it is triggered.
	 * @return true if the second mine is triggered for the Manually set off mine,
	 *         false otherwise.
	 */
	public boolean mine_exploded(Float x1, Float y1, Float r, Float x2, Float y2);

	/**
	 * Specification of a method to process the content of the land mine file to get
	 * the maximum number of mines you can explode and which mine you need to
	 * manually set off to explode this maximum number.
	 * 
	 * @param landMineFilePath the String of the path to the land mine file
	 * @return String[] array of 2 strings, the first is the value of Maximum number
	 *         of mines detonated and the second is one or more Manually set off
	 *         mine(s).
	 * @throws URISyntaxException             this exception is thrown when the
	 *                                        string (path to the file) passed to be
	 *                                        parse to a uri is invalid
	 * @throws IOException                    this exception is thrown when the file
	 *                                        is not found
	 * @throws ArrayIndexOutOfBoundsException if the format of the file (lines with
	 *                                        3 values separated by spaces) is not
	 *                                        valid
	 */
	public String[] findSetOffMine(String landMineFilePath)
			throws URISyntaxException, IOException, ArrayIndexOutOfBoundsException;
}
