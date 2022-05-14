package Project.Projekt;

import javax.swing.*;

public class ApplicationPanel {

        ApplicationPanel(){
            JFrame frame = new JFrame();
            frame.setSize(800,800);
            frame.setTitle("Symulacja Cywilizacji");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            ImageIcon image = new ImageIcon("icon.png");
            frame.setIconImage(image.getImage());


            frame.setVisible(true);
        }
}
