package com.example.hw29.coffee.order;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class CoffeeOrderBoard {
    private ArrayList<Order> orders;
    private int number = 0;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
    }

    public boolean add(String orderName) {
        if (isNull(orderName)) {
            log.info("No order name! Returning false.");
            return false;
        }

        Order newOrder = new Order(orderName, number);
        orders.add(newOrder);
        number++;

        log.info("New order created! Name: " + orderName + ". Returning true");
        return true;
    }

    public Order deliver() {
        Order order = orders.get(0);
        orders.remove(order);
        log.info("Order delivered.");
        return order;
    }

    public Order deliver(int number) throws NullPointerException {
        Order order = findByNum(number);
        if (isNull(order)) {

            throw new NullPointerException("Такого заказа нет! Исключение выброшено. ");
        }
        orders.remove(order);
        return order;
    }

    public void showBoard() {
        log.info("Showing board content...");
        log.info("--------------");
        log.info("Имя  |  номер");
        log.info("--------------");
        for (Order order : orders) {
            order.showInfo();
        }
    }

    private <T> boolean isNull(T obj) {
        if (obj == null) {
            log.info("Object is Null");
            return true;
        }
        log.info("Object is not Null");
        return false;
    }

    private Order findByNum(int number) {
        for (Order order : orders) {
            if (order.getNumber() == number) {
                log.info("Order found by num: " + number);
                return order;
            }
        }
        log.info("Order is not found by num: " + number + " returning null");
        return null;
    }

}
