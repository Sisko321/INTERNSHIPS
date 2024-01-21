package PD;

import java.util.Scanner;

public class User {
		Scanner sc = new Scanner(System.in);
		private String teams="";
		private int finishpoints=0;
		private int placementspoints=0;
		
		private String username="";
		private String password="";
		public int getFinishpoints() {
			System.out.println("Enter Total Finishes of Team : ");
			finishpoints=sc.nextInt();
			
			return finishpoints;
		}
		public int getPlacementspoints() {
			System.out.println("Enter Your Rank in the Match : ");
	        int Rank=sc.nextInt();
	        if(Rank==1) {
	        	placementspoints=15;
	        }else if(Rank==2) {
	        	placementspoints=12;
	        }
	        else if(Rank==3) {
	        	placementspoints=10;
	        }
	        else if(Rank==4) {
	        	placementspoints=8;
	        }
	        else if(Rank==5) {
	        	placementspoints=6;
	        }
	        else if(Rank==6) {
	        	placementspoints=5;
	        }
	        else if(Rank==7) {
	        	placementspoints=4;
	        }
	        else if(Rank==8) {
	        	placementspoints=3;
	        }
	        else if(Rank==9) {
	        	placementspoints=2;
	        }
	        else if(Rank==10) {
	        	placementspoints=1;
	        }else {
	        	placementspoints=0;
	        }

	        return this.placementspoints;
		}
		public int getTotalpoints() {
			return finishpoints+placementspoints;
		}
		public String getTeams() {
			System.out.println("Enter team Name : ");
			teams=sc.next();
			return teams;
		}
		public String getUserName() {
			System.out.println("Enter Your UserName : ");
			username=sc.nextLine();
			return username;
		}
		public String getPassword() {
			System.out.println("Enter Your PassWord : ");
			password=sc.nextLine();
			return password;
		}
		public int matchno() {
			System.out.println("Enter Match No :");
			int matchno=sc.nextInt();
			return matchno;
		}
		
	}

