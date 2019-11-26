package SoloTry.Club;

import SoloTry.Archers.Archer;
import SoloTry.Archers.JuniorArcher;
import SoloTry.Archers.SeniorArcher;
import SoloTry.Archers.VeteranArcher;
import javafx.scene.shape.Arc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Club {
    private String name;
    private String address;
    private String coach;
    private ArrayList<Archer> archers;
    private HashMap<Archer.ArcherType,HashMap<Archer,Integer>> results;

    public Club(String name, String address, String coach) {
        this.name = name;
        this.address = address;
        this.coach = coach;
        this.archers = new ArrayList<>();
        this.results = new HashMap<>();
    }

    public void addArcher(Archer archer){
        this.archers.add(archer);
    }

    public void startTournament(){
        printContestants();
        shootArrows();
        printStatistics();
    }

    private void printContestants() {
        TreeSet<Archer> archers = new TreeSet<Archer>((e1,e2) -> {
            if(e1.getName().equalsIgnoreCase(e2.getName())){
                return 1;
            }
            else{
                return e1.getName().compareTo(e2.getName());
            }
        });
        archers.addAll(this.archers);

        for(Archer a : this.archers){
            a.increaseTournaments();
            System.out.println(a);
        }
    }

    private void shootArrows(){
        for(Archer a : this.archers){
            a.shoot();

            if(!results.containsKey(a.getType())){
                results.put(a.getType(),new HashMap<>());
            }
            results.get(a.getType()).put(a,a.getPoints());
        }

    }

    private void printStatistics(){
        printWinners();
        printAvgScores();
        printSharpShooter();
        printMoronShooter();
        printWomenAccuracyStats();
        printCarbonBowMen();
    }

    private void printWinners(){
        Archer juniorWinner = null;
        Archer seniorWinner= null;
        Archer veteranWinner = null;

        for(Archer a : archers){

            switch (a.getType()){
                case JUNIOR:
                    if(juniorWinner == null || a.getPoints() > juniorWinner.getPoints()){
                        juniorWinner = a;
                        break;
                    }
                case SENIOR:
                    if(seniorWinner == null || a.getPoints() > seniorWinner.getPoints()){
                        seniorWinner = a;
                        break;
                    }
                case VETERAN:
                    if(veteranWinner == null || a.getPoints() > veteranWinner.getPoints()){
                        veteranWinner= a;
                        break;
                    }
            }
        }

        System.out.println("Junnior winner :"+ juniorWinner);
        System.out.println("Senior winner :"+seniorWinner);
        System.out.println("Veteran winner :"+veteranWinner);
    }

    private void printAvgScores(){
        for(Map.Entry<Archer.ArcherType,HashMap<Archer,Integer>> e : results.entrySet()){
            HashMap<Archer,Integer> innerMap = e.getValue();
            int size = innerMap.size();
            int sum = 0;
            int avg =0;
            for(Archer a : innerMap.keySet()){
                sum+= a.getPoints();
            }
            avg = sum /size;
            System.out.println(e.getKey() + " - "+ avg);
        }
    }

    private void printSharpShooter(){
        Archer sharpShooter =null;
        for(Archer a : archers){
            if(sharpShooter == null ||a.getPoints() > sharpShooter.getPoints()){
                sharpShooter = a;
            }
        }
        System.out.println("The sharpest shooter is: "+ sharpShooter.getName() + " with "+ sharpShooter.getPoints()+ " points!");
    }

    private void printMoronShooter(){
        Archer moronShooter =null;
        for(Archer a : archers){
            if(moronShooter == null ||a.getPoints() < moronShooter.getPoints()){
                moronShooter = a;
            }
        }
        System.out.println("The weakest shooter is: "+ moronShooter.getName() + " with "+ moronShooter.getPoints()+ " points!");
    }

    private void printWomenAccuracyStats(){
        for(Map.Entry<Archer.ArcherType,HashMap<Archer,Integer>> e : results.entrySet()){
            HashMap<Archer,Integer> toBeSorted = e.getValue();
           ArrayList<Map.Entry<Archer,Integer>> list  =new ArrayList<>(toBeSorted.entrySet());
           list.sort((e1,e2) -> e2.getValue() - e1.getValue());

           int maxPoints =list.get(0).getValue();

           for(Map.Entry<Archer,Integer> entry: list){
               if(entry.getKey().isMale()){
                   continue;
               }
               double pp = (double)entry.getValue() / maxPoints *100;
               System.out.println(entry.getValue() + " with percentage " + pp);
           }
        }
    }

    private void printCarbonBowMen(){
        TreeSet<Archer> archers = new TreeSet<>((e1,e2)-> {
            if(e1.getExperience() - e2.getPoints() == 0){
                return 1;
            }
            return  e1.getExperience() - e2.getExperience();
        });

        archers.addAll(this.archers);
        for(Archer a : archers){
            if(a.isMale()){
                System.out.println(a);
            }
        }
    }



}
