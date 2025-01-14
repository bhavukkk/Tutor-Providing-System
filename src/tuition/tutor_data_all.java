package tuition;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class tutor_data_all extends JFrame implements ActionListener {
    JButton first,back;
    String passing;
    String grading;
    String subjecting;
    ResultSet rs;

    tutor_data_all(String username){
        this.passing = username;
        setTitle("Available Tutors");
        setSize(400, 400);

        float hue1 = 0.13f;        // Hue for gold (between 0 and 1)
        float saturation1 = 0.75f; // Saturation level (between 0 and 1)
        float brightness1 = 0.85f; // Brightness level (between 0 and 1)
        int rgb1 = Color.HSBtoRGB(hue1, saturation1, brightness1);

        float hue = 0.06f;        // Hue for brown (between 0 and 1)
        float saturation = 0.65f; // Saturation level (between 0 and 1)
        float brightness = 0.65f; // Brightness level (between 0 and 1)
        int rgb = Color.HSBtoRGB(hue, saturation, brightness);

        // Create the main panel that will hold all the tutor information
        JPanel tutorPanel = new JPanel();
        tutorPanel.setLayout(new BoxLayout(tutorPanel, BoxLayout.Y_AXIS)); // Use vertical layout

        conn c = new conn();

        try {
                String query = "SELECT tutor_id,name,grade,experience,degree FROM tutors";
                rs = c.s.executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("tutor_id");
                String t_name = rs.getString("name");
                String t_grade = rs.getString("grade");
                String exp = rs.getString("experience");
                String deg = rs.getString("degree");

                ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));
                Image a2 = a1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
                ImageIcon a3 = new ImageIcon(a2);
                JLabel a4 = new JLabel(a3);
                a4.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

                JLabel t_label = new JLabel("<html><b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Tutor_ID:" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + id + "</b><br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Name:" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + t_name + "<br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Grade:" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + t_grade + "<br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Experience:" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + exp + "<br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Degree:"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + deg + "<br>" );
                t_label.setFont(new Font("Arial",Font.PLAIN,16));

                JButton bookButton = new JButton("<html>Book<br>This<br>Tutor</html>");
                bookButton.setFont(new Font("arial",Font.BOLD,14));
                bookButton.setFocusPainted(false);
                bookButton.setBackground(new Color(rgb));
//                bookButton.addActionListener(e -> booking(id));

                // Create a panel for each tutor's info
                JPanel individualTutorPanel = new JPanel(new BorderLayout());
                Border outline = BorderFactory.createLineBorder(Color.BLACK, 2); // 2px thick black border
                individualTutorPanel.setBorder(outline);
                individualTutorPanel.setBackground(new Color(rgb1));
                individualTutorPanel.setOpaque(true);

                JPanel tutorInfoPanel = new JPanel(new GridLayout(1, 1,0,0));// Two rows: name and description
                tutorInfoPanel.setBackground(new Color(rgb1));
                tutorInfoPanel.setOpaque(true);
                tutorInfoPanel.add(t_label);

                JPanel profileAndInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));// Align profile to left
                profileAndInfoPanel.setBackground(new Color(rgb1));
                profileAndInfoPanel.setOpaque(true);
                profileAndInfoPanel.add(a4); // Add profile icon
                profileAndInfoPanel.add(tutorInfoPanel);

                individualTutorPanel.add(profileAndInfoPanel, BorderLayout.CENTER);
                individualTutorPanel.add(bookButton, BorderLayout.EAST);

                // Add tutor panel to the main panel
                tutorPanel.add(individualTutorPanel);
                tutorPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Add spacing between tutors
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Wrap the main panel inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(tutorPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        back = new JButton("BACK");
        back.setFocusPainted(false);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);

        JPanel upper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        upper.add(back);
        // Add the JScrollPane to the frame
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(scrollPane, BorderLayout.CENTER); // Scrollable tutor data in the center
        contentPanel.add(upper, BorderLayout.PAGE_END);

        add(contentPanel);

        setSize(900,800);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back){
            setVisible(false);
            new home_page(passing).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new tutor_data_all("");
    }
}
