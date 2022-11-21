package Pizzeria;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Order implements Serializable {
    private static int numberAll = 0;
    private int number;
    private String address;
    private int minutes;
    private boolean isReady;
    private int minuteOfExtension;
    private List<Pizza> pizzas;

    public Order(String address){
        this.number = ++numberAll;
        this.address = address;
        int min = 40;
        int max = 100;
        int diff = max - min;
        pizzas = new ArrayList<>();
        Random random = new Random();
        minutes = ThreadLocalRandom.current().nextInt(40, 100);
        isReady = random.nextBoolean();
        if(!isReady)
            minuteOfExtension = ThreadLocalRandom.current().nextInt(1, 10);
    }

    public Order(String address, List<Pizza> pizzas){
        this.number = ++numberAll;
        this.address = address;
        this.pizzas = pizzas;
        int min = 40;
        int max = 100;
        int diff = max - min;
        Random random = new Random();
        minutes = random.nextInt(diff + 1);
        isReady = true;
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void setNumberAll(int number) {
        Order.numberAll = number;
    }

    public int getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isReady() {
        return isReady;
    }

    public int getMinuteOfExtension() {
        return isReady? 0 : minuteOfExtension;
    }
}
