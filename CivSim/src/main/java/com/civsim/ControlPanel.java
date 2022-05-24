package com.civsim;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    JFrame panel = new JFrame();
    JLabel label = new JLabel("<html><body><center>Symulacja<br>Cywilizacji</center</body></html>");
    JLabel label2 = new JLabel("<html><body><center>Wprowadź<br>Dane</center</body></html>");
    JLabel label3 = new JLabel("<html><body><center>Wielkość Mapy</center</body></html>");
    JLabel label4 = new JLabel("<html><body><center>Ilość Cywilizacji</center</body></html>");
    JLabel label5 = new JLabel("<html><body><center>Czas Trwania Symulacji</center</body></html>");

    JLabel background;
    String blank = " ";
    JTextField firstText = new JTextField(blank,1);
    JTextField secondText = new JTextField(blank,1);
    JTextField thirdText = new JTextField(blank,1);

    JButton creditsButton;
    JButton startButton;
    Font pix3mFont;
    File file;
    Color button = new Color(157, 97, 27);

    ControlPanel() throws IOException {

            try{
                pix3mFont = Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf"));
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")));
            }catch (IOException | FontFormatException e){
                System.out.println(e);
            }

        panel.setLayout(new FlowLayout());
        label.setBounds(106,55,200,68);
        label.setFont(pix3mFont.deriveFont(32f));
        panel.add(label);

        label2.setFont(pix3mFont.deriveFont(14.4f));
        label2.setBounds(145,178,93,32);
        panel.add(label2);

        label3.setFont(pix3mFont.deriveFont(13f));
        label3.setBounds(135,233,129,10);
        panel.add(label3);

        label4.setFont(pix3mFont.deriveFont(13f));
        label4.setBounds(132,298,129,10);
        panel.add(label4);

        label5.setFont(pix3mFont.deriveFont(13f));
        label5.setBounds(110,363,129,10);
        panel.add(label5);




        file = new File("./CivSim/src/main/resources/com/civsim/Pliki/background.png");
        ImageIcon image = new ImageIcon(String.valueOf(file));
        background = new JLabel(image);
        background.setSize(350, 500);
        panel.add(background);

        file = new File("./CivSim/src/main/resources/com/civsim/Pliki/icon.png");
        image = new ImageIcon(String.valueOf(file));
        panel.setIconImage(image.getImage());

        firstText.setSize( 193, 23);
        firstText.setLocation(78,250);
        firstText.setFont(pix3mFont.deriveFont(18f));

        secondText.setSize( 193, 23);
        secondText.setLocation(78,315);
        secondText.setFont(pix3mFont.deriveFont(18f));

        thirdText.setSize( 193, 23);
        thirdText.setLocation(78,380);
        thirdText.setFont(pix3mFont.deriveFont(18f));

        panel.add(firstText);
        panel.add(secondText);
        panel.add(thirdText);


        startButton = new JButton("Start");
        startButton.setBackground(button);
        startButton.setBounds(139,427,72,23);
        startButton.setMargin(new Insets(2,2,2,2));
        startButton.setFont(pix3mFont.deriveFont(18f));
        startButton.setBorderPainted(false);
        startButton.setFocusable(true);
        startButton.setFocusPainted(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Credits credits = new Credits();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        );

        panel.add(startButton);

        creditsButton = new JButton("Credits");
        creditsButton.setBackground(button);
        creditsButton.setBounds(282,456,47,23);
        creditsButton.setMargin(new Insets(2,2,2,2));
        creditsButton.setFont(pix3mFont.deriveFont(12.4f));
        creditsButton.setBorderPainted(false);
        creditsButton.setFocusable(true);
        creditsButton.setFocusPainted(false);
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Credits credits = new Credits();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        );
        panel.add(creditsButton);



        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(366,539);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setTitle("Symulacja Cywilizacji");



    }


}
