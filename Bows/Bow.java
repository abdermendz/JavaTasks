package SoloTry.Bows;

public abstract class Bow {

    String producer;
    double weight;
    double drawWeight;

    public Bow(String producer, double weight, double drawWeight) {
        this.producer = producer;
        this.weight = weight;
        if(drawWeight < getMinDrawWeight() || drawWeight> getMaxDrawWeight()){
            this.drawWeight = getAvg();
        }
        else{
            this.drawWeight = drawWeight;
        }
    }

    protected abstract double getAvg();
    protected abstract double getMinDrawWeight();
    protected abstract double getMaxDrawWeight();

    @Override
    public String toString() {
        return "Bow{" +
                "producer='" + producer + '\'' +
                ", weight=" + weight +
                ", drawWeight=" + drawWeight +
                '}';
    }
}
