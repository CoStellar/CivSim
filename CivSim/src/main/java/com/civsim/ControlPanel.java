package com.civsim;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {

    private final JTextField firstText = new JTextField("25",1);
    private final JTextField secondText = new JTextField("10",1);
    private final JTextField thirdText = new JTextField("20",1);



    private Integer civCount;
    private Integer turnAmount;

    private MapSize mapSize;
    public JFrame panel;
    public ControlPanel() throws IOException, FontFormatException {

                                                                                //dodanie nowej czcionki do programu TWÓRCA: pix3m
        Font pix3mFont = Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./CivSim/src/main/resources/com/civsim/Pliki/Font/bitmap_font_romulus_by_pix3m-d6aokem.ttf")));

                                                                                //stworzenie panelu(okna) które będzie się wyświetlało
        panel = new JFrame();
        panel.setLayout(new FlowLayout());
                                                                                //ustawienie odpowiednich tekstów, które będą wypisane w programie
        JLabel label1 = new JLabel("<html><body><center>Symulacja<br>Cywilizacji</center</body></html>");
        label1.setBounds(106,55,200,68);
        label1.setFont(pix3mFont.deriveFont(32f));                          //Ustawienie czcionki tekstu oraz jej wielkości
        panel.add(label1);

                                                                                //korzystamy ze składni kodu html(strony internetowej), aby móc skorzystac z załamania tekstu
        JLabel label2 = new JLabel("<html><body><center>Wprowadź<br>Dane</center</body></html>");
        label2.setFont(pix3mFont.deriveFont(14.4f));
        label2.setBounds(145,178,93,32);
        panel.add(label2);


        JLabel label3 = new JLabel("<html><body><center>Wielkość Mapy</center</body></html>");
        label3.setFont(pix3mFont.deriveFont(13f));
        label3.setBounds(135,233,129,10);
        panel.add(label3);

        JLabel label4 = new JLabel("<html><body><center>Ilość Cywilizacji</center</body></html>");
        label4.setFont(pix3mFont.deriveFont(13f));
        label4.setBounds(132,298,129,10);
        panel.add(label4);

        JLabel label5 = new JLabel("<html><body><center>Czas Trwania Symulacji</center</body></html>");
        label5.setFont(pix3mFont.deriveFont(13f));
        label5.setBounds(110,363,129,10);
        panel.add(label5);

                                                                                    //pobranie pliku tła oraz użycie go
        File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/control_panel/background.png");
        ImageIcon image = new ImageIcon(String.valueOf(file));
        JLabel background = new JLabel(image);
        background.setSize(350, 500);
        panel.add(background);

                                                                                    //pobranie pliku ikony aplikacji i ustawienie jej
        file = new File("./CivSim/src/main/resources/com/civsim/Pliki/control_panel/icon.png");
        image = new ImageIcon(String.valueOf(file));
        panel.setIconImage(image.getImage());

                                                                                    //modyfikowanie wielkości, pozycji i czcionki pól tekstowych
        firstText.setSize( 193, 23);
        firstText.setLocation(78,250);
        firstText.setFont(pix3mFont.deriveFont(18f));                           //Ustawienie czcionki pola tekstowego oraz jej wielkości
        firstText.addKeyListener(new KeyAdapter() {                                 //zezwala na wprowadzenie tylko liczb, poprzez ignorowanie innych znaków niż cyfry
            public void keyTyped(KeyEvent e) {                                      //każde zdarzenie związane z przyciskiem klawiatury jest rejestrowane jako e
                char c = e.getKeyChar();                                            //przypisana zostaje tutaj wartość znakowa zdarzenia e
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {   //sprawdza, czy c znajduje się poza obszarem cyfr w kodzie ascii lub czy c NIE jest usunięciem znaku
                    e.consume();                                                    //jeśli tamto wyrażenie jest prawdziwe wartość e jest "usuwana", co jest jednoznaczne z nie przyjęciem danego znaku do pola tekstowego
                }
            }
        });


        secondText.setSize( 193, 23);
        secondText.setLocation(78,315);
        secondText.setFont(pix3mFont.deriveFont(18f));
        secondText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        thirdText.setSize( 193, 23);
        thirdText.setLocation(78,380);
        thirdText.setFont(pix3mFont.deriveFont(18f));
        thirdText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });


        panel.add(firstText);
        panel.add(secondText);
        panel.add(thirdText);

                                                                                        //Dodanie przycisku start, uruchamiającego symulację
        JButton startButton = new JButton("Start");
        Color button = new Color(157, 97, 27);                                  //Stworzenie koloru dla przycisku
        startButton.setBackground(button);                                              //UStawienie koloru przycisku
        startButton.setBounds(139,427,72,23);                           //Ustawienie pozycji przycisku
        startButton.setMargin(new Insets(2,2,2,2));                 //Ustawienie marginesów przycisku, aby móc zmieścić w nim większy tekst
        startButton.setFont(pix3mFont.deriveFont(18f));                             //Ustawienie czcionki przycisku oraz jej wielkości
        startButton.setBorderPainted(false);                                            //Wyłączenie kolorów obramówek wokół przycisku
        startButton.setFocusable(true);
        startButton.setFocusPainted(false);                                             //Wyłączenie kolorów obramówek wokół tekstu w przycisku, po jego naciśnięciu

                                                                                        //Działanie przycisku
        startButton.addActionListener(e -> {
                    mapSize = new MapSize(Integer.parseInt(firstText.getText()));           //Ustawienie mapSize na wpisaną wartość
                    civCount = Integer.parseInt(secondText.getText());                      //----||---- civCount -------||--------
                    turnAmount = Integer.parseInt(thirdText.getText());                     //----||---- turnAmount -----||--------
                    try {
                        runSimulation();                                                        //Po ustawieniu wartości uruchomiona zostaje metoda runSimulation()
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        );

        panel.add(startButton);

        JButton creditsButton = new JButton("Credits");
        creditsButton.setBackground(button);
        creditsButton.setBounds(282,456,47,23);
        creditsButton.setMargin(new Insets(2,2,2,2));
        creditsButton.setFont(pix3mFont.deriveFont(12.4f));
        creditsButton.setBorderPainted(false);
        creditsButton.setFocusable(true);
        creditsButton.setFocusPainted(false);
        creditsButton.addActionListener(e -> {
            try {
                new Credits();                                                          //Inicjalizajca klasy Credits, aby wyświetlić twórców aplikacji oraz twórcę użytej czcionki
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
                }
        );
        panel.add(creditsButton);

        panel.setLocationRelativeTo(null);                                              //Okno aplikacji już nie pojawia się w lewym górnym rogu
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           //Po zamknięciu panelu cała aplikacja zostaje wyłączona.
        panel.setSize(366,539);                                             //Ustawienie wielkości okna
        panel.setLayout(null);                                                          //Wyłączenie domyslnego ustawienia obiektów w oknie aplikacji
        panel.setTitle("Symulacja Cywilizacji");                                        //Ustawienie tytułu aplikacji
        panel.setResizable(false);                                                      //Wyłączenie możliwości zmiany wielkości okna apliakcji
        panel.setVisible(true);                                                         //Włączenie widoczności okna
    }

    public void runSimulation() throws IOException {
        new Simulation(civCount, turnAmount, mapSize);                                   //Uruchomienie instancji klasy Symulacja
    }

}
