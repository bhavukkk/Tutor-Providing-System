package tuition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;

public class home_page extends JFrame implements ActionListener {
    String passing;
    int flag = 0;
    String t_id;
    JButton aboutus,subjects,login_register,contact,booking,home,book2;
    JMenuItem item1,item2,item6,item7,item8,item9,item10,item11com,item11sc,item12com,item12sc;
    home_page(String username){
        String query = "select * from tutors where name = '" + username +"'";
        conn c = new conn();
        try {
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                flag = 1;
                t_id = rs.getString("tutor_id");
            }
        }catch (SQLException se){
            System.out.println(se);
        }
        this.passing = username;
        setTitle("Home Page");
        setLayout(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg4.jpg"));
        Image i1 = i.getImage().getScaledInstance(1100,750,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,1100,750);
        add(i3);

        float hue1 = 0.13f;        // Hue for gold (between 0 and 1)
        float saturation1 = 0.75f; // Saturation level (between 0 and 1)
        float brightness1 = 0.85f; // Brightness level (between 0 and 1)
        int rgb1 = Color.HSBtoRGB(hue1, saturation1, brightness1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/education.png"));
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel i7 = new JLabel(i6);
        i7.setBounds(40,20,50,50);
        i3.add(i7);

        JLabel header = new JLabel("TUTE IT UP!");
        header.setFont(new Font("Arial Black",Font.BOLD,25));
        header.setBounds(110,20,200,50);
        header.setForeground(new Color(rgb1));
        i3.add(header);

        JLabel line = new JLabel("__________________________________________________________________________________________________________________________________________________________________________________________________________");
        line.setBounds(0,83,1100,15);
        line.setForeground(Color.black);
        i3.add(line);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.jpg"));
        Image a2 = a1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel a4 = new JLabel(a3);
        if(passing.equals("User")||passing.equals("")){
            a4.setBounds(780,20,100,30);
        }else {
            a4.setBounds(900, 17, 40, 40);
        }
        i3.add(a4);
        if(flag == 1 || flag == 0) {
            if(flag == 1){
            JPopupMenu menu1 = new JPopupMenu();
            item1 = new JMenuItem("Tutor ID: " + t_id);
            item2 = new JMenuItem("Log Out");
            menu1.add(item1);
            menu1.add(item2);
            item2.addActionListener(this);
            a4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    menu1.show(a4,0, booking.getHeight());
                }
            });
            } else if (flag == 0) {
                JPopupMenu menu1 = new JPopupMenu();
                item2 = new JMenuItem("Log Out");
//                menu1.add(item1);
                menu1.add(item2);
                item2.addActionListener(this);
                a4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menu1.show(a4,0, booking.getHeight());
                    }
                });
            }
        }

        JLabel use = new JLabel("Hi, " + username.split(" ")[0]);
        if(passing.equals("User")||passing.equals("")){
            use.setBounds(850,20,100,30);
        }else {
            use.setBounds(950, 20, 100, 30);
        }
        use.setForeground(Color.white);
        use.setFont(new Font("Times new roman",Font.BOLD,15));
        i3.add(use);

        login_register = new JButton("Login/Register");
        login_register.setBounds(950,22,130,30);
        login_register.setFocusPainted(false);
        login_register.setFont(new Font("Calibri",Font.PLAIN,15));
        login_register.setBackground(Color.BLACK);
        login_register.setForeground(Color.WHITE);
        login_register.addActionListener(this);
        if (passing.equals("User")||passing.equals("")) {
            i3.add(login_register);
        }

        contact = new JButton("Contact-Us");
        contact.setBounds(965,67,120,30);
        contact.setFocusPainted(false);
        contact.setFont(new Font("Calibri",Font.PLAIN,15));
        contact.setBackground(Color.BLACK);
        contact.setForeground(Color.WHITE);
        contact.addActionListener(this);
        i3.add(contact);

        subjects = new JButton("Subjects");
        subjects.setBounds(865,67,100,30);
        subjects.setFocusPainted(false);
        subjects.setFont(new Font("Calibri",Font.PLAIN,15));
        subjects.setBackground(Color.BLACK);
        subjects.setForeground(Color.WHITE);
        subjects.addActionListener(this);
        if(flag == 0) {
            i3.add(subjects);
        }

        booking = new JButton("Need A Tutor");
        booking.setBounds(745,67,120,30);
        booking.setFocusPainted(false);
        booking.setFont(new Font("Calibri",Font.PLAIN,15));
        booking.setBackground(Color.BLACK);
        booking.setForeground(Color.WHITE);
        if(flag == 0) {
            i3.add(booking);
        }

        JPopupMenu menu = new JPopupMenu();
        item6 = new JMenuItem("Grade 6th");
        item7 = new JMenuItem("Grade 7th");
        item8 = new JMenuItem("Grade 8th");
        item9 = new JMenuItem("Grade 9th");
        item10 = new JMenuItem("Grade 10th");
        item11com = new JMenuItem("Grade 11th Commerce");
        item11sc = new JMenuItem("Grade 11th Science");
        item12com = new JMenuItem("Grade 12th Commerce");
        item12sc = new JMenuItem("Grade 12th Science");

        item6.addActionListener(this);
        item7.addActionListener(this);
        item8.addActionListener(this);
        item9.addActionListener(this);
        item10.addActionListener(this);
        item11com.addActionListener(this);
        item11sc.addActionListener(this);
        item12com.addActionListener(this);
        item12sc.addActionListener(this);

        menu.add(item6);
        menu.add(item7);
        menu.add(item8);
        menu.add(item9);
        menu.add(item10);
        menu.add(item11com);
        menu.add(item11sc);
        menu.add(item12com);
        menu.add(item12sc);

        booking.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menu.show(booking,0, booking.getHeight());
            }
        });

        aboutus = new JButton("About Us");
        if(flag == 1){
            aboutus.setBounds(865,67,100,30);
        }else{
            aboutus.setBounds(645,67,100,30);
        }
        aboutus.setFocusPainted(false);
        aboutus.setFont(new Font("Calibri",Font.PLAIN,15));
        aboutus.setBackground(Color.BLACK);
        aboutus.setForeground(Color.WHITE);
        aboutus.addActionListener(this);
        i3.add(aboutus);

        home = new JButton("Home");
        if(flag == 1){
            home.setBounds(765,67,100,30);
        }else{
            home.setBounds(545,67,100,30);
        }
        home.setFocusPainted(false);
        home.setFont(new Font("Calibri",Font.PLAIN,15));
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);
        home.addActionListener(this);
        i3.add(home);

        JLabel dream = new JLabel("<html>"+"&nbsp;&nbsp;&nbsp;"+"GET YOUR<br>DREAM TUTOR</html>");
        dream.setBounds(80,170,400,200);
        dream.setFont(new Font("Arial Black",Font.BOLD,35));
        dream.setVerticalAlignment(SwingConstants.CENTER);
        dream.setHorizontalAlignment(SwingConstants.CENTER);
        dream.setForeground(new Color(rgb1));
        i3.add(dream);

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("icons/arrow.png"));
        Image i9 = i8.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel i11 = new JLabel(i10);
        i11.setBounds(255,335,40,40);
        i3.add(i11);

        book2 = new JButton("BOOK");
        book2.setBounds(203,395,150,40);
        book2.setFocusPainted(false);
        book2.setFont(new Font("Arial Black",Font.PLAIN,20));
        float hue = 0.05f;        // Hue for brown (between 0 and 1)
        float saturation = 0.65f; // Saturation level (between 0 and 1)
        float brightness = 0.55f; // Brightness level (between 0 and 1)
        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
        book2.setBackground(new Color(rgb));
        book2.setForeground(Color.black);
        book2.addActionListener(this);
        if(flag == 1) {
            book2.setEnabled(false);
        }
        i3.add(book2);

        JLabel lower = new JLabel("<html>The best teachers are<br>those who show you<br>where to look but don't tell<br>what to see<br><br><br>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+"- Alexandra K.Trenfor</html>");
        lower.setVerticalAlignment(SwingConstants.CENTER);
        lower.setHorizontalAlignment(SwingConstants.CENTER);
        lower.setBackground(Color.white);
        lower.setFont(new Font("MV Boli",Font.PLAIN,15));
        lower.setOpaque(true);
        lower.setBounds(686,220,230,280);
        i3.add(lower);

        JLabel upper = new JLabel();
        upper.setBackground(new Color(rgb1));
        upper.setOpaque(true);
        upper.setBounds(650,185,300,350);
        i3.add(upper);

        setSize(1100,750);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login_register){
            setVisible(false);
            new login().setVisible(true);
        } else if (ae.getSource() == home) {
            setVisible(false);
            new home_page(passing).setVisible(true);
        }else if (ae.getSource() == aboutus){
            setVisible(false);
            new aboutus(passing).setVisible(true);
        } else if (ae.getSource() == contact) {
            setVisible(false);
            new contact_us(passing).setVisible(true);
        }else if (ae.getSource() == subjects){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing, "").setVisible(true);
            }
        } else if (ae.getSource() == item2) {
            setVisible(false);
            new home_page("User");

        } else if (ae.getSource() == item6){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing, "6-8th").setVisible(true);
            }
        }else if (ae.getSource() == item7){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
            setVisible(false);
            new subjects(passing,"6-8th").setVisible(true);
            }
        }else if (ae.getSource() == item8){
            if (passing.equals("User")|| passing.equals("")){
                JOptionPane.showMessageDialog(null,"You need to login/register first!");
            }else {
            setVisible(false);
            new subjects(passing,"6-8th").setVisible(true);
            }
        }else if (ae.getSource() == item9){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing, "9-10th").setVisible(true);
            }
        }else if (ae.getSource() == item10){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
            setVisible(false);
            new subjects(passing,"9-10th").setVisible(true);
            }
        }else if (ae.getSource() == item11com){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing, "11-12th").setVisible(true);
            }
        }else if (ae.getSource() == item11sc){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing, "11-12th").setVisible(true);
            }
        } else if (ae.getSource() == item12com){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing, "11-12th").setVisible(true);
            }
        }else if (ae.getSource() == item12sc){
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing, "11-12th").setVisible(true);
            }
        } else if (ae.getSource() == book2) {
            if (passing.equals("User")|| passing.equals("")) {
                JOptionPane.showMessageDialog(null, "You need to login/register first!");
            }else {
                setVisible(false);
                new subjects(passing,"").setVisible(true);

            }
        }
    }
    public static void main(String[] args) {
        new home_page("User");
    }
}

