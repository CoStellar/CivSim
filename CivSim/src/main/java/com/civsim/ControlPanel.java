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
    JLabel background;
    JButton creditsButton;
    Font pix3mFont;
    File file;
    Color button = new Color(156,86,46);
    ControlPanel() throws IOException {
        label.setBounds(106,50,200,68);
            try{
                pix3mFont = Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")).deriveFont(32f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")));
            }catch (IOException | FontFormatException e){
                System.out.println(e);
            }
        label.setFont(pix3mFont);
        panel.add(label);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(366,539);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setTitle("Symulacja Cywilizacji");
        file = new File("./CivSim/src/main/resources/com/civsim/Pliki/background.png");
        ImageIcon image = new ImageIcon(String.valueOf(file));
        background = new JLabel(image);
        background.setSize(350, 500);
        panel.add(background);
        file = new File("./CivSim/src/main/resources/com/civsim/Pliki/icon.png");
        image = new ImageIcon(String.valueOf(file));
        panel.setIconImage(image.getImage());
        creditsButton = new JButton("Credits");
        creditsButton.setBackground(button);
        creditsButton.setBounds(128,440,100,40);
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Credits credits = new Credits();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(creditsButton);

    }


}
