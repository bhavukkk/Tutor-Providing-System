package tuition;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.net.*;

public class contact_us extends JFrame implements ActionListener {
    String passing;
    JButton back;
    contact_us(String username){
        this.passing = username;
        setTitle("Contact Us");
        setLayout(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/contactusbg.jpg"));
                Image img = bgIcon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));  // 60% opacity
                g2d.setColor(Color.BLUE);  // overlay, adjust as needed
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);
        panel.setBounds(0, 0, 920, 200);

        JLabel aboutUsLabel = new JLabel("Contact Us", SwingConstants.CENTER);
        aboutUsLabel.setFont(new Font("comic sans ms", Font.BOLD, 50));  // Set font size and style
        aboutUsLabel.setForeground(Color.white); // Set text color to white
        aboutUsLabel.setBounds(300, 40, 300, 200);  // Set label size
        aboutUsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aboutUsLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(aboutUsLabel);

        add(panel);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/mobile.png"));
        Image a2 = a1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel a4 = new JLabel(a3);
        a4.setBounds(135,285,60,60);
        add(a4);

        JLabel mobile = new JLabel("+91 9311656688");
        mobile.setForeground(Color.black);
        mobile.setFont(new Font("Arial",Font.BOLD,18));
        mobile.setBounds(90,360,150,50);
        add(mobile);

        JLabel contact1 = new JLabel();
        float hue1 = 0.09f;         // Orange hue
        float saturation1 = 1.0f;   // Fully saturated
        float brightness1 = 0.9f;   // Dark brightness
        int rgb1 = Color.HSBtoRGB(hue1, saturation1, brightness1);
        float hue2 = 0.75f;         // Purple hue
        float saturation2 = 1.0f;   // Fully saturated
        float brightness2 = 0.6f;   // Dark brightness
        int rgb2 = Color.HSBtoRGB(hue2, saturation2, brightness2);
        contact1.setBackground(new Color(rgb1));
        contact1.setOpaque(true);
        contact1.setBounds(40,225,250,250);
        add(contact1);

        ImageIcon a5 = new ImageIcon(ClassLoader.getSystemResource("icons/email.png"));
        Image a6 = a5.getImage().getScaledInstance(80,60,Image.SCALE_DEFAULT);
        ImageIcon a7 = new ImageIcon(a6);
        JLabel a8 = new JLabel(a7);
        a8.setBounds(420,290,80,70);
        add(a8);

        JLabel email = new JLabel("support@tuteitup.com");
        email.setForeground(Color.black);
        email.setFont(new Font("Arial",Font.BOLD,18));
        email.setBounds(360,360,250,50);
        add(email);

        JLabel contact3 = new JLabel();
        contact3.setBackground(new Color(rgb1));
        contact3.setOpaque(true);
        contact3.setBounds(335,225,250,250);
        add(contact3);

        ImageIcon a9 = new ImageIcon(ClassLoader.getSystemResource("icons/loc.png"));
        Image a10 = a9.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon a11 = new ImageIcon(a10);
        JLabel a12 = new JLabel(a11);
        a12.setBounds(720,280,60,60);
        add(a12);

        JLabel address = new JLabel("<html>Registered office at<br>2-126/2/4, Cannaught PLace, Delhi</html>");
        address.setForeground(Color.black);
        address.setFont(new Font("Arial",Font.BOLD,15));
        address.setBounds(650,350,250,100);
        add(address);

        JLabel contact2 = new JLabel();
        contact2.setBackground(new Color(rgb1));
        contact2.setOpaque(true);
        contact2.setBounds(630,225,250,250);
        add(contact2);

        JLabel bg = new JLabel();
        bg.setBackground(Color.white);
        bg.setOpaque(true);
        bg.setBounds(10,200,300,300);
        bg.setBorder(new LineBorder(new Color(rgb2),2));
        add(bg);

        JLabel bg1 = new JLabel();
        bg1.setBackground(Color.white);
        bg1.setOpaque(true);
        bg1.setBounds(310,200,300,300);
        bg1.setBorder(new LineBorder(new Color(rgb2),2));
        add(bg1);

        JLabel bg2 = new JLabel();
        bg2.setBackground(Color.white);
        bg2.setOpaque(true);
        bg2.setBounds(610,200,300,300);
        bg2.setBorder(new LineBorder(new Color(rgb2),2));
        add(bg2);

        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("icons/linkedin.png"));
        Image b2 = b1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon b3 = new ImageIcon(b2);
        JLabel b4 = new JLabel(b3);
        b4.setBounds(335,570,60,60);
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://www.linkedin.com/in/bhavuk-moolchandani-2363ab271/");
                    desktop.browse(uri);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
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
        add(b4);

        ImageIcon b5 = new ImageIcon(ClassLoader.getSystemResource("icons/insta.png"));
        Image b6 = b5.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon b7 = new ImageIcon(b6);
        JLabel b8 = new JLabel(b7);
        b8.setBounds(412,534,100,100);
        b8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b8.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://www.instagram.com/bhavuk_0207_/");
                    desktop.browse(uri);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
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
        add(b8);

        ImageIcon b9 = new ImageIcon(ClassLoader.getSystemResource("icons/facebook.png"));
        Image b10 = b9.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon b11 = new ImageIcon(b10);
        JLabel b12 = new JLabel(b11);
        b12.setBounds(510,548,100,100);
        b12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b12.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://www.facebook.com/bhavuk.moolchandani");
                    desktop.browse(uri);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
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
        add(b12);

        back = new JButton("BACK");
        back.setBounds(790, 730, 80, 40);
        back.setFocusPainted(false);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setLocation(310,0);
        setSize(933,820);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new home_page(passing).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new contact_us("");
    }
}
