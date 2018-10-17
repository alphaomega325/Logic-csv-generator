/*
  Multiple Binary Generator
  @author: David Wright
  @Date: 10/17/18
  @version: .1
 */
import java.io.*;
import java.util.*;

class main {

    
    public static void main(String[] args){

	Scanner in = new Scanner(System.in);
	
	System.out.println("How man lines do you want for the csv file");

	String input = in.next();

	String output = "";

	float length = Float.parseFloat(input);
	
	int x1 = 0;
	int x2 = 0;
	int y = 0;

	int decider;

	float remainder;
	
	Operators operator = new Operators();
	
	try {

	    PrintWriter writer = new PrintWriter("xorgen.csv", "UTF-8");

	    Random rand = new Random();

	    output = output + "input1, input2, output, logic\n";

	    for(float i = 0; i < length; i++)
		{
		    x1 = rand.nextInt(2);
		    x2 = rand.nextInt(2);
		    
		    decider = rand.nextInt(4);
		    decider++;
		    switch(decider)
			{
			case 1: output = output + operator.and(x1,x2);
			    break;
			case 2: output = output + operator.not(x1);
			    break;
			case 3: output = output + operator.or(x1,x2);
			    break;
			case 4: output = output + operator.xor(x1,x2);
			    break;
			}
		    remainder = i % 10000;

		    if(remainder == 0)
			{
			writer.write(output);
			output = "";
			}
		}

	    writer.write(output);
	    writer.close();
	    


	} catch (IOException x) {

	    System.err.println(x);

	}

	

    }

}

class Operators{

    
    public String and(int input1, int input2){

	
	
	return String.valueOf(input1) + "," + String.valueOf(input2) + "," + String.valueOf(input1 & input2) + ",and\n"; 
  
    }

    public String not(int input1){

	return String.valueOf(input1) + ",-," + String.valueOf(~input1 + 2) + ",not\n"; 

    }

    public String or(int input1, int input2){

	return String.valueOf(input1) + "," + String.valueOf(input2) + "," + String.valueOf(input1 | input2) + ",or\n"; 

    }

    public String xor(int input1, int input2){

	return String.valueOf(input1) + "," + String.valueOf(input2) + "," + String.valueOf(input1 ^ input2) + ",xor\n"; 

    }






}
