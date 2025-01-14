package tuition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.filechooser.FileNameExtensionFilter;

public class register_tutor extends JFrame implements ActionListener {
    long random;
    String book_id;
    String passing;
    JButton submit,back,browse;
    JPasswordField p_password;
    JCheckBox terms;
    File selectedFile;
    String tutor_id;
    JTextField t_name,t_age,t_deg,t_num,t_email,t_adhar,t_resume;
    JComboBox val_box,s_exp,t_grade,t_mode;
    String id,grading,subjecting;
    register_tutor(){
        random = (int)(Math.random() * 90000) + 10000;
        tutor_id = Long.toString(random);
        setTitle("Booking Form");

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg4.jpg"));
        Image i1 = i.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,900,800);
        add(i3);

        JLabel head = new JLabel("Register as a Tutor: ");
        head.setForeground(Color.black);
        head.setFont(new Font("Arial",Font.BOLD,18));
        head.setBounds(200,70,250,50);
        i3.add(head);

        JLabel one  = new JLabel("Name:");
        one.setFont(new Font("Arial",Font.BOLD,15));
        one.setForeground(Color.black);
        one.setBounds(250,130,100,30);
        i3.add(one);

        t_name = new JTextField(20);
        t_name.setForeground(Color.black);
        t_name.setBounds(350,130,270,30);
        i3.add(t_name);

        JLabel two  = new JLabel("Age:");
        two.setFont(new Font("Arial",Font.BOLD,15));
        two.setForeground(Color.black);
        two.setBounds(250,170,100,30);
        i3.add(two);

        t_age = new JTextField(20);
        t_age.setForeground(Color.black);
        t_age.setBounds(350,170,270,30);
        i3.add(t_age);

        JLabel three = new JLabel("Experience:");
        three.setFont(new Font("Arial",Font.BOLD,15));
        three.setForeground(Color.black);
        three.setBounds(250,210,100,30);
        i3.add(three);

        String val_exp[] = {"Fresher","1 year","2 years","3 years","4 years","5 years","6 years","7 years","8 years","More than 8 years"};
        s_exp = new JComboBox<>(val_exp);
        s_exp.setForeground(Color.black);
        s_exp.setBounds(350,210,270,30);
        i3.add(s_exp);

        JLabel four = new JLabel("<html>Education/<br>&nbsp;&nbsp;Degree:");
        four.setFont(new Font("Arial",Font.BOLD,14));
        four.setForeground(Color.black);
        four.setBounds(250,250,100,33);
        i3.add(four);

        t_deg = new JTextField("(Mention your degree along with subject)",25);
        t_deg.setForeground(Color.gray);
        t_deg.setBounds(350,250,270,30);
        t_deg.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t_deg.getText().equals("(Mention your degree along with subject)")){
                    t_deg.setText("");
                    t_deg.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t_deg.getText().isEmpty()) {
                    t_deg.setText("(Mention your degree along with subject)");
                    t_deg.setForeground(Color.GRAY);
                }
            }
        });
        i3.add(t_deg);

        JLabel five = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grade:<br>(You will teach)");
        five.setFont(new Font("Arial",Font.BOLD,14));
        five.setForeground(Color.black);
        five.setBounds(230,290,120,35);
        i3.add(five);

        String val_grade[] = {"6-8th","9-10th","11-12th"};
        t_grade = new JComboBox<>(val_grade);
        t_grade.setForeground(Color.black);
        t_grade.setBounds(350,290,270,30);
        i3.add(t_grade);

        JLabel six = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Subject:<br>(You will teach)");
        six.setFont(new Font("Arial",Font.BOLD,14));
        six.setForeground(Color.black);
        six.setBounds(230,330,120,35);
        i3.add(six);

        String val_subject[] = {"Mathematics","Science","Social Studies","English","Hindi","Computers/IT"};
        val_box = new JComboBox<>(val_subject);
        val_box.setBounds(350,330,270,30);
        val_box.setBackground(Color.WHITE);
        i3.add(val_box);

        JLabel sev = new JLabel("Preferred Mode:");
        sev.setFont(new Font("Arial",Font.BOLD,14));
        sev.setForeground(Color.black);
        sev.setBounds(230,370,120,35);
        i3.add(sev);

        String mode[] = {"Offline","Online"};
        t_mode = new JComboBox<>(mode);
        t_mode.setForeground(Color.black);
        t_mode.setBounds(350,370,270,30);
        i3.add(t_mode);

        JLabel eight = new JLabel("Contact No:");
        eight.setFont(new Font("Arial",Font.BOLD,15));
        eight.setForeground(Color.black);
        eight.setBounds(250,410,120,35);
        i3.add(eight);

        t_num = new JTextField(20);
        t_num.setForeground(Color.black);
        t_num.setBounds(350,410,270,30);
        i3.add(t_num);

        JLabel nine = new JLabel("Email:");
        nine.setFont(new Font("Arial",Font.BOLD,15));
        nine.setForeground(Color.black);
        nine.setBounds(250,450,120,35);
        i3.add(nine);

        t_email = new JTextField(30);
        t_email.setForeground(Color.black);
        t_email.setBounds(350,450,270,30);
        i3.add(t_email);

        JLabel ten = new JLabel("Adhaar No:");
        ten.setFont(new Font("Arial",Font.BOLD,15));
        ten.setForeground(Color.black);
        ten.setBounds(250,490,120,35);
        i3.add(ten);

        t_adhar = new JTextField(30);
        t_adhar.setForeground(Color.black);
        t_adhar.setBounds(350,490,270,30);
        i3.add(t_adhar);

        JLabel ele = new JLabel("Resume:");
        ele.setFont(new Font("Arial",Font.BOLD,15));
        ele.setForeground(Color.black);
        ele.setBounds(250,530,120,35);
        i3.add(ele);

        t_resume = new JTextField();
        t_resume.setEditable(false);
        t_resume.setForeground(Color.black);
        t_resume.setBounds(350,530,270,30);
        i3.add(t_resume);

        browse = new JButton("Browse");
        browse.setBounds(630,534,100,25);
        browse.setForeground(Color.black);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("PDF and Image Files", "pdf", "jpg", "jpeg", "png"));
                int result = fileChooser.showOpenDialog(register_tutor.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    t_resume.setText(selectedFile.getAbsolutePath());
                    // You can now use selectedFile to save to the database
                }
            }
        });
        i3.add(browse);

        JLabel twe = new JLabel("Password");
        twe.setFont(new Font("Arial",Font.BOLD,15));
        twe.setForeground(Color.black);
        twe.setBounds(250,570,120,35);
        i3.add(twe);

        p_password = new JPasswordField(20);
        p_password.setForeground(Color.gray);
        p_password.setBounds(350,570,270,30);
        i3.add(p_password);

        terms = new JCheckBox();
        terms.setSelected(false);
        terms.setBounds(323,614,20,20);
        JLabel terms1 = new JLabel("<html><u>I agree to Terms & Conditions</u></html>");
        terms1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        terms1.setForeground(Color.black);
        terms1.setFont(new Font("Times New Roman",Font.BOLD,15));
        terms1.setBounds(353,599,300,50);
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
        submit.setBounds(205,650,100,30);
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
        back.setBounds(570,650,100,30);
        back.setFocusPainted(false);
        back.setBackground(new Color(rgb));
        back.setForeground(Color.black);
        back.addActionListener(this);
        i3.add(back);

        JLabel upper = new JLabel();
        upper.setBackground(Color.orange);
        upper.setOpaque(true);
        upper.setBounds(90,60,700,650);
        i3.add(upper);

        setSize(900,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            String nameRegex = "^[A-Za-z\\s'-]+$";
            Pattern pattern = Pattern.compile(emailRegex);
            Pattern pattern1 = Pattern.compile(nameRegex);
            Matcher matcher = pattern.matcher(t_email.getText());
            Matcher matcher1 = pattern1.matcher(t_name.getText());
            String degreeRegex = "^[A-Za-z.\\s]+$";
            Pattern pattern2 = Pattern.compile(degreeRegex);
            Matcher matcher2 = pattern2.matcher(t_deg.getText());

            if (!terms.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Agree to Terms & Conditions");
            } else if (t_name.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid Name");
            } else if (t_name.getText().length() < 2) {
                JOptionPane.showMessageDialog(null, "Name can't be less than 3 characters");
            } else if (!Character.isUpperCase(t_name.getText().charAt(0))) {
                JOptionPane.showMessageDialog(null, "First letter of the name should be capital");
            } else if (!matcher1.matches()) {
                JOptionPane.showMessageDialog(null, "Invalid name");
            } else if (t_age.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid Age");
            } else if (!t_age.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Invalid Age");
            } else if (Integer.parseInt(t_age.getText()) < 21) {
                JOptionPane.showMessageDialog(null, "Age can't be less than 21");
            } else if (t_deg.getText().isEmpty() || !matcher2.matches()) {
                JOptionPane.showMessageDialog(null, "Invalid Education");
            } else if (t_num.getText().isEmpty() || t_num.getText().length() != 10 || !t_num.getText().matches("^[6-9]\\d{9}$")) {
                JOptionPane.showMessageDialog(null, "Please fill your Contact no");
            } else if (t_email.getText().isEmpty() || t_email.getText().length() < 10 || !matcher.matches()) {
                JOptionPane.showMessageDialog(null, "Invalid email");
            } else if (t_adhar.getText().isEmpty() || t_adhar.getText().length() != 12 || !t_adhar.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhar No.");
            } else if (t_resume.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please upload your resume");
            } else if (selectedFile == null) {
                JOptionPane.showMessageDialog(null,"Please upload your resume");
            } else if (p_password.getText().isEmpty() || p_password.getText().length() < 8) {
                JOptionPane.showMessageDialog(null, "Password can't be less than 8 characters");
            } else {
                conn c1 = new conn();
                saveFileToDatabase(selectedFile);
                String query1 = "insert into login_tutor values('" + tutor_id + "','" +t_email.getText()+ "','" +p_password.getText()+"')";
                try {
                    c1.s.executeUpdate(query1);
                }catch (SQLException se){
                    System.out.println(se);
                }
                JOptionPane.showMessageDialog(null,"<html>Congralutaions, You're Successfully registered with us as a Tutor.<br>You will start getting bookings from students in few days.<br><br>Your Tutor ID: "+ tutor_id);
                setVisible(false);
                new home_page(t_name.getText()).setVisible(true);
            }
        } else if (ae.getSource() == back) {
                setVisible(false);
                new login().setVisible(true);
        }
    }
    private void saveFileToDatabase(File file){
        conn c = null;
        PreparedStatement pstmt = null;
        try {
            c = new conn();
            String sql = "INSERT INTO tutors (tutor_id,name, age, grade, experience, subject, degree, mode,m_num, email, adhar_no,resume_file ) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?)";
            pstmt = c.c.prepareStatement(sql);

            pstmt.setLong(1, Long.parseLong(tutor_id));
            pstmt.setString(2, t_name.getText());
            pstmt.setString(3, t_age.getText());
            pstmt.setString(4, (String) t_grade.getSelectedItem());
            pstmt.setString(5, (String) s_exp.getSelectedItem());
            pstmt.setString(6, (String)val_box.getSelectedItem());
            pstmt.setString(7, t_deg.getText());
            pstmt.setString(8, (String)t_mode.getSelectedItem());
            pstmt.setString(9, t_num.getText());
            pstmt.setString(10, t_email.getText());
            pstmt.setString(11, t_adhar.getText());

            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(12, fis, (int) file.length());

            pstmt.executeUpdate();
            fis.close();

            JOptionPane.showMessageDialog(this, "File saved to database successfully!");
        }catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        new register_tutor();
    }
}
