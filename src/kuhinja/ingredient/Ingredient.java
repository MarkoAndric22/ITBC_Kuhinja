package kuhinja.ingredient;


import kuhinja.Priceable;

public abstract class Ingredient implements Priceable {
    private static int count = 0;

    private final int id;
    private String name;

    public Ingredient(String name) {
        this.id = count++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
