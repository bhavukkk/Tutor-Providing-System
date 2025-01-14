package tuition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.util.*;
import java.util.regex.*;

public class sign_up1 extends JFrame implements ActionListener{
    long random;
    JTextField name,p_num,p_email;
    JPasswordField p_password;
    JComboBox val_box;
    JCheckBox terms;
    JButton submit,back;
    sign_up1(){
        setTitle("Registration Form - 1");
        setLayout(null);
        Random ran =new Random();
        random = Math.abs((ran.nextLong()% 9000L)+1000L);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg4.jpg"));
        Image i1 = i.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,700,700);
        add(i3);

        JLabel head = new JLabel("Register as a Student");
        head.setForeground(Color.black);
        head.setFont(new Font("Arial",Font.BOLD,20));
        head.setBounds(240,70,250,50);
        i3.add(head);

        name = new JTextField("Student's Name",20);
        name.setForeground(Color.gray);
        name.setBounds(210,150,270,30);
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name.getText().equals("Student's Name")){
                    name.setText("");
                    name.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (name.getText().isEmpty()) {
                    name.setText("Student's Name");
                    name.setForeground(Color.GRAY);  // Set placeholder text color again
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,700));
        i3.add(panel);
        i3.add(name);

        p_email = new JTextField("Student/Parent's Email",25);
        p_email.setForeground(Color.gray);
        p_email.setBounds(210,190,270,30);
        p_email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(p_email.getText().equals("Student/Parent's Email")){
                    p_email.setText("");
                    p_email.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(p_email.getText().isEmpty()){
                    p_email.setText("Student/Parent's Email");
                    p_email.setForeground(Color.gray);
                }
            }
        });
        i3.add(p_email);

        p_num = new JTextField("Student/Parent's Number",25);
        p_num.setForeground(Color.gray);
        p_num.setBounds(210,230,270,30);
        p_num.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(p_num.getText().equals("Student/Parent's Number")){
                    p_num.setText("");
                    p_num.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(p_num.getText().isEmpty()){
                    p_num.setText("Student/Parent's Number");
                    p_num.setForeground(Color.gray);
                }
            }
        });
        i3.add(p_num);

        String val_state[] = {"Select State","Delhi","Gurgaon","Mumbai","Bangalore","Punjab","Kolkata"};
        val_box = new JComboBox<>(val_state);
        val_box.setBounds(210,270,270,30);
        val_box.setBackground(Color.WHITE);
        i3.add(val_box);

        p_password = new JPasswordField("Password",20);
        p_password.setForeground(Color.gray);
        p_password.setBounds(210,310,270,30);
        p_password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (p_password.getText().equals("Password")){
                    p_password.setText("");
                    p_password.setEchoChar('*');
                    p_password.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(p_password.getText().isEmpty()){
                    p_password.setEchoChar((char) 0);
                    p_password.setText("Password");
                    p_password.setForeground(Color.gray);
                }
            }
        });
        p_password.setEchoChar((char) 0);
        i3.add(p_password);

        terms = new JCheckBox();
        terms.setSelected(false);
        terms.setBounds(230,370,20,20);
        JLabel terms1 = new JLabel("<html><u>I agree to Terms & Conditions</u></html>");
        terms1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        terms1.setForeground(Color.black);
        terms1.setFont(new Font("Times New Roman",Font.BOLD,15));
        terms1.setBounds(260,355,300,50);
        terms1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new terms_condition().setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        i3.add(terms1);
        i3.add(terms);

        submit = new JButton("Submit");
        submit.setBounds(300,435,100,30);
        submit.setFocusPainted(false);
        float hue = 0.05f;        // Hue for brown (between 0 and 1)
        float saturation = 0.65f; // Saturation level (between 0 and 1)
        float brightness = 0.55f; // Brightness level (between 0 and 1)
        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
        submit.setBackground(new Color(rgb));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        i3.add(submit);

        back = new JButton("BACK");
        back.setBounds(570, 620, 75, 30);
        back.setFocusPainted(false);
        back.setFont(new Font("Arial",Font.BOLD,13));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        i3.add(back);

        JLabel upper = new JLabel();
        upper.setBackground(Color.orange);
        upper.setOpaque(true);
        upper.setBounds(145,60,400,500);
        i3.add(upper);

        setSize(700,700);
        setVisible(true);
        setLocation(400,50);
        SwingUtilities.invokeLater(() -> {
            panel.requestFocusInWindow();  // Set focus on panel instead of the text field
        });
    }
    public void actionPerformed(ActionEvent ae){
        char ch = name.getText().charAt(0);
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String nameRegex = "^[A-Za-z\\s'-]+$";
        Pattern pattern1 = Pattern.compile(nameRegex);
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(p_email.getText());
        Matcher matcher1 = pattern1.matcher(name.getText());
        if (ae.getSource() == back) {
            setVisible(false);
            new home_page("User").setVisible(true);
        }
        if(ae.getSource() == submit){
            if(!terms.isSelected()){
                String query = null;
                JOptionPane.showMessageDialog(null,"Please Agree to Terms & Conditions");
            } else if (name.getText().equals("Student's Name")) {
                JOptionPane.showMessageDialog(null, "Name can't be null");
            } else if (name.getText().length()<2 || !Character.isUpperCase(ch) || !matcher1.matches()) {
                if(name.getText().length()<2) {
                    JOptionPane.showMessageDialog(null, "Name can't be less than 3 characters");
                } else if (!Character.isUpperCase(ch)) {
                    JOptionPane.showMessageDialog(null, "First letter of the name should be capital");
                } else if (!matcher1.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                }
            } else if (p_email.getText().equals("Student's/Parent's Email")) {
                JOptionPane.showMessageDialog(null, "Email can't be null");
            }else if (p_email.getText().length()<10||!matcher.matches()) {
                JOptionPane.showMessageDialog(null,"Invalid Email");
            } else if (p_num.getText().length()>10 || p_num.getText().length()<10|| !p_num.getText().matches("^[6-9]\\d{9}$")) {
                JOptionPane.showMessageDialog(null,"Mobile No. is Invalid");
            } else if (val_box.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null,"Please select state");
            } else if (p_password.getText().length()>8 || p_password.getText().length()<8 || p_password.getText().equals("Password")) {
                if (p_password.getText().equals("Password")){
                    JOptionPane.showMessageDialog(null,"Password can't be null");
                } else if (p_password.getText().length()>8 || p_password.getText().length()<8) {
                    JOptionPane.showMessageDialog(null,"Password should be of 8 characters");
                }
            } else {
                conn c = new conn();
                String num = Long.toString(random);
                String a = name.getText();
                String b = p_email.getText();
                String co = p_num.getText();
                String d = (String) val_box.getSelectedItem();
                String e = p_password.getText();
                String query = "insert into sign_student values('" + num + "','" +a+ "','" +b+ "','" +co+ "','" +d+"','" +e+ "')";
                String query1 = "insert into login values('" + num + "','" +b+ "','" +e+ "')";
                try {
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                } catch (SQLException se) {
                    throw new RuntimeException(se);
                }
                setVisible(false);
                String query2 = "select * from sign_student where email = '" + b + "'and password = '" + e + "'";
                String x = null;
                ResultSet rs;
                try {
                    rs = c.s.executeQuery(query2);
                    if(rs.next()){
                        x = rs.getString("name");
                    }
                }catch (SQLException se){
                    System.out.println(se);
                }
                new home_page(x).setVisible(true);
            }
        }
    }
    public static void main(String[] args) {
        new sign_up1();
    }
}
