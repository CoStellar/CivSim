package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Information extends JPanel
{
    Information() throws IOException, FontFormatException
    {
        Font pix3mFont = Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")));

        Scanner scanner = new Scanner(System.in);
        String string = new Scanner(new File("./CivSim/src/main/resources/com/civsim/Pliki/data_sheet.txt")).useDelimiter("\\A").next();
        JFrame frame = new JFrame();
        frame.setSize(300,500);
        frame.setTitle("Results");
        final JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setFont(pix3mFont.deriveFont(20f));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(string);
        frame.add(scroll);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        }
}
