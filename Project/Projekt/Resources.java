package Project.Projekt;
import java.util.Random;
public class Resources {
    Integer wood;
    Integer iron;
    Integer wheat;
    Integer animals;
    Integer stone;
    Integer water;
    Random randomAmount = new Random();
    Resources(){
        this.wood = randomAmount.nextInt(3);
        this.iron = randomAmount.nextInt(3);
        this.wheat = randomAmount.nextInt(3);
        this.animals = randomAmount.nextInt(3);
        this.stone = randomAmount.nextInt(3);
        this.water = randomAmount.nextInt(3);
    }
    void drawResources(){
    }

}
