package Pizzeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pizzaria implements Serializable {
    private List<Pizza> pizzas;
    private List<Order> orders;
    private List<Customer> customers;

    public Pizzaria(){
        pizzas = new ArrayList<>();
        orders = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public Pizzaria(List<Pizza> pizzas, List<Order> orders, List<Customer> customers) {
        this.pizzas = pizzas;
        this.orders = orders;
        this.customers = customers;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
}
