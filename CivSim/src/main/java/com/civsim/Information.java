package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Information extends JPanel
{
    Information() throws IOException, FontFormatException
    {
        InputStream is = (new FileInputStream("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf"));//dodanie nowej czcionki do programu TWÓRCA: pix3m
        Font pix3mFont = Font.createFont(Font.TRUETYPE_FONT, is);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(pix3mFont);
        String string = new Scanner(new File("./CivSim/src/main/resources/com/civsim/Pliki/data_sheet.txt")).useDelimiter("\\A").next();
        JFrame frame = new JFrame();
        frame.setSize(500,600);
        frame.setTitle("Results");
        final JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setFont(pix3mFont.deriveFont(20f));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(string);
        frame.add(scroll);
        File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/control_panel/icon.png");
        ImageIcon image = new ImageIcon(String.valueOf(file));
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        }
}
