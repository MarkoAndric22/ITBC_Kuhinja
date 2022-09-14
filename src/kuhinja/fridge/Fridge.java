package kuhinja.fridge;

import kuhinja.ingredient.WeightedIngredient;
import kuhinja.recipe.Recipe;

import java.util.List;

public class Fridge {
    private List<WeightedIngredient> weightedIngredients;

    public Fridge(List<WeightedIngredient> weightedIngredients) {
        this.weightedIngredients = weightedIngredients;
    }

    public Fridge() {
    }

    public List<WeightedIngredient> getWeightedIngredients() {
        return weightedIngredients;
    }

//    public void setWeightedIngredients(List<WeightedIngredient> weightedIngredients) {
//        this.weightedIngredients = weightedIngredients;
//    }

    public void addIngredient(WeightedIngredient ingredient){
        if (!weightedIngredients.contains(ingredient)){
            weightedIngredients.add(ingredient);
        }else {
            for (var i : weightedIngredients){
                if (i.getName().equals(ingredient.getName())){
                    i.setWeight(i.getWeight()+ingredient.getWeight());
                }
            }
        }

    }

    public void removeIngredient(WeightedIngredient ingredient){
        for (var i : weightedIngredients){
            if (ingredient.getWeight()<i.getWeight()){
                i.setWeight(i.getWeight()-ingredient.getWeight());
            }
            else if(ingredient.getWeight()>i.getWeight()){
                break;
            }
            else {
                weightedIngredients.remove(ingredient);
            }
        }
    }

    public boolean ifMealCanMake(Recipe recipe){
            for (var recipeIngredient: recipe.getWeightedIngredients()){
                for (var fridgeIngredient : weightedIngredients){
                    if(recipeIngredient.getWeight()<=fridgeIngredient.getWeight()){
                        return true;
                    }
            }
        }
    return false;
    }

    public void makeMeal(Recipe recipe){
        for (var recipeIngredient: recipe.getWeightedIngredients()){
            for (var fridgeIngredient : weightedIngredients){
                if(recipeIngredient.getWeight()<=fridgeIngredient.getWeight()){
                    fridgeIngredient.setWeight(fridgeIngredient.getWeight()-recipeIngredient.getWeight());
                    System.out.println(fridgeIngredient);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "weightedIngredients=" + weightedIngredients +
                '}';
    }
}
