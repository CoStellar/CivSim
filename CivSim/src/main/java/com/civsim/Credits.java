package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Credits extends JPanel {
    JFrame panel = new JFrame();
    JLabel label = new JLabel("<html><body><center>Czcionka stworzona przez: Pix3m</center</body></html>");
    JLabel background;
    Font pix3mFont;
    File file;
    Credits() throws IOException {
            try{
                pix3mFont = Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")).deriveFont(22f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")));
            }catch (IOException | FontFormatException e){
                System.out.println(e);
            }
             label.setFont(pix3mFont);
             panel.setSize(300,200);
             panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             panel.add(label);
             panel.setVisible(true);
    }


}
