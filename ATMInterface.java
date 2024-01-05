package SKYBUG;

import java.util.Scanner;
public class ATMInterface{
	public static void main(String[] args) {
		System.out.println("********Wlcm to ATM INTERFACE***********");
		System.out.println("Enter Choice :");
		System.out.println("1. Register ");
		System.out.println("2. Exit ");
		Scanner sc = new Scanner(System.in);
		int choice=sc.nextInt();
		if(choice==1) {
			BankAccount ba = new BankAccount();
			ba.register();
			while(true) {
				System.out.println("Enter your Choice : ");
				System.out.println("1. Login");
				System.out.println("2. Exit");
				int choice2 =sc.nextInt();
				if(choice2==1) {
					if(ba.login()) {
						System.out.println("Happy to See U Again " + ba.name);
						boolean stop=false;
						while(!stop) {
							System.out.println("\n 1.Deposit \n 2.Withdraw \n 3.Transactions History \n 4.CheckBalance \n 5.Exit");
							
							int choice3=sc.nextInt();
							switch(choice3) {
							case 1: 
								ba.deposit();
							break;
							case 2: 
								ba.withdraw();
							break;
							case 3: 
								ba.transHistory();
							break;
							case 4: 
								ba.checkbalance();
							break;
							case 5: 
								stop=true;
							break;
							}
							
							
						}
					}
				}else {
					System.exit(0);
				}

			}
			
			
			
		}
		else 
		{
			System.exit(0);
		}
		

	}
}
class BankAccount {


	String name;
	String userid;
	String userpin;
	String AccountNo;
	double balance=100000d;
	int transactions=0;
	String transactionHistory="";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name : ");
		this.name=sc.nextLine();
		System.out.println("Enter Your user Id : ");
		this.userid=sc.nextLine();
		System.out.println("Enter Your UserPin : ");
		this.userpin=sc.nextLine();
		System.out.println("Enter Your AccountNO : ");
		this.AccountNo=sc.nextLine();
		System.out.println("Cong. Registration Done !");
	}
	public boolean login() {
		boolean isLogin =false;
		Scanner sc = new Scanner(System.in);
		while(!isLogin) {
			System.out.println("Enter Your UserName : ");
			String UserName=sc.nextLine();
			if(UserName.equals(userid)) {
				while(!isLogin){
					System.out.println("Enter Your Pass :");
					String Pass = sc.nextLine();
					if(Pass.equals(userpin)) {
						System.out.println("Login Succesful : ");
						isLogin=true;
					}
					else {
						System.out.println("InCorrect Pass ");
					}
				}
			}else {
				System.out.println("InValid Login ");
			}
		}
		return isLogin;
	}
	public void deposit() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Deposit Amount ");
		int amount=sc.nextInt();
		try {
			if(amount <=balance) {
				transactions++;
				balance = balance+amount;
				System.out.println("Succesfully deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("Linit is 1000000.00");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Withdraw amount : ");
		int amount = sc.nextInt();
		try {
			if(balance>= amount) {
				transactions++;
				balance= balance-amount;
				System.out.println("Withdraw Succesfull ");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
	public void checkbalance() {
		System.out.println("Your Overall Balance is : "+balance);
	}
	
	
	
}