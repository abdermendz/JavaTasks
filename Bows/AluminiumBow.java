package SoloTry.Bows;

public class AluminiumBow extends Bow {

    private static final int MIN_ALUM_BOW_DRAW_WEIGHT = 25;
    private static final int MAX_ALUM_BOW_DRAW_WEIGHT = 40;


    public AluminiumBow(String producer, double weight, double drawWeight) {
        super(producer, weight, drawWeight);
    }

    @Override
    protected double getAvg() {
        return (MIN_ALUM_BOW_DRAW_WEIGHT + MAX_ALUM_BOW_DRAW_WEIGHT)/2;
    }

    @Override
    protected double getMinDrawWeight() {
        return  MIN_ALUM_BOW_DRAW_WEIGHT;
    }

    @Override
    protected double getMaxDrawWeight() {
        return MAX_ALUM_BOW_DRAW_WEIGHT;
    }
}
