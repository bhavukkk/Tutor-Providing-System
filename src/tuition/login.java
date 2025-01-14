package tuition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JButton signin, clear, register, register1;
    JTextField emailTextField;
    JPasswordField pinTextField;

    login() {
        setTitle("TUTE IT UP!");
        setLayout(null);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel i7 = new JLabel(i6);
        i7.setBounds(0, 0, 800, 480);
        add(i7);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/education.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setLayout(null);
        label.setBounds(220, 35, 80, 80);
        i7.add(label);

        JLabel welcome = new JLabel("TUTE IT UP!");
        welcome.setFont(new Font("Times New Roman", Font.BOLD, 38));
        welcome.setBounds(320, 20, 400, 100);
        welcome.setForeground(Color.BLACK);
        i7.add(welcome);

        JLabel email = new JLabel("EMAIL:");
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        email.setBounds(250, 130, 400, 100);
        email.setForeground(Color.BLACK);
        i7.add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(370, 170, 200, 23);
        i7.add(emailTextField);

        JLabel pin = new JLabel("PASSWORD:");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pin.setBounds(250, 200, 400, 100);
        pin.setForeground(Color.BLACK);
        i7.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(370, 240, 200, 23);
        i7.add(pinTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(250, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        i7.add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(470, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        i7.add(clear);

        register = new JButton("REGISTER (Student)");
        register.setBounds(215, 360, 170, 33);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        i7.add(register);

        register1 = new JButton("REGISTER (Tutor)");
        register1.setBounds(440, 360, 170, 33);
        register1.setBackground(Color.BLACK);
        register1.setForeground(Color.WHITE);
        register1.addActionListener(this);
        i7.add(register1);

        getContentPane().setBackground(Color.CYAN);
        setSize(800, 480);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signin) {
            conn c = new conn();
            String email_text = emailTextField.getText();
            String password_text = pinTextField.getText();
            String query = "select * from login where email = '" + email_text + "'and password = '" + password_text + "'";
            String query1 = "select * from sign_student where email = '" + email_text + "'and password = '" + password_text + "'";
            String query2 = "select * from login_tutor where email = '" + email_text + "'and password = '" + password_text + "'";
            String query3 = "select * from tutors where email = '" + email_text + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                ResultSet rs1 = c.s1.executeQuery(query1);
                ResultSet rs2 = c.s2.executeQuery(query2);
                ResultSet rs3 = c.s3.executeQuery(query3);
                String s = "User";
                if (rs1.next()){
                    s = rs1.getString("name");
                } else if (rs3.next()) {
                    s = rs3.getString("name");
                }
                if (rs.next()) {
                    setVisible(false);
                    new home_page(s).setVisible(true);
                } else if (rs2.next()) {
                    setVisible(false);
                    new home_page(s).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect email or password!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == clear) {
            emailTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == register) {
            emailTextField.setText("");
            pinTextField.setText("");
            setVisible(false);
            new sign_up1().setVisible(true);
        } else if (ae.getSource() == register1) {
            emailTextField.setText("");
            pinTextField.setText("");
            setVisible(false);
            new register_tutor().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}