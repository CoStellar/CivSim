package Project.Projekt;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
public class ApplicationPanel {

        ApplicationPanel(){
            JFrame frame = new JFrame();
            frame.setSize(1000,1000);
            frame.setTitle("Symulacja Cywilizacji");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            ImageIcon image = new ImageIcon("icon.png");
            frame.setIconImage(image.getImage());
            frame.setVisible(true);
        }

}