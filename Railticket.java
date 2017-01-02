package railticket;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Railticket {

    static String q1;
    static String q2;
    static String q3;
    static String q4;
    static int q5;
    static String q6;
    static String q7;
    static int i1;
    static int z1;
    static String i2;
    static int r9;
    static int w1;
    static String w2;
    static String w3;
    static int w4;
    static String w5;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Railticket rt = new Railticket();
        Scanner sc = new Scanner(System.in);
        System.out.println("***************RAILWAY_COUNTER***************");
        System.out.println("PLEASE, ENTER USER ID YOU WANT TO SET(INTEGER):");
        rt.i1 = sc.nextInt();

        System.out.println("PLEASE, ENTER THE PASSWORD YOU WANT TO SET:");
        rt.i2 = sc.next();

        if (admin(rt.i1, rt.i2)) {
            adminmenu();
        } else {
            usermenu();
        }

    }

    public static void adminmenu() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        for (int x = 0; x >= 0; x++) {

            System.out.println("PLEASE CHOOSE FROM THE FOLLOWING OPTIONS: ");
            System.out.println("(1).SHOW ROADMAP");
            System.out.println("(2).CHANGE STOPS");
            System.out.println("(3).SHOW FARE BETWEEN TWO STOPS");
            System.out.println("(4).CHANGE FARE BETWEEN TWO STOPS");
            System.out.println("(5).SHOW PASSENGER DETAILS");
            System.out.println("(6).MONEY COLLECTED IN EACH TRANSACTION");
            System.out.println("(7).ADD ADMIN");
            System.out.println("(8).SHOW ADMIN");
            System.out.println("ENTER THE OPTION YOU WANT TO GO WITH:");
            int a = sc.nextInt();

            switch (a) {
                case 1:
                    showroadmap();
                    break;
                case 2:
                    changestops();
                    break;
                case 3:
                    existingfares();
                    break;
                case 4:
                    changefare();
                    break;
                case 5:
                    passdetails();
                    break;
                case 6:
                    netmoney();
                    break;
                case 7:
                    addadmin();
                    break;
                case 8:
                    showadmin();
                    break;
            }

            System.out.println("#########################END OF TASK##########################");
            System.out.println("DO YOU WANT TO CONTINUE:'y' FOR YES AND 'n' FOR NO:");
            char ch;
            ch = sc.next().charAt(0);
            if (ch == 'y') {

            } else {
                System.out.println("*************************************************");
                System.out.println("THANKS FOR YOUR PATIENCE!!!!!!!!!!");
                System.out.println("CREATED BY VAIBHAV SHARMA");

                System.out.println("*************************************************");
                break;
            }

        }
    }

    public static void usermenu() throws ClassNotFoundException, SQLException
    {
       
        
            
                
                    setdestination();
                    System.out.println("#########################END OF TASK##########################");
                    System.out.println("*************************************************");
                    System.out.println("THANKS FOR YOUR PATIENCE!!!!!!!!!!");
                    System.out.println("CREATED BY VAIBHAV SHARMA");

                    System.out.println("*************************************************");
                   
                    
                    

            
            
            
        
    }

    private static void showroadmap() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();
        String q = "select * from roadmap";
        ResultSet rs = stmt.executeQuery(q);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        stmt.close();
        conn.close();

    }

    private static void changestops() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("PLEASE CHOOSE FROM THE FOLLOWING OPTIONS:");
        System.out.println("(1).REMOVE A STOP");
        System.out.println("(2).ADD A STOP");
        int a = sc.nextInt();

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();
        String q = "select * from roadmap";
        ResultSet rs = stmt.executeQuery(q);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        switch (a) {
            case 1:

                Railticket rt = new Railticket();
                System.out.println("PLEASE, ENTER THE NAME OF THE STATION YOU WANT TO DELETE:");
                rt.q1 = sc.next();
                q1 = "delete from roadmap where stops ='" + rt.q1 + "';";
                stmt.executeUpdate(q1);
                stmt.close();
                conn.close();
                break;
            case 2:
                Railticket rt1 = new Railticket();
                System.out.println("PLEASE, ENTER THE NAME OF THE STATION YOU WANT TO ADD:");
                rt1.q3 = sc.next();
                String q3 = "insert into roadmap values('" + rt1.q3 + "')";
                stmt.executeUpdate(q3);
                stmt.close();
                conn.close();
                break;

        }

    }

    private static void existingfares() throws SQLException, ClassNotFoundException {
        System.out.println("FARE BETWEEN TWO STOPS:");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();
        String q = "select * from fare";
        ResultSet rs = stmt.executeQuery(q);
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
        stmt.close();
        conn.close();

    }
    
    public static void changefare() throws ClassNotFoundException, SQLException 
    {
       Railticket rt = new Railticket();
       Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();
        System.out.println("EXISTING FARE:");
        String q = "select * from fare";
        ResultSet rs = stmt.executeQuery(q);
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
        System.out.println("PLEASE, ENTER THE REVISED FARE BETWEEN TWO STOPS:");
        rt.z1=sc.nextInt();
        String q1 = "update fare set price_between_two_stops="+rt.z1+" ";
        stmt.executeUpdate(q1);
        stmt.close();
        conn.close();
        
    }

    private static void passdetails() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();
        String q = "select * from passenger";
        ResultSet rs = stmt.executeQuery(q);
        System.out.println("USERID     PASSWORD       NAME     CONTACT     INITIAL STATION  FINALL STATION   TOTAL FARE");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "         " + rs.getString(2) + "        " + rs.getString(3) + "     " + rs.getInt(4) + "      " + rs.getString(5) + "        " + rs.getString(6) + "        " + rs.getInt(7));
        }
        stmt.close();
        conn.close();

    }

    private static void netmoney() throws SQLException, ClassNotFoundException {
        System.out.println(" MONEY EARNED IN EVERY TRANSACTION:");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();

        String q14 = "select * from earned";
        ResultSet rs = stmt.executeQuery(q14);
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
        int tot=0;
        ResultSet rs1 = stmt.executeQuery(q14);
        while(rs1.next())
        {
            tot+=rs1.getInt(1);
        }
        System.out.println("TOTAL INCOME: "+ tot);
        stmt.close();
        conn.close();

    }

    private static void setdestination() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();

        Railticket rt = new Railticket();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR NAME:");
        rt.q4 = sc.next();
        System.out.println("ENTER YOUR CONTACT NUMBER:");
        rt.q5 = sc.nextInt();

        String q = "select * from roadmap";
        ResultSet rs = stmt.executeQuery(q);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        System.out.println("ENTER YOUR INITIAL STATION:");
        rt.q6 = sc.next();

        System.out.println("ENTER YOUR FINAL STATION:");
        sc.nextLine();
        rt.q7 = sc.next();

        ArrayList<String> list = new ArrayList<String>();
        String q8 = "select * from roadmap";
        ResultSet rs1 = stmt.executeQuery(q8);
        while (rs1.next()) {
            list.add(rs1.getString("station"));
        }

        String[] result = new String[list.size()];
        result = list.toArray(result);

        int t = 0, r = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals(rt.q6)) {
                t = i;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals(rt.q7)) {
                r = i;
            }
        }

        int e = r - t;
        
        String q2 = "select * from fare";
        ResultSet rs2 = stmt.executeQuery(q2);
        
        int to = 0;
        while(rs2.next())
        {
            to+=rs2.getInt(1);
        }
       

        rt.r9 = e * to;
        System.out.println("YOUR TOTAL FARE IS:");
        System.out.println(rt.r9);

        String q12 = "insert into passenger(userid,password,name,contact,intial_station,final_station,total_fare) values (" + rt.i1 + ",'" + rt.i2 + "','" + rt.q4 + "'," + rt.q5 + ",'" + rt.q6 + "','" + rt.q7 + "'," + rt.r9 + ")";
        stmt.executeUpdate(q12);
        
        System.out.println("ENJOY YOUR RIDE!!!!HAPPY JOURNEY!!!!!!");

        int total = 0;
        total += rt.r9;
        String q11 = "insert into earned(money_earned) values (" + total + ")";
        stmt.executeUpdate(q11);
        stmt.close();
        conn.close();

    }

    private static void addadmin() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Railticket rt = new Railticket();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();
        System.out.println("ENTER USER ID:");
        rt.w1 = sc.nextInt();
        System.out.println("ENTER PASSWORD:");
        rt.w2 = sc.next();
        System.out.println("ENTER NAME:");
        rt.w3 = sc.next();
        System.out.println("ENTER CONTACT NUMBER:");
        rt.w4 = sc.nextInt();
        rt.w5 = "admin";

        String q = "insert into admin(userid, password,name ,contact,type) values (" + rt.w1 + ",'" + rt.w2 + "','" + rt.w3 + "'," + rt.w4 + ",'" + rt.w5 + "' )";
        stmt.executeUpdate(q);
        stmt.close();
        conn.close();

    }

    public static boolean admin(int id, String pass) throws ClassNotFoundException, SQLException {
        boolean st = false;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        PreparedStatement ps = con.prepareStatement("select * from admin where userid=? and password=? and type='admin' ");
        ps.setInt(1, id);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        st = rs.next();

        return st;
    }

    private static void showadmin() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail", "root", "root");
        Statement stmt = conn.createStatement();
        String q = "select * from admin";
        ResultSet rs = stmt.executeQuery(q);
        System.out.println("USERID          PASSWORD           NAME         CONTACT     ");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "             " + rs.getString(2) + "            " + rs.getString(3) + "         " + rs.getInt(4));
        }
        stmt.close();
        conn.close();

    }

}
