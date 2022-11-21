import Managers.PizzeriaManager;
import Managers.Serializator;
import Pizzeria.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Deserialization
        Pizzaria pizzaria = Serializator.deserialization();


        //Pizzaria pizzaria = new Pizzaria();

        /*Pizza pizza = new Pizza("Салямі", 150);
        pizza.addIngredient(new Ingredient("Томатний соус", 200));
        pizza.addIngredient(new Ingredient("Помідор", 100));
        pizza.addIngredient(new Ingredient("Салямі", 100));
        pizza.addIngredient(new Ingredient("Шампіньйони", 50));
        pizza.addIngredient(new Ingredient("Сир моцарела", 300));
        pizzaria.addPizza(pizza);*/

        /*Customer customer = new Customer("Дмитро", "Сущик");
        Customer customer1 = new Customer("Владислав", "Аторін");
        Customer customer2 = new Customer("Олександр", "Черненко");
        Customer customer3 = new Customer("Олег", "Сівак");
        pizzaria.addCustomer(customer);
        pizzaria.addCustomer(customer1);
        pizzaria.addCustomer(customer2);
        pizzaria.addCustomer(customer3);*/

        /*Order order = new Order("Чуприкни 45");
        order.addPizza(pizzaria.getPizzas().get(1));
        order.addPizza(pizzaria.getPizzas().get(3));
        order.addPizza(pizzaria.getPizzas().get(0));

        PizzeriaManager.addPizzeria(pizzaria);

        PizzeriaManager.addOrder(pizzaria.getCustomers().get(3), order);

        //Serialization
        Serializator.serialization(pizzaria);*/



        PizzeriaManager.addPizzeria(pizzaria);

        PizzeriaManager.Choise();
    }
}