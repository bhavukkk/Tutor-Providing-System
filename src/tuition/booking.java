package tuition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.util.regex.*;

public class booking extends JFrame implements ActionListener{
    long random;
    String book_id;
    String passing;
    JButton submit,back;
    JCheckBox terms;
    JTextField s_name,p_name,s_num,s_email,ss_name,s_address,tutor_id;
    JComboBox val_box,s_grade;
    String id,grading,subjecting;
    booking(String username,String t_id,String grade,String subject){
        this.passing = username;
        this.grading = grade;
        this.subjecting = subject;
        this.id = t_id;
        random = (int)(Math.random() * 900000) + 100000;
        book_id = "T2404" + random;
        setTitle("Booking Form");

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg4.jpg"));
        Image i1 = i.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,700,700);
        add(i3);

        JLabel head = new JLabel("Enter Your Details Here: ");
        head.setForeground(Color.black);
        head.setFont(new Font("Arial",Font.BOLD,18));
        head.setBounds(200,70,250,50);
        i3.add(head);

        s_name = new JTextField("Student's Name",20);
        s_name.setForeground(Color.gray);
        s_name.setBounds(250,130,270,30);
        s_name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (s_name.getText().equals("Student's Name")){
                    s_name.setText("");
                    s_name.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (s_name.getText().isEmpty()) {
                    s_name.setText("Student's Name");
                    s_name.setForeground(Color.GRAY);  // Set placeholder text color again
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,700));
        i3.add(panel);
        i3.add(s_name);

        p_name = new JTextField("Parent's Name",20);
        p_name.setForeground(Color.gray);
        p_name.setBounds(250,170,270,30);
        p_name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (p_name.getText().equals("Parent's Name")){
                    p_name.setText("");
                    p_name.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (p_name.getText().isEmpty()) {
                    p_name.setText("Parent's Name");
                    p_name.setForeground(Color.GRAY);  // Set placeholder text color again
                }
            }
        });
        i3.add(p_name);

        s_email = new JTextField("Student/Parent's Email",25);
        s_email.setForeground(Color.gray);
        s_email.setBounds(250,210,270,30);
        s_email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(s_email.getText().equals("Student/Parent's Email")){
                    s_email.setText("");
                    s_email.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(s_email.getText().isEmpty()){
                    s_email.setText("Student/Parent's Email");
                    s_email.setForeground(Color.gray);
                }
            }
        });
        i3.add(s_email);

        s_num = new JTextField("Student/Parent's Number",25);
        s_num.setForeground(Color.gray);
        s_num.setBounds(250,250,270,30);
        s_num.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(s_num.getText().equals("Student/Parent's Number")){
                    s_num.setText("");
                    s_num.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(s_num.getText().isEmpty()){
                    s_num.setText("Student/Parent's Number");
                    s_num.setForeground(Color.gray);
                }
            }
        });
        i3.add(s_num);

        String val_grade[] = {"Select Grade","6th","7th","8th","9th","10th","11th","12th"};
        s_grade = new JComboBox<>(val_grade);
        s_grade.setForeground(Color.black);
        s_grade.setBounds(250,290,270,30);
        i3.add(s_grade);

        ss_name = new JTextField("School Name",30);
        ss_name.setForeground(Color.gray);
        ss_name.setBounds(250,330,270,30);
        ss_name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ss_name.getText().equals("School Name")){
                    ss_name.setText("");
                    ss_name.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (ss_name.getText().isEmpty()) {
                    ss_name.setText("School Name");
                    ss_name.setForeground(Color.GRAY);  // Set placeholder text color again
                }
            }
        });
        i3.add(ss_name);

        s_address = new JTextField("Student's Address",30);
        s_address.setForeground(Color.gray);
        s_address.setBounds(250,370,270,30);
        s_address.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (s_address.getText().equals("Student's Address")){
                    s_address.setText("");
                    s_address.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (s_address.getText().isEmpty()) {
                    s_address.setText("Student's Address");
                    s_address.setForeground(Color.GRAY);  // Set placeholder text color again
                }
            }
        });
        i3.add(s_address);

        String val_state[] = {"Select State","Delhi","Gurgaon","Mumbai","Bangalore","Punjab","Kolkata"};
        val_box = new JComboBox<>(val_state);
        val_box.setBounds(250,410,270,30);
        val_box.setBackground(Color.WHITE);
        i3.add(val_box);

        tutor_id = new JTextField(20);
        tutor_id.setForeground(Color.gray);
        tutor_id.setFocusable(false);
        tutor_id.setBounds(250,450,270,30);
        tutor_id.setText("Tutor ID: " + id);
        i3.add(tutor_id);

        terms = new JCheckBox();
        terms.setSelected(false);
        terms.setBounds(263,510,20,20);
        JLabel terms1 = new JLabel("<html><u>I agree to Terms & Conditions</u></html>");
        terms1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        terms1.setForeground(Color.black);
        terms1.setFont(new Font("Times New Roman",Font.BOLD,15));
        terms1.setBounds(293,495,300,50);
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

        submit = new JButton("Confirm");
        submit.setBounds(205,580,100,30);
        submit.setFocusPainted(false);
        float hue = 0.05f;        // Hue for brown (between 0 and 1)
        float saturation = 0.65f; // Saturation level (between 0 and 1)
        float brightness = 0.55f; // Brightness level (between 0 and 1)
        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
        submit.setBackground(new Color(rgb));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        i3.add(submit);

        back = new JButton("Back");
        back.setBounds(475,580,100,31);
        back.setFocusPainted(false);
        back.setBackground(new Color(rgb));
        back.setForeground(Color.black);
        back.addActionListener(this);
        i3.add(back);

        JLabel upper = new JLabel();
        upper.setBackground(Color.orange);
        upper.setOpaque(true);
        upper.setBounds(140,60,500,600);
        i3.add(upper);

        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
        SwingUtilities.invokeLater(() -> {
            panel.requestFocusInWindow();  // Set focus on panel instead of the text field
        });
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            char ch = s_name.getText().charAt(0);
            char ch1 = p_name.getText().charAt(0);
            char ch2 = ss_name.getText().charAt(0);
            String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            String nameRegex = "^[A-Za-z\\s'-]+$";
            String addressRegex = "^[A-Za-z0-9\\s,.'-]{5,}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Pattern pattern1 = Pattern.compile(nameRegex);
            Pattern pattern2 = Pattern.compile(addressRegex);
            Pattern pattern3 = Pattern.compile(nameRegex);
            Pattern pattern4 = Pattern.compile(nameRegex);
            Matcher matcher = pattern.matcher(s_email.getText());
            Matcher matcher1 = pattern1.matcher(s_name.getText());
            Matcher matcher2 = pattern2.matcher(s_address.getText());
            Matcher matcher3 = pattern3.matcher(p_name.getText());
            Matcher matcher4 = pattern4.matcher(ss_name.getText());

            conn c = new conn();
            if(!terms.isSelected()){
                String query = null;
                JOptionPane.showMessageDialog(null,"Please Agree to Terms & Conditions");
            } else if (s_name.getText().length()<2 || !Character.isUpperCase(ch)|| !matcher1.matches()) {
                if(s_name.getText().length()<2) {
                    JOptionPane.showMessageDialog(null, "Name can't be less than 3 characters");
                } else if (!Character.isUpperCase(ch)) {
                    JOptionPane.showMessageDialog(null, "First letter of the name should be capital");
                } else if (!matcher1.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid name");
                }
            } else if (p_name.getText().length()<2 || !Character.isUpperCase(ch1)|| !matcher3.matches()) {
                if(p_name.getText().length()<2) {
                    JOptionPane.showMessageDialog(null, "Parent's name can't be less than 3 characters");
                } else if (!Character.isUpperCase(ch1)) {
                    JOptionPane.showMessageDialog(null, "First letter of the name should be capital");
                }else if (!matcher3.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid Parent's name");
                }
            } else if (s_email.getText().length()<10||!matcher.matches()) {
                JOptionPane.showMessageDialog(null,"Invalid Email");
            } else if (s_num.getText().length()>10 || s_num.getText().length()<10 || !s_num.getText().matches("^[6-9]\\d{9}$")) {
                JOptionPane.showMessageDialog(null,"Mobile No. is Invalid");
            } else if (val_box.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null,"Please select state");
            } else if (s_grade.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please select grade");
            } else if (ss_name.getText().isEmpty() || !matcher4.matches()|| !Character.isUpperCase(ch2)) {
                if (ss_name.getText().isEmpty() || !matcher4.matches() || ss_name.getText().length()<3) {
                    JOptionPane.showMessageDialog(null, "Invalid School Name");
                } else if (!Character.isUpperCase(ch2)) {
                    JOptionPane.showMessageDialog(null, "First letter of the School name should be capital");
                }
            } else if (s_address.getText().isEmpty()||s_address.getText().equals("Student's Address")||!matcher2.matches()) {
                JOptionPane.showMessageDialog(null,"Invalid Address");
            } else {
                String[] options = {"Yes", "Cancel"};
                int choice = JOptionPane.showOptionDialog(
                        null,
                        "<html>A small fee of Rs.99 will charged for the enquiry.<br>After your payment gets confirmed, the tutor<br>will surely contact you. If he/she wouldn't contact you,<br>please visit our Contact-Us page and share your query<br>with us along with reference of your Booking ID.<br><br>Do you want to proceed to payment page?</html>",  // Message
                        "Message",       // Title
                        JOptionPane.YES_NO_OPTION,// Option type
                        JOptionPane.QUESTION_MESSAGE,  // Message type
                        null,                       // Icon (null for default)
                        options,                    // Custom button labels
                        options[1]);// Default button (Yes)
                if (choice == JOptionPane.YES_NO_OPTION) {
                    setVisible(false);
                    new payment(passing,book_id,s_name.getText(),p_name.getText(),s_num.getText(),s_email.getText(),(String)s_grade.getSelectedItem(),ss_name.getText(),s_address.getText(),(String) val_box.getSelectedItem(),id).setVisible(true);
                }
            }
        } else if (ae.getSource() == back) {
            String[] options = {"Yes", "No"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Do you want to cancel the booking?",  // Message
                    "Message",       // Title
                    JOptionPane.YES_NO_OPTION,// Option type
                    JOptionPane.QUESTION_MESSAGE,  // Message type
                    null,                       // Icon (null for default)
                    options,                    // Custom button labels
                    options[1]);// Default button (Yes)
            if(choice == JOptionPane.YES_NO_OPTION){
                setVisible(false);
                new tutor_data(passing,grading,subjecting).setVisible(true);
            }
        }
    }
    public static void main(String[] args) {
        new booking("","","","");
    }
}