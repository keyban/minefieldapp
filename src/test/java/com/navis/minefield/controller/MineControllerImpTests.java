package com.navis.minefield.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;

import com.navis.minefield.controller.MineController;
import com.navis.minefield.controller.MineControllerImpl;

public class MineControllerImpTests {

	MineController mineController = new MineControllerImpl();


	@Test
	public void testMine_exploded_true_triggered_mine() {
		assertEquals("Failure in a true triggered mine expected", mineController.mine_exploded(1F, 2F, 53F, -32F, 40F),
				true);
	}

	@Test
	public void testMine_exploded_false_triggered_mine() {
		assertEquals("Failure in a false triggered mine expected", mineController.mine_exploded(1F, 2F, 1F, -32F, 40F),
				false);
	}

	@Test
	public void testfindSetOffMine_FileOk() {
		String[] expectedResult = new String[2];
		expectedResult[0] = "4";
		expectedResult[1] = "[Mine [x=1.0, y=2.0, r=53.0], Mine [x=-32.0, y=40.0, r=100.0], Mine [x=-15.0, y=-15.0, r=200.0]]";
		try {
			assertArrayEquals("Failure in a false triggered mine expected",
					mineController.findSetOffMine("landMineTestOk.txt"), expectedResult);
		} catch (ArrayIndexOutOfBoundsException e) {
			fail("Failure for File content error");
		} catch (ArrayComparisonFailure e) {
			fail("Failure for invalid path string");
		} catch (URISyntaxException e) {
			fail("Failure for invalid path string");
		} catch (IOException e) {
			fail("Failure for file not found");
		}
	}

	@Test
	public void testfindSetOffMine_emptyfile() {
		String[] expectedResult = new String[2];
		expectedResult[0] = "0";
		expectedResult[1] = "[]";
		try {
			assertArrayEquals("Failure in a false triggered mine expected",
					mineController.findSetOffMine("landMineTestEmpty.txt"), expectedResult);
		} catch (ArrayIndexOutOfBoundsException e) {
			fail("Failure for File content error");
		} catch (ArrayComparisonFailure e) {
			fail("Failure for invalid path string");
		} catch (URISyntaxException e) {
			fail("Failure for invalid path string");
		} catch (IOException e) {
			fail("Failure for file not found");
		}
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testfindSetOffMine_BadFormatFile() throws ArrayIndexOutOfBoundsException, URISyntaxException, IOException {
		mineController.findSetOffMine("landMineTestBadFormat.txt");
	}
	
	@Test(expected = UncheckedIOException.class)
	public void testfindSetOffMine_FileNotFoud() throws ArrayIndexOutOfBoundsException, URISyntaxException, IOException {
		mineController.findSetOffMine("");
	}

}
