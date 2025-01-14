package tuition;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subjects extends JFrame implements ActionListener {
    JButton maths, science, social, computers, english, hindi, back;
    String passing;
    String grading;

    subjects(String username,String grade){
        this.grading = grade;
        this.passing = username;
        setTitle("Subjects");
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg4.jpg"));
        Image i1 = i.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,900,800);
        add(i3);

        JLabel head = new JLabel("SUBJECTS");
        head.setForeground(Color.black);
        head.setFont(new Font("Arial black",Font.BOLD,20));
        head.setBounds(385,80,250,50);
        i3.add(head);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/maths.png"));
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel i7 = new JLabel(i6);
        i7.setBounds(305,180,50,50);
        i3.add(i7);

        maths = new JButton("Mathematics");
        maths.setBounds(253, 250, 150, 40);
        maths.setFocusPainted(false);
        maths.setFont(new Font("Arial",Font.BOLD,15));
        maths.setBackground(Color.black);
        maths.setForeground(Color.white);
        maths.addActionListener(this);
        i3.add(maths);

        JLabel line = new JLabel("____________________________________________________________________________________________________________________________");
        line.setBounds(216,290,450,15);
        line.setForeground(Color.black);
        i3.add(line);

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("icons/science.png"));
        Image i9 = i8.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i10= new ImageIcon(i9);
        JLabel i11 = new JLabel(i10);
        i11.setBounds(300,310,60,60);
        i3.add(i11);

        science = new JButton("Science");
        science.setBounds(253, 380, 150, 40);
        science.setFocusPainted(false);
        science.setFont(new Font("Arial",Font.BOLD,15));
        science.setBackground(Color.black);
        science.setForeground(Color.white);
        science.addActionListener(this);
        i3.add(science);

        JLabel line2 = new JLabel("____________________________________________________________________________________________________________________________");
        line2.setBounds(216,420,450,15);
        line2.setForeground(Color.black);
        i3.add(line2);

        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("icons/sst.png"));
        Image b2 = b1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon b3= new ImageIcon(b2);
        JLabel b4 = new JLabel(b3);
        b4.setBounds(300,445,50,50);
        i3.add(b4);

        social = new JButton("Social Studies");
        social.setBounds(253, 500, 150, 40);
        if(grading.equals("11-12th")){
            social.setEnabled(false);
        }
        social.setFocusPainted(false);
        social.setFont(new Font("Arial",Font.BOLD,15));
        social.setBackground(Color.black);
        social.setForeground(Color.white);
        social.addActionListener(this);
        i3.add(social);

        ImageIcon b5 = new ImageIcon(ClassLoader.getSystemResource("icons/eng.png"));
        Image b6 = b5.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon b7 = new ImageIcon(b6);
        JLabel b8 = new JLabel(b7);
        b8.setBounds(515,180,70,70);
        i3.add(b8);

        english = new JButton("English");
        english.setBounds(477, 250, 150, 40);
        english.setFocusPainted(false);
        english.setFont(new Font("Arial",Font.BOLD,15));
        english.setBackground(Color.black);
        english.setForeground(Color.white);
        english.addActionListener(this);
        i3.add(english);

        ImageIcon b9 = new ImageIcon(ClassLoader.getSystemResource("icons/hindi.png"));
        Image b10 = b9.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon b11 = new ImageIcon(b10);
        JLabel b12 = new JLabel(b11);
        b12.setBounds(520,310,60,60);
        i3.add(b12);

        hindi = new JButton("Hindi");
        hindi.setBounds(477, 380, 150, 40);
        if(grading.equals("11-12th")){
            hindi.setEnabled(false);
        }
        hindi.setFocusPainted(false);
        hindi.setFont(new Font("Arial",Font.BOLD,15));
        hindi.setBackground(Color.black);
        hindi.setForeground(Color.white);
        hindi.addActionListener(this);
        i3.add(hindi);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/com.png"));
        Image a2 = a1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon a3= new ImageIcon(a2);
        JLabel a4 = new JLabel(a3);
        a4.setBounds(515,435,60,60);
        i3.add(a4);

        computers = new JButton("Computers/IT");
        computers.setBounds(477, 500, 150, 40);
        if(grading.equals("11-12th")){
            computers.setEnabled(false);
        }
        computers.setFocusPainted(false);
        computers.setFont(new Font("Arial",Font.BOLD,15));
        computers.setBackground(Color.black);
        computers.setForeground(Color.white);
        computers.addActionListener(this);
        i3.add(computers);

        back = new JButton("BACK");
        back.setBounds(570, 620, 75, 30);
        back.setFocusPainted(false);
        back.setFont(new Font("Arial",Font.BOLD,13));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        i3.add(back);

        JLabel lower = new JLabel();
        lower.setBackground(Color.orange);
        lower.setOpaque(true);
        lower.setBounds(215,150,225,400);
        float hue2 = 0.75f;         // Purple hue
        float saturation2 = 1.0f;   // Fully saturated
        float brightness2 = 0.6f;   // Dark brightness
        int rgb2 = Color.HSBtoRGB(hue2, saturation2, brightness2);
        lower.setBorder(new LineBorder(new Color(rgb2),2));
        i3.add(lower);
        JLabel lower1 = new JLabel();
        lower1.setBackground(Color.orange);
        lower1.setOpaque(true);
        lower1.setBounds(440,150,225,400);
        lower1.setBorder(new LineBorder(new Color(rgb2),2));
        i3.add(lower1);

        JLabel upper = new JLabel();
        upper.setBackground(Color.orange);
        upper.setOpaque(true);
        upper.setBounds(215,70,450,600);
        upper.setBorder(new LineBorder(new Color(rgb2),2));
        i3.add(upper);


        setLocation(310,0);
        setSize(900,800);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new home_page(passing).setVisible(true);
        } else if (ae.getSource() == maths) {
            setVisible(false);
            new tutor_data(passing,grading,"Mathematics").setVisible(true);
        }else if (ae.getSource() == science) {
            setVisible(false);
            new tutor_data(passing,grading,"Science").setVisible(true);
        }else if (ae.getSource() == social) {
            setVisible(false);
            new tutor_data(passing,grading,"Social Studies").setVisible(true);
        }else if (ae.getSource() == english) {
            setVisible(false);
            new tutor_data(passing,grading,"English").setVisible(true);
        }else if (ae.getSource() == hindi) {
            setVisible(false);
            new tutor_data(passing,grading,"Hindi").setVisible(true);
        }else if (ae.getSource() == computers) {
            setVisible(false);
            new tutor_data(passing,grading,"Computers/IT").setVisible(true);
        }
    }

    public static void main(String[] args) {
        new subjects("","");
    }
}
