package Oasistasks;

import java.util.Random;
import java.util.Scanner;

class Reservation{
	String user;
	String userid;
	String To;
	String From;
	int ticket=350;
	String date;
	String selectclass;
	int PNR;
	int status;
	String trainname;
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your UserName : ");
		this.user=sc.nextLine();
		System.out.println("Enter Your UserId : ");
		this.userid=sc.nextLine();
		System.out.println("Registration Succesful Plz Note Username & UsserId for Login\n:" + user +" & " +userid +"\nKindely Choice Option 2 for Login Ignore If Already register" );
		
	}
	public boolean loginForm() {
		boolean isLogin=false;
		while(!isLogin) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your UserName : ");
			String username2=sc.nextLine();
			System.out.println("Enter Your UserId : ");
			String userid2=sc.nextLine();
            if(username2.equals(user) && userid2.equals(userid)) {
				System.out.println("Login Succesful");
				System.out.println("Enter Full Details For Book Ticket : ");
				System.out.println("To :");
				this.To=sc.nextLine();
				System.out.println("From :");
				this.From=sc.nextLine();
				System.out.println("Select Date :");
				this.date=sc.nextLine();
				System.out.println("Select Class 1AC / 2AC / 3AC / SL :");
				this.selectclass=sc.nextLine();
				System.out.println("For Status of Ticket Choose Option 3 : ");
				Random rnd = new Random();
				PNR=rnd.nextInt();
				isLogin=true;
				status++;
				
				
				
			}else {
				System.out.println("Login Fail try Again ");
				System.exit(0);
				status--;
			}
			
			
		}
		
		return isLogin;
	}
	public void checkStatus() {
		if(status!=0) {
			System.out.println("Congo." + user+ " Your Ticket is Booked");
			System.out.println("Your PNR & Registration Time is : " +PNR + System.currentTimeMillis());
			System.out.println("Your Distination :  From " + From +" To " + To);
			System.out.println("Date " +date+" Train Class "+selectclass);
			System.out.println("Your Train is Nagpur Express"+"Price of ticket is : " +ticket);
			
		}
	}
}


public class IRCTC {

	public static void main(String[] args) {
		
		Reservation rs= new Reservation();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("**Welecome to Indian RailWays***");
			System.out.println("First Register & Then BookTicket & Last Check Status of Ticket");
			System.out.println("1 . For Register & Book Ticket ");
			System.out.println("2 . Exit ");
			int choice =sc.nextInt(); 
			if(choice==1) {
				while(true) {	
					System.out.println("1.Register \n2.BookTicket\n3.Check Status\n4.Exit");
					int choice2=sc.nextInt();
					switch(choice2)
					{
					case 1: rs.register();
					break;
					case 2: rs.loginForm();
					break;
					case 3: rs.checkStatus();
					break;
					case 4: System.exit(0);
					}
				}	
			
			}
			else {
					System.exit(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
