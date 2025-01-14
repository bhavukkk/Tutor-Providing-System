package tuition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aboutus extends JFrame implements ActionListener {
    String passing;
    JButton back;
    aboutus(String username){
        this.passing = username;
        setTitle("About Us");
        setLayout(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/aboutusbg.png"));
                Image img = bgIcon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));  // 60% opacity
                g2d.setColor(Color.BLUE);  // overlay, adjust as needed
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 200);

        JLabel aboutUsLabel = new JLabel("About Us", SwingConstants.CENTER);
        aboutUsLabel.setFont(new Font("comic sans ms", Font.BOLD, 60));  // Set font size and style
        aboutUsLabel.setForeground(Color.white); // Set text color to white
        aboutUsLabel.setBounds(300, 40, 300, 200);  // Set label size
        aboutUsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aboutUsLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(aboutUsLabel);

        add(panel);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/education.png"));
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel i7 = new JLabel(i6);
        i7.setBounds(110,271,50,50);
        add(i7);

        JLabel header = new JLabel("TUTE IT UP!");
        header.setFont(new Font("Arial Black",Font.BOLD,25));
        header.setBounds(180,271,200,50);
        header.setForeground(Color.yellow);
        add(header);

        JLabel content = new JLabel("<html>Tuteitup.com is an online education portal that helps in connecting a student seeking home tutor and the teacher searching for a home tuition job. We are a growing family of almost 76000+ tutors and students who are happily enjoying the art of learning from a personalized tutor.</html>");
        content.setForeground(Color.black);
        content.setFont(new Font("Calibri",Font.PLAIN,14));
        content.setBounds(460,145,400,300);
        add(content);

        JLabel head2 = new JLabel("<html><h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OUR STORY</h1></html>");
        head2.setForeground(Color.black);
        head2.setFont(new Font("Arial",Font.PLAIN,14));
        head2.setBounds(100,135,700,500);
        add(head2);

        JLabel content2 = new JLabel("<html>Our story starts in 2014 when our founders were also a teacher and they often encounter the problem of finding a teaching job vacancy near their location. Soon they realized that this not only their problem but it is a hectic process for most of the teachers. Similarly, after talking to some parents, they got to know that the parents are also worried about finding an experienced and well-qualified teacher for their child. Students and parents were also having difficulties hiring a private tutor. It was that time when our founders identified an opportunity to start a venture that would help in eliminating the unnecessary inconvenience faced by students and parents as well as the teachers. After a few months of market research and planning, finally, Tuteitup.com was founded in October 2014. Tuteitup.com (also known as Chawla Enterprise / Chawla Classes) was started as an idea to narrow the gap between the teachers who are struggling in finding a better tutoring job and the students who are willing to hire a home tutor. It paved a way for working professionals, who were looking for a part-time job after office hours, to opt for a part-time job. Also, it proved to be a way for housewives to take up teaching a part-time profession after they are done with their household work. As the popularity of Tuteitup's efficient services increased, it was decided to expand the operation from Delhi-NCR to other cities of the country. As of now, we are operational in Delhi-NCR, Mumbai and Hyderabad and hope to expand our operational area pan India. Our vision is to make education available for every student and provide an opportunity for the teachers to earn a good salary by sharing their knowledge. We are not here to earn, but to serve our people with better services. We keep enhancing ourselves in every field and strive to give a better experience to our every user every time.</html>");
        content2.setForeground(Color.black);
        content2.setFont(new Font("Arial",Font.PLAIN,14));
        content2.setBounds(100,315,700,500);
        add(content2);

        JLabel bg = new JLabel();
        float hue1 = 0.45f;         // Green hue
        float saturation1 = 1.0f;   // Fully saturated (rich color)
        float brightness1 = 0.4f;   // Low brightness for a dark shade
        int rgb1 = Color.HSBtoRGB(hue1, saturation1, brightness1);
        bg.setBackground(new Color(rgb1));
        bg.setOpaque(true);
        bg.setBounds(60,245,350,100);
        add(bg);

        back = new JButton("BACK");
        back.setBounds(770, 730, 80, 40);
        back.setFocusPainted(false);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setLocation(310,0);
        setSize(900,820);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new home_page(passing).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new aboutus("");
    }
}
