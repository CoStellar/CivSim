package Project.Projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ApplicationPanel extends JPanel{

        private Random random;
        private  BufferedImage[] img;

        public ApplicationPanel(BufferedImage[] img)   {
            this.img = img;

        }
        public MapSize mapSize = new MapSize(25);
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            for(int y=0; y< mapSize.getMapSize(); y++){
                for(int x=0;   x<mapSize.getMapSize(); x++){
                        random = new Random();
                        g.drawImage(img[random.nextInt(6)], (x * 32)+x, (y * 32)+y, null);
                    }
            }

        }


}
