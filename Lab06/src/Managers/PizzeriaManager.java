package Managers;

import Pizzeria.Customer;
import Pizzeria.Order;
import Pizzeria.Pizzaria;

import java.util.*;
import java.util.stream.Collectors;

public class PizzeriaManager {

    private static Pizzaria pizzaria;

    public static void addPizzeria(Pizzaria pizzaria){
        PizzeriaManager.pizzaria = pizzaria;
    }

    public static void addOrder(Customer customer, Order order){
        pizzaria.addOrder(order);
        pizzaria.getCustomers().stream()
                .filter( c -> (c.getName().equals(customer.getName()) && c.getSurname().equals(customer.getSurname()))).
                collect(Collectors.toList()).get(0).addOrder(order);
    }

    public static void Choise() {
        int choice = 0;
        while (true) {

            System.out.println("1) Замовлення за часом доставки");
            System.out.println("2) Список адресів більше 2 піц");
            System.out.println("3) Кількість користувачів на піцу");
            System.out.println("4) Найбільша к-сть піц");
            System.out.println("5) Перелік піц та  список  їх  замовників");
            System.out.println("6) Не виконаних замовлень на  цей  час");
            System.out.println("7) Вихід");

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            switch (choice) {
                case (1):
                    sort();
                    break;
                case (2):
                    moreThanTwo();
                    break;
                case (3):
                    amountOfCustomersOnPizza();
                    break;
                case(4):
                    amountOfMaxPizza();
                    break;
                case (5):
                    collectionOfPizzasAndCustomers();
                    break;
                case(6):
                    extensionOrdersList();
                    break;
                case (7):
                    return;
                default:
                    System.out.println("Введіть правильне число!");
                    break;
            }
        }
    }

    private static void sort() {
        List<Order> list = pizzaria.getOrders().stream().sorted(
                Comparator.comparing(Order::getMinutes)).collect(Collectors.toList());
        for (var item : list)
            System.out.println(item.getNumber() + " - " + item.getMinutes());
    }
    private static void moreThanTwo(){
        List<Order> list = pizzaria.getOrders().stream()
                .filter(o -> o.getPizzas().size() > 2)
                .collect(Collectors.toList());
        for (var item: list)
            System.out.println(item.getAddress() + " - " + item.getPizzas().size());
    }
    private static void amountOfCustomersOnPizza(){
        System.out.print("Введіть назву піци: ");
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int amount = (int) pizzaria.getCustomers().stream()
                .filter(c -> c.getOrders().stream()
                        .anyMatch(o -> o.getPizzas().stream()
                                .anyMatch(p -> p.getName().equals(str)))).count();

        System.out.println(str + " - "  + amount);
    }
    private static void amountOfMaxPizza(){
        var list = pizzaria.getCustomers();
        for (var customer: list){
            Map<String, Integer> pizzaMap = new HashMap<>();
            var orders = customer.getOrders();
            for(var order: orders){
                var pizzas = order.getPizzas();
                for(var pizza: pizzas){
                    if(!pizzaMap.containsKey(pizza.getName()))
                        pizzaMap.put(pizza.getName(), 1);
                    else
                        pizzaMap.put(pizza.getName(), pizzaMap.get(pizza.getName())+ 1);
                }
            }
            var max = pizzaMap.entrySet().stream()
                    .max((e1,e2) -> e1.getValue() > e2.getValue()? 1: -1)
                    .get();
            System.out.println(customer.getName() + " " + customer.getSurname() + ": " + max.getKey() + " - " + max.getValue());
        }
    }
    private static Boolean isInList(List<String> list, Customer customer){
        var l = list.stream()
                .filter(c -> c.equals(new String(customer.getName() + " " + customer.getSurname())))
                .collect(Collectors.toList());
        return l.size() != 0;
    }
    private static void collectionOfPizzasAndCustomers(){
        var list = pizzaria.getCustomers();
        Map<String, List<String>> pizzaMap = new HashMap<>();
        for (var customer: list){
            var orders = customer.getOrders();
            for(var order: orders){
                var pizzas = order.getPizzas();
                for(var pizza: pizzas){
                    if(!pizzaMap.containsKey(pizza.getName())){
                        List<String> tmpListOfCustomers = new ArrayList<>();
                        tmpListOfCustomers.add(new String(customer.getName() + " " + customer.getSurname()));
                        pizzaMap.put(pizza.getName(), tmpListOfCustomers);
                    }
                    else {
                        var tmpListOfCustomers = pizzaMap.get(pizza.getName());
                        if(!isInList(tmpListOfCustomers, customer)) {
                            tmpListOfCustomers.add(new String(customer.getName() + " " + customer.getSurname()));
                            pizzaMap.put(pizza.getName(), tmpListOfCustomers);
                        }
                    }
                }
            }
        }
        for(var item: pizzaMap.entrySet()){
            System.out.println(item.getKey() + ":");
            for(var values: item.getValue()){
                System.out.println("\t" + values);
            }
            System.out.println();
        }
    }
    private static void extensionOrdersList(){
        var orders = pizzaria.getOrders().stream().filter(o -> !o.isReady()).collect(Collectors.toList());
        for(var order: orders){
            System.out.println("Замовлення номер: " + order.getNumber() + "\n" + "Час протермінування: " + order.getMinuteOfExtension());
            System.out.println();
        }
    }
}
