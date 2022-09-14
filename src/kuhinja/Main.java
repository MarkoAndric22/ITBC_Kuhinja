package kuhinja;

import kuhinja.fridge.Fridge;
import kuhinja.ingredient.WeightedIngredient;
import kuhinja.recipe.Recipe;
import kuhinja.recipe.WeightOfRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeightedIngredient ingredient1=new WeightedIngredient("banana",3,30);
        WeightedIngredient ingredient2=new WeightedIngredient("cokolada",0.100,120);
        WeightedIngredient ingredient3=new WeightedIngredient("kikiriki",0.50,72);
        WeightedIngredient ingredient4=new WeightedIngredient("hleb",1,45);
        WeightedIngredient ingredient5=new WeightedIngredient("sir",0.500,413);
        WeightedIngredient ingredient6=new WeightedIngredient("secer",2,90);
        WeightedIngredient ingredient7=new WeightedIngredient("jaje",10,15);
        WeightedIngredient ingredient8=new WeightedIngredient("slag",0.200,86);
        WeightedIngredient ingredient9=new WeightedIngredient("pecenica",0.700,263);
        WeightedIngredient ingredient10=new WeightedIngredient("brasno",2,78);
        WeightedIngredient ingredient11=new WeightedIngredient("mleko",1,125);
        WeightedIngredient ingredient12=new WeightedIngredient("so",1,150);
        WeightedIngredient ingredient13=new WeightedIngredient("caj",1,65);
        WeightedIngredient ingredient14=new WeightedIngredient("kafa",0.200,103);
        WeightedIngredient ingredient15=new WeightedIngredient("voda",1,55);

        List<WeightedIngredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient5);
        ingredients.add(ingredient6);
        ingredients.add(ingredient7);
        ingredients.add(ingredient8);
        ingredients.add(ingredient9);
        ingredients.add(ingredient10);
        ingredients.add(ingredient11);
        ingredients.add(ingredient12);
        ingredients.add(ingredient13);
        ingredients.add(ingredient14);
        ingredients.add(ingredient15);


        Fridge fridge = new Fridge(ingredients);
        fridge.addIngredient(ingredient10);

        Recipe recipe1 = new Recipe("torta", WeightOfRecipe.PRO);
        recipe1.addIngredient(new WeightedIngredient("slag",0.200,86));
        recipe1.addIngredient(new WeightedIngredient("mleko",0.300,125));
        recipe1.addIngredient(new WeightedIngredient("secer",0.500,90));
        recipe1.addIngredient(new WeightedIngredient("jaje",2,15));
        Recipe recipe2 = new Recipe("sendvic", WeightOfRecipe.BEGINNER);
        recipe2.addIngredient(new WeightedIngredient("kecap",1,145));
        recipe2.addIngredient(new WeightedIngredient("sir",0.200,413));
        recipe2.addIngredient(new WeightedIngredient("pecenica",0.100,26));
        Recipe recipe3 = new Recipe("caj", WeightOfRecipe.EASY);
        recipe3.addIngredient(new WeightedIngredient("caj",1,65));
        recipe3.addIngredient(new WeightedIngredient("voda",0.100,55));
        Recipe recipe4 = new Recipe("musaka", WeightOfRecipe.HARD);
        recipe4.addIngredient(new WeightedIngredient("krompir",0.600,68));
        recipe4.addIngredient(new WeightedIngredient("meso",0.300,250));
        recipe4.addIngredient(new WeightedIngredient("luk",1,20));
        recipe4.addIngredient(new WeightedIngredient("jaje",1,15));
        Recipe recipe5 = new Recipe("palacinke", WeightOfRecipe.MEDIUM);
        recipe5.addIngredient(new WeightedIngredient("jaje",2,15));
        recipe5.addIngredient(new WeightedIngredient("mleko",0.400,125));
        recipe5.addIngredient(new WeightedIngredient("brasno",0.400,78));
        recipe5.addIngredient(new WeightedIngredient("ulje",0.100,129));
        Recipe recipe6 = new Recipe("smuti", WeightOfRecipe.EASY);
        recipe6.addIngredient(new WeightedIngredient("banana",1,30));
        recipe6.addIngredient(new WeightedIngredient("mleko",0.100,125));
        Recipe recipe7 = new Recipe("kikiriki", WeightOfRecipe.BEGINNER);
        recipe7.addIngredient(new WeightedIngredient("kikiriki",0.50,72));
        recipe7.addIngredient(new WeightedIngredient("so",0.010,150));
        Recipe recipe8 = new Recipe("salata", WeightOfRecipe.PRO);
        Recipe recipe9 = new Recipe("pica", WeightOfRecipe.PRO);
        Recipe recipe10 = new Recipe("kafa", WeightOfRecipe.EASY);
        recipe10.addIngredient(new WeightedIngredient("kafa",0.200,103));
        recipe10.addIngredient(new WeightedIngredient("voda",1,55));

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);
        recipes.add(recipe5);
        recipes.add(recipe6);
        recipes.add(recipe7);
        recipes.add(recipe8);
        recipes.add(recipe9);
        recipes.add(recipe10);

        Scanner sc = new Scanner(System.in);
        System.out.println("""
                1. Dodaj namirnice u frizider
                2. Izbrisi namirnice iz frizidera
                3. Koja se jela mogu napraviti sa namirnicama iz frizidera
                4. Provera koja sve skalirana jela moze da napravi (skaliranje za 50%)
                5. Pravljenje jela (kao iznad)
                6. Provera koja sve jela mogu da se naprave za x dinara
                7. Provera koja su sve jela x tezine recepta
                8. Kombinacija 6. и 7. uslova
                9. Korisnik moze da sortira recepte po tezini
                10. Korisnik moze da sortira recepte po ceni""");
        int unos = sc.nextInt();
        switch (unos){
            case 1:
                fridge.addIngredient(ingredient1);
                System.out.println(fridge.getWeightedIngredients());
                break;
            case 2:
                fridge.removeIngredient(ingredient10);
                System.out.println(fridge.getWeightedIngredients());
                break;
            case 3:
                List<Recipe> recipeList = new ArrayList<>();
                for (var r : recipes){
                    if(fridge.ifMealCanMake(r)){
                        recipeList.add(r);
                    }
                }
                System.out.println(recipeList);
                break;
            case 4:
                List<Recipe> rec = new ArrayList<>();
                for (var r : recipes){
                    if(fridge.ifMealCanMake(r.getScaledRecipe(50))){
                        rec.add(r);
                    }
                }
                System.out.println(rec);
                break;
            case 5:
                fridge.makeMeal(recipe10);
                System.out.println(recipe10.getWeightedIngredients());
                break;
            case 6:
                List<Recipe> meals = new ArrayList<>();
                double cena = 50;
                for (var recipe: recipes){
                    if (cena >= recipe.getPrice()) {
                        meals.add(recipe);
                    }
                }
                System.out.println(meals);
                break;
            case 7:
                List<Recipe> mealList = new ArrayList<>();
                WeightOfRecipe tezina = WeightOfRecipe.EASY;
                for (var recipe: recipes){
                    if (tezina == recipe.getWeightOfRecipe()) {
                        mealList.add(recipe);
                    }
                }
                System.out.println(mealList);
            break;
            case 8:
                List<Recipe> mealList1 = new ArrayList<>();
                WeightOfRecipe tezina1 = WeightOfRecipe.EASY;
                double cena1 = 50;
                for (var recipe: recipes){
                    if (tezina1 == recipe.getWeightOfRecipe() && cena1 >= recipe.getPrice()) {
                        mealList1.add(recipe);
                    }
                }
                System.out.println(mealList1);
                break;
            case 9:
                System.out.println(Recipe.sortByWeight(recipes));
                break;
            case 10:
                System.out.println(Recipe.sortByPrice(recipes));break;
            default:
        }
    }
}
