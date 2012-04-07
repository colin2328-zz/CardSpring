import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ArrayAbsurdity {
	/* Problem statement:
	 * Imagine we have an immutable array of size N which we know to be filled with integers ranging from 0 to N-2, inclusive. 
	 * Suppose we know that the array contains exactly one duplicated entry and that duplicate appears exactly twice. 
	 * Find the duplicated entry. (For bonus points, ensure your solution has constant space and time proportional to N)

	Your program should accept as its first argument a path to a filename. Each line in this file is one test case. 
	Ignore all empty lines. Each line begins with a positive integer(N) i.e. the size of the array, 
	then a semicolon followed by a comma separated list of positive numbers ranging from 0 to N-2, inclusive. i.e eg.
	 * 
	 * 
	 * Colin Taylor - colin_t@mit.edu
	 * 
	 * Note: I have seen a similar problem to this before, so I had an idea of how to do the algorithm already, but I still think
	 * that the algorithm is a neat little trick!
	 */

	/**
	 * @param args- text file with the correct syntax, described in the problem statement
	 * @output duplicate number
	 */
	public static void main(String[] args) {

		
		 try { // NOTE: try/catch block to read file- I got from codeeval.com (under github part)
		        File file = new File(args[0]);
		        BufferedReader in = new BufferedReader(new FileReader(file));
		        String line;
		        while ((line = in.readLine()) != null) {
		            String[] lineArray = line.split("\\s");
		            if (lineArray.length > 0) {
		                // Process line of input Here	            	
		            	
		            	String active_line = lineArray[0];
		            	// simple reg ex check to make sure line is valid
		            	if (!active_line.matches("[0-9]+;[0-9,]+")){
		            		System.out.println(active_line + " is not a valid input!");
		            	} else{		            	
			            	String[] temp = active_line.split(";");
			            	int N = Integer.valueOf(temp[0]);
			            	String[] string_numbs = temp[1].split(",");
			            	
			            	int comparison_sum = ((N-2) * (N-1) /2);// we know what the total should be w/o a duplicate
			            	for (int i = 0; i < string_numbs.length; i++){ //subtract each value- the answer will be the additive inv of the duplicate!
			            		comparison_sum = comparison_sum - Integer.valueOf(string_numbs[i]);
			            	}
			            	
			            	int ans = comparison_sum * -1;
			            	System.out.println("" + ans);           	
		            	}
		            }
		        }
		    } catch (IOException e) {
		        System.out.println("File Read Error: " + e.getMessage());
		    }
		 
	}

}
