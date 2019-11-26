package SoloTry.Archers;

import SoloTry.Bows.Bow;
import SoloTry.Bows.CarbonBow;

import java.util.Random;

public class VeteranArcher extends SeniorArcher {

    private static final int STABILIZATION = 2;
    private static final int ARROWS_COUNT = 60;

    public VeteranArcher(String name, boolean isMale, int age, CarbonBow bow, int experience, int tournaments) {
        super(name, isMale, age, bow, experience, tournaments);
    }

    @Override
    public ArcherType getType() {
        return ArcherType.VETERAN;
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
            points+= AIM +STABILIZATION;
        }
        if(points> 10){
            return 10;
        }
        return points;
    }

    @Override
    protected boolean hasMissed() {
        return false;
    }
}
