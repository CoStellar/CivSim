package Project.Projekt;

import javax.swing.*;

public class ApplicationPanel {

    Civilization civilization = new Civilization();
        ApplicationPanel(){
            JFrame frame = new JFrame();
            frame.setSize(800,800);
            frame.setTitle("Symulacja Cywilizacji");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon image = new ImageIcon("icon.png");
            frame.setIconImage(image.getImage());
            frame.setVisible(true);


            frame.add(civilization);

        }
}
