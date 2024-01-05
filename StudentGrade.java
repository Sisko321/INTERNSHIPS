package SKYBUG;

import java.util.Scanner;

public class StudentGrade {

	public static void main(String[] args) {
  
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your total Subject");
		int totalsubject =sc.nextInt();
		int totalmarks=0;
		int maxMarksperSub=100;
		for(int i=0; i<totalsubject;i++) {
			System.out.println("Enter your Subject Marks : ");
			int eachsubmarks=sc.nextInt();
			if(eachsubmarks <0 ||eachsubmarks > maxMarksperSub) {
				System.out.println("Marks should be betwn 0 to 100 ");
				i--;
			}else {
				totalmarks+=eachsubmarks;
			}
		}
		
		
		double avgmarks=(double)totalmarks / (totalsubject * 100) * 100;
	    String grade;
		String result="";
		if(avgmarks>=90) {
			grade="A+";
		}
		else if (avgmarks >= 85) {
			grade="A";
			result="Pass";
		}
		else if (avgmarks >= 75) {
			grade="B+";
			result="Pass";
		}
		else if (avgmarks >= 65) {
			grade="B";
			result="Pass";
		}
		else if (avgmarks >= 55) {
			grade="C";
			result="Pass";
		}else if (avgmarks >=35) {
			grade="D";
			result="Pass";
		}else {
			grade="F";
			result="Fail";
		}
		
		System.out.println("Total Subject : " +totalsubject);
		System.out.println("Total Marks   : " +totalmarks );
		System.out.println("You "+result+" With "+avgmarks +" % With Grade " +grade);

		

		
		
		
	}

}
