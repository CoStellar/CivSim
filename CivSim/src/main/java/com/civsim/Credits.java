package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Credits extends JPanel {
    JFrame panel = new JFrame();
    JLabel label = new JLabel("<html><body><center>Czcionka stworzona przez: Pix3m<br><br>Twórcy aplikacji:<br>Agata Falkowska<br>Monika Janicka<br>Patryk Wawrzacz</center></body></html>");
    Font pix3mFont;
    Credits() throws IOException, FontFormatException
    {
        InputStream is = (new FileInputStream("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf"));//dodanie nowej czcionki do programu TWÓRCA: pix3m
        Font pix3mFont = Font.createFont(Font.TRUETYPE_FONT, is);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(pix3mFont);

        label.setFont(pix3mFont.deriveFont(22f));
        label.setBounds(50,10,200,160);
        panel.setSize(300,300);
        ImageIcon image = new ImageIcon(String.valueOf(new File("./CivSim/src/main/resources/com/civsim/Pliki/control_panel/icon.png")));
        panel.setIconImage(image.getImage());
        panel.add(label);
        panel.setVisible(true);
    }
}

