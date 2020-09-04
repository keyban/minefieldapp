package com.navis.minefield;

import java.io.IOException;
import java.net.URISyntaxException;

import com.navis.minefield.controller.MineControllerImpl;

/**
 * Program to read in a mines file and output the maximum number of mines you
 * can explode. Also output which mine you need to manually set off to explode
 * this maximum number. Since there may be multiple mines that blow up a maximal
 * number of mines you should output all the mines that do that.
 * 
 * @version 1.0, 09/03/2020
 * @author Keyban Arnoldo Martinez Payan
 */

public class MinefieldApplication {
	/**
	 * Main method executes the methods to perform all the necessary operations to
	 * get the results and handle the possible exceptions.
	 */
	public static void main(String[] args) {
		try {
			MineControllerImpl mineControllerImpl = new MineControllerImpl();
			String[] results = mineControllerImpl.findSetOffMine("landMine.txt");
			// print the max number of detonated mines
			System.out.println("Maximum number of mines detonated: " + results[0]);
			System.out.println("Manually set off mine:");
			// print the mine or mines(if the number of detonated mines is the same between
			// more than one selected to manually set off
			System.out.println(results[1]);
		} catch (IOException e) {
			System.out.println("*********Error************");
			System.out.println("Land mine file not found.");
		} catch (URISyntaxException e) {
			System.out.println("*********Error************");
			System.out.println("Invalid path to the land mine file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("*********Error************");
			System.out.println(e.getMessage());
		}
	}

}
