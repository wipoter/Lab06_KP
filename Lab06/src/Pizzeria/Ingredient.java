package Pizzeria;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private int weight;

    public Ingredient(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
