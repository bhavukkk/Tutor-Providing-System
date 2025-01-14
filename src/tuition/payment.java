package tuition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class payment extends JFrame implements ActionListener{
    JTextField card_num,upi;
    JPasswordField cvv;
    String passing,book_id,s_name,p_name,mob,s_email,s_grade,sc_name,s_address,s_state,t_id;
    JCheckBox terms;
    JButton submit;
    payment(String username,String b_id,String name,String pa_name,String mob_no,String st_email,String st_grade,String sc_name,String st_address,String st_state,String t_id){
        this.passing = username;
        this.book_id = b_id;
        this.s_name = name;
        this.p_name = pa_name;
        this.mob = mob_no;
        this.s_email = st_email;
        this.s_grade = st_grade;
        this.sc_name = sc_name;
        this.s_address = st_address;
        this.s_state = st_state;
        this.t_id = t_id;

        setTitle("Payment Form");
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg4.jpg"));
        Image i1 = i.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,700,700);
        add(i3);

        JLabel head = new JLabel("Enter your payment details: ");
        head.setForeground(Color.black);
        head.setFont(new Font("Arial",Font.BOLD,18));
        head.setBounds(220,70,250,50);
        i3.add(head);

        JLabel one = new JLabel("<html>Credit/Debit<br>&nbsp;&nbsp;&nbsp;&nbsp;Card NO.:</html>");
        one.setFont(new Font("Arial",Font.BOLD,14));
        one.setBounds(150,140,250,50);
        i3.add(one);

        card_num = new JTextField(20);
        card_num.setForeground(Color.gray);
        card_num.setBounds(250,150,270,30);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,700));
        i3.add(panel);
        i3.add(card_num);

        JLabel sec = new JLabel("CVV:");
        sec.setFont(new Font("Arial",Font.BOLD,15));
        sec.setBounds(160,180,250,50);
        i3.add(sec);

        cvv = new JPasswordField(20);
        cvv.setForeground(Color.gray);
        cvv.setBounds(250,190,270,30);
        i3.add(cvv);

        JLabel or = new JLabel("OR");
        or.setForeground(Color.black);
        or.setFont(new Font("Arial",Font.BOLD,18));
        or.setBounds(320,220,100,50);
        i3.add(or);

        JLabel third = new JLabel("UPI ID:");
        third.setFont(new Font("Arial",Font.BOLD,15));
        third.setBounds(160,260,250,50);
        i3.add(third);

        upi = new JTextField(25);
        upi.setForeground(Color.gray);
        upi.setBounds(250,270,270,30);
        i3.add(upi);

        terms = new JCheckBox();
        terms.setSelected(false);
        terms.setBounds(230,330,20,20);
        JLabel terms1 = new JLabel("<html><u>I agree to Terms & Conditions</u></html>");
        terms1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        terms1.setForeground(Color.black);
        terms1.setFont(new Font("Times New Roman",Font.BOLD,15));
        terms1.setBounds(260,315,300,50);
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
        submit.setBounds(290,435,100,30);
        submit.setFocusPainted(false);
        float hue = 0.05f;        // Hue for brown (between 0 and 1)
        float saturation = 0.65f; // Saturation level (between 0 and 1)
        float brightness = 0.55f; // Brightness level (between 0 and 1)
        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
        submit.setBackground(new Color(rgb));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        i3.add(submit);

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
        if(ae.getSource() == submit){
            if(!terms.isSelected()){
                JOptionPane.showMessageDialog(null,"Please Agree to Terms & Conditions");
            } else if (card_num.getText().isEmpty() && upi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please select any one method: Card or UPI");
            }else if (!card_num.getText().isEmpty() && !upi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please select any one method: Card or UPI");
            } else if (!card_num.getText().isEmpty()) {
                if (card_num.getText().length() != 16) {
                    JOptionPane.showMessageDialog(null, "Invalid Card NO. It should be 16 digits.");
                } else if (cvv.getText().length() != 3 || cvv.getText().equals("CVV")) {
                    JOptionPane.showMessageDialog(null, "Invalid CVV. It should be 3 digits.");
                }else {
                    setVisible(false);
                    new payment2(passing,book_id,s_name,p_name,mob,s_email,s_grade,sc_name,s_address,s_state,t_id,card_num.getText(),cvv.getText(),"No").setVisible(true);
                }
            } else if (!upi.getText().isEmpty()) {
                if (upi.getText().length() > 17 || upi.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid UPI ID");
                }else {
                    setVisible(false);
                    new payment2(passing,book_id,s_name,p_name,mob,s_email,s_grade,sc_name,s_address,s_state,t_id,"No","No",upi.getText()).setVisible(true);
                }
            }
        }
    }
    public static void main(String[] args) {
        new payment("","","","","","","","","","","");
    }
}