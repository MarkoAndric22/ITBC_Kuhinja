package kuhinja.ingredient;

public class WeightedIngredient extends Ingredient {

    private double weight;
    private double pricePerUnit;

    public WeightedIngredient(String name, double weight, double pricePerUnit) {
        super(name);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public double getPrice() {
        return weight * pricePerUnit;
    }

    @Override
    public String toString() {
        return "WeightedIngredient{" +
                "weight=" + weight +
                ", pricePerUnit=" + pricePerUnit +
                "} " + super.toString();
    }
}
