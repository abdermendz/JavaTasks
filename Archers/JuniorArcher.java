package SoloTry.Archers;

import SoloTry.Bows.Bow;
import SoloTry.Bows.WoodenBow;
import SoloTry.Demo;

import java.util.Random;

public class JuniorArcher extends Archer{

    private static final int CHANCE_TO_MISS = 10;
    private static final int ARROWS_COUNT = 30;

    public JuniorArcher(String name, boolean isMale, int age, WoodenBow bow, int experience, int tournaments) {
        super(name, isMale, age, bow, experience, tournaments);
    }

    @Override
    public ArcherType getType() {
        return ArcherType.JUNIOR;
    }

    @Override
    protected int getArrowsCount() {
        return ARROWS_COUNT;
    }

    @Override
    protected boolean hasMissed() {
        Random r = new Random();
        if(r.nextInt(100) < 10){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected int getRandomPoints() {
        Random r = new Random();
        return r.nextInt(9)+1;
    }

}
