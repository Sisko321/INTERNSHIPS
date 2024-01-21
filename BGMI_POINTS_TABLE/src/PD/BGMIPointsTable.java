package PD;

import java.sql.*;
import java.util.Scanner;

public class BGMIPointsTable {

    public static void main(String[] args) throws Exception {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/bgmi_points_table";

        Class.forName(JDBC_DRIVER);
        System.out.println("Driver Loaded");
       
        String USER = user.getUserName();
        String PASS = user.getPassword();

        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Connected......");
        String insertQuery = "insert into esl_points_table values (?,?,?,?,?)";
        String deleteQuery = "delete from esl_points_table where Team=?";
        String showQuery = "select * from esl_points_table order by Total DESC";
        String truncateQuery = "TRUNCATE esl_points_table";
        String OverAllQuery = " SELECT COUNT(Team) AS TeamCount, SUM(PP) AS TotalPlacements,\r\n"
        		+ "SUM(Finishes) AS TotalFinishes, SUM(Total) AS GrandTotal FROM esl_points_table";
        	

        String team = "";
        int finish = 0;
        int place = 0;
        int total = 0;
        int rank = 0;

        while (true) {
            System.out.println("****** Welcome: BGMI Points Table Creator ******");
            System.out.println("1. INSERT TEAMS     :");
            System.out.println("2. DELETE TEAM      :");
            System.out.println("3. SHOW   TEAMS     :");
            System.out.println("4. DELETE ALL TEAMS :");
            System.out.println("5. OVERALL STANDINGS:");
            System.out.println("6. EXIT  :");

            int choice = sc.nextInt();

            if (choice == 1) {
            	System.out.println("No of teams Which U Add : ");
            	int nofmatch=sc.nextInt();
            	for(int i=0;i<nofmatch;i++) {
            	    team = user.getTeams();
                    place = user.getPlacementspoints();
                    finish = user.getFinishpoints();
                    total = user.getTotalpoints();

                    try (PreparedStatement pstm = con.prepareStatement(insertQuery)) {
                        pstm.setInt(1, ++rank);
                        pstm.setString(2, team);
                        pstm.setInt(3, place);
                        pstm.setInt(4, finish);
                        pstm.setInt(5, total);

                        int affectedrows = pstm.executeUpdate();
                        if (affectedrows > 0) {
                            System.out.println("Record Insert Successful");
                        } else {
                            System.out.println("Record Insert Unsuccessful");
                        }
                    }
            		
            	}
            
            } else if (choice == 2) {
                team = user.getTeams();

                try (PreparedStatement pst = con.prepareStatement(deleteQuery)) {
                    pst.setString(1, team);

                    int affectedrows = pst.executeUpdate();

                    if (affectedrows > 0) {
                        System.out.println("Record Deleted Successful");
                    } else {
                        System.out.println("Record Deleted Unsuccessful");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                PreparedStatement stm = con.prepareStatement(showQuery);
                ResultSet rs = stm.executeQuery();

                System.out.println("\nAll Records printing: ");
                System.out.println("+-----+---------------+---------------+---------------+---------------+");
                System.out.printf("|%-5s|%-15s|%-15s|%-15s|%-15s|\n", "Rank", "Team", "PP", "Finishes", "Total");
                System.out.println("+-----+---------------+---------------+---------------+---------------+");
                while (rs.next()) {
                    int r = rs.getInt("Rank");
                    String t = rs.getString("Team");
                    int p = rs.getInt("PP");
                    int f = rs.getInt("Finishes");
                    int tt = rs.getInt("Total");
                    System.out.printf("|%-5s|%-15s|%-15d|%-15d|%-15d|\n", r, t, p, f, tt);
                }
                System.out.println("+-----+---------------+---------------+---------------+---------------+");
            } else if (choice == 4) {
                Statement stm = con.createStatement();
                int rows = stm.executeUpdate(truncateQuery);
                if (rows == 0) {
                    System.out.println("Table Data Deleted Successful");
                } else {
                    System.out.println("Table Data Dleted Unsuccessful");
                }
            } else if (choice == 5) {
                Statement stm =con.createStatement();
                ResultSet rs=stm.executeQuery(OverAllQuery);
                System.out.println("+-----+---------------+---------------+---------------+---------------+");
                System.out.printf("|%-5s|%-15s|%-15s|%-15s|%-15s|\n", "Rank", "NO of Teams", "Total PP", "Total Finishes", "Total Points");
                System.out.println("+-----+---------------+---------------+---------------+---------------+");
                while (rs.next()) {
                	int r=1;
                	int noteams=rs.getInt("TeamCount");
                	int sumPP=rs.getInt("TotalPlacements");
                	int finishPoints=rs.getInt("TotalFinishes");
                	int grandtotal=rs.getInt("GrandTotal");
                	 System.out.printf("|%-5s|%-15d|%-15d|%-15d|%-15d|\n", r, noteams, sumPP, finishPoints,
                             grandtotal);
                     System.out.println("+-----+---------------+---------------+---------------+---------------+");
                }
            } else if(choice==6){
            	System.out.println("Thank You Visit Again : ");
            	System.exit(0);
                sc.close();
            }
        }
       
    } 
}
