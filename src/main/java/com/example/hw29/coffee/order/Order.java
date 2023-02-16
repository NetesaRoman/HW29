package com.example.hw29.coffee.order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Order {
    private String name;
    private int number;

    public Order(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void showInfo() {
        log.info(name + " | " + number);
    }

    public int getNumber() {
        return number;
    }
}
