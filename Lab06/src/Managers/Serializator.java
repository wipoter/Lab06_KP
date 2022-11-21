package Managers;

import Pizzeria.Order;
import Pizzeria.Pizzaria;

import java.io.*;

public class Serializator {
    public static void serialization(Pizzaria pizzaria) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(pizzaria);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static Pizzaria deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("data.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Pizzaria pizzaria = (Pizzaria) objectInputStream.readObject();
        objectInputStream.close();
        setMaxNumber(pizzaria);
        return pizzaria;
    }

    private static void setMaxNumber(Pizzaria pizzaria){
        if(pizzaria.getOrders().size() != 0) {
            var max = pizzaria.getOrders().stream().max((entry1, entry2) -> entry1.getNumber() > entry2.getNumber() ? 1 : -1).get();
            Order.setNumberAll(max.getNumber());
        }
        else Order.setNumberAll(0);
    }
}
