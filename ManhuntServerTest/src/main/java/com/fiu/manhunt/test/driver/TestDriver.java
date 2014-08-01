package com.fiu.manhunt.test.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.fiu.manhunt.data.JDBC;
import com.fiu.manhunt.server.PlayerMessageData;
import com.fiu.manhunt.test.modules.ControllerTest;
import com.google.gson.Gson;

public class TestDriver {
	private static final int NUM_TESTS = 10;
	private static Random _rnd;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		_rnd = new Random();
		_rnd.setSeed(0);
		try {
			JDBC db = new JDBC();
			TestController();
		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("Something major broke.");
			
		}
	}

	private static void TestController() throws FileNotFoundException,
			UnsupportedEncodingException {
		ControllerTest ct = new ControllerTest();

		PrintWriter writer = createLog("ControllerTest");

		PlayerMessageData pmd = new PlayerMessageData();
		PlayerMessageData.PlayerData pd = pmd.new PlayerData();
		Gson gson = new Gson();

		// good test cases
		for (int i = 0; i < NUM_TESTS; i++) {
			// test within a range of four e-mails (this way we hit 4 new
			// players and Num_test - 4 updates)
			pd.set_email("test" + (i % 4) + "@somewhere.com");

			// random locations.
			pd.set_lat((float) 1.2234 * (float) getRandomRange(1, 25));
			pd.set_long((float) 1.2234 * (float) getRandomRange(5, 40));

			// expected input
			
			String playerJsonData = gson.toJson(pd);
			writer.println("\n--Test " + i + " input--\n");
			writer.println(playerJsonData);

			// write out results
			writer.println("\n--Test " + i + " output--\n");
			writer.println(ct.TestPlayerUpdate(playerJsonData));
		}
		writer.close();

		/*
		// bad test cases
		for (int i = 0; i < NUM_TESTS; i++) {
			// test with valid e-mail, invalid e-mail, and no e-mail
			// test1@somewhere.com should be in ban list.
			if (i % 3 == 0)
				pd.set_email("test" + (i % 4) + "@somewhere.com");
			else if (i % 3 == 1)
				pd.set_email("test" + (i % 4));
			else
				pd.set_email("");

			pd.set_lat((float) 1.2234 * (float) getRandomRange(1, 25));
			pd.set_long((float) 1.2234 * (float) getRandomRange(5, 40));

			// expected input
			String playerJsonData = gson.toJson(pd);
			writer.println("\n--Bad E-mail Test " + i + " input--\n");
			writer.println(playerJsonData);

			// write out results
			writer.println("\n--Bad E-mail Test " + i + " output--\n");
			writer.println(ct.TestPlayerUpdate(playerJsonData));
		}

		// bad localtion
		for (int i = 0; i < NUM_TESTS; i++) {

			pd.set_email("test" + (i % 4) + "@somewhere.com");

			if (i % 3 == 0) {
				pd.set_lat(-1);
				pd.set_long(-1);
			}
			else if (i % 3 == 1) {
				pd.set_lat(0);
				pd.set_long(0);
			}
			else {
				pd.set_lat((float)1000.0 * (i % 5));
				pd.set_long((float)1000.0 * (i % 5));
			}

			// expected input
			String playerJsonData = gson.toJson(pd);
			writer.println("\n--Bad E-mail Test " + i + " input--\n");
			writer.println(playerJsonData);

			// write out results
			writer.println("\n--Bad E-mail Test " + i + " output--\n");
			writer.println(ct.TestPlayerUpdate(playerJsonData));
		} */
		writer.close();
	}

	// support functions
	private static PrintWriter createLog(String prefix)
			throws FileNotFoundException, UnsupportedEncodingException {
		int i = 0;
		String fileName = null;
		while (i >= 0 && i <= 100) {
			File log = new File(prefix + "-" + i++ + ".txt");
			if (!log.exists()) {
				fileName = log.getName();
				break;
			}
		}
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		return writer;
	}

	private static int getRandomRange(int min, int max) {
		return (_rnd.nextInt((max - min) + 1) + min);
	}

}
