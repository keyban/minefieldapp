package com.navis.minefield.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.navis.minefield.common.FileReader;
import com.navis.minefield.model.Mine;

/**
 * Class for all the operations related to the mine objects
 * 
 * @version 1.0, 09/03/2020
 * @author Keyban Arnoldo Martinez Payan
 */

public class MineControllerImpl implements MineController {
	/**
	 * Method to determine if a mine has triggered by a Manually set off mine.
	 * evaluates if a manually set off mine triggered a second mine
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
	@Override
	public boolean mine_exploded(Float x1, Float y1, Float r, Float x2, Float y2) {
		// evaluate if the operation between coordinates of the 2 evaluated mines
		return r >= Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

	/**
	 * Method to Print the content of the land mine file, process the content to get
	 * the maximum number of mines you can explode and which mine you need to
	 * manually set off to explode this maximum number.
	 * 
	 * @param landMineFilePath the String of the path to the land mine file
	 * 
	 * @throws URISyntaxException             this exception is thrown when the
	 *                                        string (path to the file) passed to be
	 *                                        parse to a uri is invalid
	 * @throws IOException                    this exception is thrown when the file
	 *                                        is not found
	 * @throws ArrayIndexOutOfBoundsException if the format of the file (lines with
	 *                                        3 values separated by spaces) is not
	 *                                        valid
	 */
	@Override
	public String[] findSetOffMine(String landMineFilePath)
			throws URISyntaxException, IOException, ArrayIndexOutOfBoundsException {
		String[] result = new String[2];
		FileReader reader = new FileReader();

		// Read the file content
		List<String> landMineFileContent = reader.readFileFromClasspath(landMineFilePath);
		System.out.println("========Land mine========");
		List<Mine> landMine = new ArrayList<Mine>();
		// Read each line of the file content
		for (String line : landMineFileContent) {
			// Print the content of the file
			System.out.println(line);
			// Split the line using space as pattern limit the number of applications of the
			// pattern by 3
			String[] lineData = line.split(" ", 3);
			if (!lineData[0].isEmpty() && !lineData[1].isEmpty() && !lineData[2].isEmpty()) {
				Mine mine = new Mine(lineData);
				// Populate the mine field
				landMine.add(mine);
			} else {
				throw new ArrayIndexOutOfBoundsException("File content error");
			}

		}
		System.out.println("========Results==========");
		long maxExp = 0L;
		List<Mine> mineExplode = new ArrayList<Mine>();
		MineControllerImpl mineController = new MineControllerImpl();
		// start to process each landMine element
		for (Mine mine : landMine) {
			// filter the landMine List using the method Exploder.mine_exploded as a
			// predicate and count filter elements to get the number
			// of triggered mines
			Long exp = landMine.stream().filter(
					x -> mineController.mine_exploded(mine.getX(), mine.getY(), mine.getR(), x.getX(), x.getY()))
					.count();
			if (exp >= maxExp) {
				mineExplode.add(mine);
				maxExp = exp;
			}
		}
		// Set results
		result[0] = String.valueOf(maxExp);
		result[1] = String.valueOf(mineExplode.toString());
		return result;
	}

}
