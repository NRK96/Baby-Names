/* Name: Nicholas Keen
 * Course: Computer Science - CIS I
 * Section: 003
 * Assignment: 10
*/
import java.io.*;
import java.util.*;

//This program reads a file and
//displays the information for 
//the popularity of a specific 
//baby name.
public class BabyNames {

    //Creates a scanner and reads the file,
    //then sets a method equal to name, 
    //and calls the other methods.
    public static void main(String[] args) 
	    throws FileNotFoundException {
	File file = new File("names.txt");
	Scanner fileScanner = new Scanner(file);
	String name = getName();
	display(getDataLine(name, fileScanner), name);
    }
    
    //displays the intro and prompts/reads
    //user input, returns said input.
    public static  String getName() {
	Scanner sc = new Scanner(System.in);
	System.out.print("This program graphs the popularity " +
			   "of a name\nin Social Security baby " +
			   "name statistics\nrecorded since the " +
			   "year 1900.\n\nType a name: ");
			   
	String name = sc.nextLine();
	return name;
    }
    
    //Checks for the name entered and if possible
    //returns the line of data for said name.
    public static String getDataLine(String name, Scanner fileScanner) {
	
	while(fileScanner.hasNextLine()) {
	    String nameCheck = fileScanner.nextLine();
	    Scanner tokenScanner = new Scanner(nameCheck);
	    if((tokenScanner.next()).equalsIgnoreCase(name)) {
		return nameCheck;
	    }
	}
	return "";
    }
    
    //Prints out the individual data pieces 
    //year by year or prints name not found
    //if the name was not on file.
    public static void display(String data, String name) {
	if(data.equals("")) {
	    System.out.println("\"" + name + "\" not found.");
	}else{
	    Scanner dataReader = new Scanner(data);
	    int date = 1900;
	    while(dataReader.hasNext()) {
		name = dataReader.next();
		System.out.println("Statistics on name \"" + name + "\"");
		int popularity;
		while(date != 2010) {
		    while(dataReader.hasNextInt()) {
			popularity = dataReader.nextInt();
			System.out.println(date + ": " + popularity);
			date = date + 10;
		    }
		}
	    }
	}
    }
}