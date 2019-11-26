package SoloTry;

import SoloTry.*;
import SoloTry.Archers.*;
import SoloTry.Bows.*;
import SoloTry.Club.*;

import java.util.Random;

public class Demo {


    public static void main(String[] args) {

        Random r = new Random();
        String names[]= {"Matt","Brat","Kubrat","Klichko","Petyr","Etyr","Eetryr","Sam","Dean","John","Bobby",
                "Jessica","Merry","Katarina","Ashe","Sivir","Vayne","Penka","Ginka","Tonka","Monka"};


        Club club = new Club("IT archers","Aleksii Rilets 38","Krasi");
        int maxArchers = 40;
        for(int i = 0 ; i<maxArchers;i++){
            if(r.nextInt(2)+1==1){
                WoodenBow bow = new WoodenBow("BBB",25,30);
                Archer archer = new JuniorArcher(names[r.nextInt(names.length)],r.nextBoolean(),r.nextInt(40)+12, bow,1,0);
                club.addArcher(archer);

            }
            else if(r.nextInt(2)+1 == 2){
                if(r.nextBoolean()){
                    AluminiumBow bow = new AluminiumBow("R&G",30,37);
                    Archer archer = new SeniorArcher(names[r.nextInt(names.length)],r.nextBoolean(),r.nextInt(40)+12,bow,r.nextInt(8)+2,0);
                    club.addArcher(archer);
                }
                else{
                    CarbonBow bow = new CarbonBow("ZeusBows",40,42);
                    Archer archer = new VeteranArcher(names[r.nextInt(names.length)],r.nextBoolean(),r.nextInt(40)+12,bow,r.nextInt(40)+10,0);
                    club.addArcher(archer);
                }
            }
            else{
                CarbonBow bow = new CarbonBow("R&G",30,37);
                Archer archer = new VeteranArcher(names[r.nextInt(names.length)],r.nextBoolean(),r.nextInt(40)+12,bow,r.nextInt(40)+10,0);
                club.addArcher(archer);
            }
        }

        club.startTournament();
    }
}
