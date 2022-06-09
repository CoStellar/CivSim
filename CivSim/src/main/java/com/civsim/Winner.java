package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Winner {

    Winner(String[] string) throws IOException, FontFormatException
    {
        InputStream is = (new FileInputStream("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf"));//dodanie nowej czcionki do programu TWÓRCA: pix3m
        Font pix3mFont = Font.createFont(Font.TRUETYPE_FONT, is);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(pix3mFont);
        JFrame frame = new JFrame();
        frame.setSize(550,400);
        frame.setTitle("Results");
        final JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setFont(pix3mFont.deriveFont(24f));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(212, 145, 68));
        for (String s : string) {
            textArea.append(s);
        }
        frame.add(scroll);
        File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/control_panel/icon.png");
        ImageIcon image = new ImageIcon(String.valueOf(file));
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
