package SoloTry.Bows;

public class WoodenBow extends Bow {

    private static final int MIN_WOODEN_BOW_DRAW_WEIGHT = 20;
    private static final int MAX_WOODEN_BOW_DRAW_WEIGhHT = 30;


    public WoodenBow(String producer, double weight, double drawWeight) {
        super(producer, weight, drawWeight);
    }

    @Override
    protected double getAvg() {
        return (MIN_WOODEN_BOW_DRAW_WEIGHT+ MAX_WOODEN_BOW_DRAW_WEIGhHT)/2;
    }

    @Override
    protected double getMinDrawWeight() {
        return MIN_WOODEN_BOW_DRAW_WEIGHT;
    }

    @Override
    protected double getMaxDrawWeight() {
        return MAX_WOODEN_BOW_DRAW_WEIGhHT;
    }
}
