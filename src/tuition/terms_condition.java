package tuition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class terms_condition extends JFrame implements ActionListener {
    JButton ok;

    terms_condition() {
        setTitle("Terms and Condition");
        setLayout(null);
        JLabel content = new JLabel("<html>For tuteitup.com and Tute It Up Pvt Ltd<br>Having Registered office at<br>2-126/2/4, Cannaught PLace, Delhi</html>");
        content.setForeground(Color.black);
        content.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        content.setBounds(30, 20, 200, 100);
        add(content);

        JLabel label2 = new JLabel("<html><br><b>Security</b><br>While we work to protect the security of your account and related information,pocketutz cannot guarantee that<br>unauthorized third parties will not be able to breach our security measures. Please notify us immediately of any<br>compromise or unauthorized use of your account, on support@tuteitup.com</html>");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label2.setBounds(30, 50, 700, 200);
        add(label2);

        JLabel label3 = new JLabel("<html><br><b>Video Recording</b><br>The video recordings of your participation in sessions may be used for the purpose of research or marketing.<br>Please refer to our Privacy policy for further details on our use of the video recordings on sessions.</html>");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label3.setBounds(30, 120, 700, 200);
        add(label3);

        JLabel label4 = new JLabel("<html><br><b>Payment of Fees</b><br>You are responsible for paying all fees charged by pockettutz and applicable taxes in a timely manner with<br>a payment mechanism, specified with the said service. If your payment method fails or your account is past due,<br>we may collect fees using other collection mechanisms. Fees may vary based on your<br>location and other factors, and we reserve the right to change any fees at any time at its sole discretion.<br>Any change, update, or modification will be effective immediately upon posting through the relevant Services.<br>Refunds may be available for paid Services as described in our Refund and Cancellation Policy.</html>");
        label4.setForeground(Color.black);
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label4.setBounds(30, 220, 700, 200);
        add(label4);

        JLabel label5 = new JLabel("<html><br><b>Modifying and terminating our services</b><br>We constantly strive to improve our services. We may add or remove certain functions,<br>features, or requirements, and we may suspend or stop part of our services altogether. If your use of a Service<br>is terminated, a refund may be available as specified in our Refund and Cancellation Policy.<br>Please note that we may not be able to deliver some or all of the Services to certain regions or countries<br>for various reasons, including due to internet access limitations and government restrictions, and tuteitup,<br>it’s Content Providers, its contributors, sponsors, and other business partners, and their employees,<br>contractors, and other agents (the “Associated Parties”) shall not be liable to you for the same.</html>");
        label5.setForeground(Color.black);
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label5.setBounds(30, 360, 700, 200);
        add(label5);

        JLabel label6 = new JLabel("<html><br><b>Revision of terms</b><br>We reserve the right to review these Terms at sole discretion at any time. Any revisions to the Terms will be<br>effectively immediately upon posting by us. For any material changes to the Terms, we will take reasonable steps<br>to notify you of such changes. In all cases, your continued use of the Services after publication<br>of such changes, with or without notification, shall constitute binding acceptance of the revised Terms.</html>");
        label6.setForeground(Color.black);
        label6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        label6.setBounds(30, 480, 700, 200);
        add(label6);

        ok = new JButton("OK");
        ok.setBounds(330, 670, 80, 40);
        ok.setFocusPainted(false);
        ok.setFont(new Font("Arial",Font.BOLD,15));
        ok.setBackground(Color.black);
        ok.setForeground(Color.white);
        ok.addActionListener(this);
        add(ok);

        setSize(800, 770);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ok) {
            setVisible(false);
        }
    }
    public static void main (String[]args){
            new terms_condition();
    }
}
