package Pizzeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements Serializable {
    private String name;
    private int weight;
    private int price;
    private List<Ingredient> ingredients;

    public Pizza(String name, int price, List<Ingredient> ingredients){
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        calculateWeight();
    }

    public Pizza(String name, int price){
        this.name = name;
        this.price = price;
        ingredients = new ArrayList<>();
    }

    private void calculateWeight(){
        weight = 0;
        for(var ing: ingredients)
            weight += ing.getWeight();
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        weight =+ ingredient.getWeight();
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
