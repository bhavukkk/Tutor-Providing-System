package tuition;

import java.awt.geom.RectangularShape;
import java.sql.*;
import java.sql.SQLException;
import java.util.Random;
import java.util.*;
import java.util.regex.*;

public class practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email ID: ");
//        String email = scanner.nextLine();
        String name = scanner.nextLine();

        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String nameRegex = "^[A-Za-z\\s'-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Pattern pattern1 = Pattern.compile(nameRegex);
//        Matcher matcher = pattern.matcher(email);
        Matcher matcher1 = pattern1.matcher(name);

        if (matcher1.matches()) {
            System.out.println("Valid name with a domain name.");
        } else {
            System.out.println("Invalid name. Make sure it includes a domain name.");
        }

        scanner.close();
    }
}
