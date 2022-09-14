package kuhinja.recipe;

import kuhinja.ingredient.WeightedIngredient;
import kuhinja.Priceable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Recipe implements Priceable{
    private String name;
    private WeightOfRecipe weightOfRecipe;
    private List<WeightedIngredient> weightedIngredients;

    public Recipe(String name, WeightOfRecipe weightOfRecipe) {
        this.name = name;
        this.weightOfRecipe = weightOfRecipe;
        this.weightedIngredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeightOfRecipe getWeightOfRecipe() {
        return weightOfRecipe;
    }

    public void setWeightOfRecipe(WeightOfRecipe weightOfRecipe) {
        this.weightOfRecipe = weightOfRecipe;
    }

    public List<WeightedIngredient> getWeightedIngredients() {
        return weightedIngredients;
    }

    public void setWeightedIngredients(List<WeightedIngredient> weightedIngredients) {
        this.weightedIngredients = weightedIngredients;
    }

    @Override
    public double getPrice() {
        double sum =0;
        for (WeightedIngredient ingredient: weightedIngredients){
            sum+=ingredient.getPrice();
        }
        return sum;
    }

    public void addIngredient(WeightedIngredient ingredient){
        weightedIngredients.add(ingredient);
    }

    public void deleteIngredient(WeightedIngredient ingredient){
        weightedIngredients.remove(ingredient);
    }

    public Recipe getScaledRecipe(double x){
        double decimal = x / 100;
        for (var ingredients: weightedIngredients){
            ingredients.setWeight( Math.round (decimal*ingredients.getWeight()));
        }
        return this;
    }

    public static List<Recipe> sortByWeight(List<Recipe> list){
        list.sort(Comparator.comparing(Recipe::getWeightOfRecipe));
        return list;
    }

    public static List<Recipe> sortByPrice(List<Recipe> list){
        list.sort(Comparator.comparing(Recipe::getPrice));
        return list;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", weightOfRecipe=" + weightOfRecipe +
                ", weightedIngredients=" + weightedIngredients +
                "}\n";
    }
}
