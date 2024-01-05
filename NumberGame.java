package SKYBUG;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
       try {
    	   int guess,attempt=5;
   		Scanner sc = new Scanner(System.in);
   		Random rnd = new Random();
   		System.out.println("    Welecome to Guessing Number Game   ");
   		String start ="yes";
   		int max =100;
   		while(start.equals("yes")) {
   		attempt=1;
   		int number =rnd.nextInt(max)+1;
    	System.out.println("    Guess Your Number btwn 0 to 100 ");
    	while(true) {
    			guess=sc.nextInt();
    			sc.nextLine();
    			
    			if(number == guess) {
    				System.out.println("Cong. u win The Game & Score is " + attempt + " & Original Guess Is :  "+number );
    				attempt++;
    			}
    			else if(number < guess ) {
    				System.out.println("Try Less number  :" );
    				attempt++;
    			}
    			else if(number > guess ) {
    				System.out.println("Try big number  :" );
    				attempt++;
    			}
    			else{
    				break;
    			}
    			
    		}
    	    System.out.println("Do you Want play game again ?(yes/no) : ");
        	start=sc.nextLine().toLowerCase();
    	
    	
    	}
   		System.out.println("Thank u for Playing visit again ");
       }catch(Exception e) {
    	   System.out.println("plz Enter valid Number : ");
    	   e.printStackTrace();
       }
       	
	}

}
