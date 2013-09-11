import java.io.*;
public class SecureSystem {
	public static void main(String[] args) {
		// create subjects with security label

		// create objects with security label

		// read command line
		System.out.println("Hello!");
		
		System.out.println(args[0]);			
			// open file (name in args[0])


	try {		
	    FileReader fr = new FileReader(args[0]); 
		BufferedReader br = new BufferedReader(fr); 
		String s; 
		while((s = br.readLine()) != null) { 
		System.out.println(s); 
		} 
		fr.close(); 
	}
	catch(Exception e) {
		System.out.println("Error!!! ");
		e.printStackTrace();
	}
		System.out.println("Done!.");
		// execute commands

		// print states 
	}
}