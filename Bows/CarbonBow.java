package SoloTry.Bows;

public class CarbonBow extends Bow {

    private static final int MIN_CARBON_BOW_DRAW_WEIGHT = 28;
    private static final int MAX_CARBON_BOW_DRAW_WEIGT = 48;

    public CarbonBow(String producer, double weight, double drawWeight) {
        super(producer, weight, drawWeight);
    }

    @Override
    protected double getAvg() {
        return (MIN_CARBON_BOW_DRAW_WEIGHT+ MAX_CARBON_BOW_DRAW_WEIGT)/2;
    }

    @Override
    protected double getMinDrawWeight() {
        return MIN_CARBON_BOW_DRAW_WEIGHT;
    }

    @Override
    protected double getMaxDrawWeight() {
        return MAX_CARBON_BOW_DRAW_WEIGT;
    }
}
