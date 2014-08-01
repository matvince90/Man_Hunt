package com.fiu.manhunt.server;

/**
 * Simple output utility class.
 * @author Team 3
 *
 */
public class ServerOutput {
	private static boolean verbose = true;
	private static final String _prefix = "Manhunt: ";
	
	/**
	 * Print a string to the servers output if verbosity is true.
	 * @param str
	 */
	public static void println(String str) {
		if(verbose)
			System.out.println(_prefix + str);
	}

}
