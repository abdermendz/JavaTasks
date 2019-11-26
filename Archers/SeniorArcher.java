package SoloTry.Archers;

import SoloTry.Bows.AluminiumBow;
import SoloTry.Bows.Bow;
import SoloTry.Bows.CarbonBow;
import javafx.scene.shape.Arc;

import java.util.Random;

public class SeniorArcher extends Archer {

    protected static final int AIM = 1;
    private static final int ARROWS_COUNT= 60;


    public SeniorArcher(String name, boolean isMale, int age, AluminiumBow bow, int experience, int tournaments) {
        super(name, isMale, age, bow, experience, tournaments);
    }

    public SeniorArcher(String name, boolean isMale, int age, CarbonBow bow, int experience, int tournaments) {
        super(name, isMale, age, bow, experience, tournaments);
    }

    @Override
    public ArcherType getType() {
        return  ArcherType.SENIOR;
    }

    @Override
    protected int getArrowsCount() {
        return ARROWS_COUNT;
    }

    @Override
    protected int getRandomPoints() {
        Random r = new Random();
       int points =  r.nextInt(4)+6;
       if(points< 10){
           points+= AIM;
       }
       if(points> 10){
           return 10;
       }
       return points;
    }

    @Override
    protected boolean hasMissed(){
        Random r = new Random();
        if(r.nextInt(100) < 5){
            return true;
        }
        return false;
    }
}

