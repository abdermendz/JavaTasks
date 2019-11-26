package SoloTry.Archers;

import SoloTry.Bows.Bow;

public abstract class Archer {

    public enum ArcherType{
        JUNIOR, SENIOR, VETERAN;
    }

    private String name;
    private boolean isMale;
    private int age;
    private Bow bow;
    private int experience;
    private int tournaments;
    private int points;
    private int misses;

    public Archer(String name, boolean isMale, int age, Bow bow, int experience, int tournaments) {
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.bow = bow;
        this.experience = experience;
        this.tournaments = tournaments;

    }

    public abstract ArcherType  getType();
    public String getName(){
        return this.name;
    }

    public int getPoints(){
        return this.points;
    }

    public void increaseTournaments(){
        this.tournaments+=1;
    }

    protected abstract int getRandomPoints();
    protected abstract boolean hasMissed();
    protected abstract int getArrowsCount();
    public void shoot(){
        for(int i =0 ; i < this.getArrowsCount();i++){
            if(this.hasMissed()){
                this.points+=0;
            }
            this.points+= this.getRandomPoints();
        }
    }
    public boolean isMale(){
        return isMale;
    }
    public int getExperience(){
        return this.experience;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", age=" + age +
                ", bow=" + bow +
                ", experience=" + experience +
                ", tournaments=" + tournaments +
                '}';
    }
}
