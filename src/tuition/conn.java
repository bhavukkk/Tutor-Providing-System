package tuition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class conn {
    Connection c;
    public Statement s;
    public Statement s1,s2,s3;

    public PreparedStatement prepareStatement;

    public conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tuition_management", "root", "bhavuk@123");
            s = c.createStatement();
            s1 = c.createStatement();
            s2 = c.createStatement();
            s3 = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
