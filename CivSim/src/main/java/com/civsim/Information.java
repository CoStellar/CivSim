package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Information extends JPanel {
    private ArrayList<Civilization> civilizations;
    private ArrayList<ArrayList<Position>> positionsOfCivilizations = new ArrayList<>();
    private ArrayList<JLabel> info = new ArrayList<>();
    Information(ArrayList<Civilization> civilizations) throws IOException, FontFormatException {
        Font pix3mFont = Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")));

        this.civilizations = civilizations;
        for(int i = 0; i< civilizations.size();i++){
            positionsOfCivilizations.add(new ArrayList<>());
            positionsOfCivilizations.add(this.civilizations.get(i).civFieldPosition);
            JFrame panel = new JFrame();
            StringBuilder tekst = null;
            for(int o=0;o < civilizations.size(); o++ ){
                for(int p = 0; p<positionsOfCivilizations.get(o).size();p++){
                    assert tekst != null;
                    tekst.append(positionsOfCivilizations.get(o).get(p).x.toString()).append(",").append(positionsOfCivilizations.get(o).get(p).y.toString()).append(" ");
                }
             info.add(new JLabel("<html><body><center>Cywilizacja "+o+"<br>Pozycje Cywilizacji:<br>"+tekst+"</center></body></html>"));
             info.get(o).setBounds(15,o*20,200,20);
             info.get(o).setFont(pix3mFont.deriveFont(16f));
            }

            panel.setLayout(new FlowLayout());
            panel.setLocationRelativeTo(null);                                              //Okno aplikacji już nie pojawia się w lewym górnym rogu
            panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           //Po zamknięciu panelu cała aplikacja zostaje wyłączona.
            panel.setSize(366,539);                                             //Ustawienie wielkości okna             //Wyłączenie domyslnego ustawienia obiektów w oknie aplikacji
            panel.setTitle("Wyniki Symulacji");                                        //Ustawienie tytułu aplikacji
            panel.setResizable(false);
            for(int o=0;o < civilizations.size(); o++ ){
                panel.add(info.get(o));
            }
            panel.setVisible(true);
        }
    }


}
