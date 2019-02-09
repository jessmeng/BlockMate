package com.example.blockmate;

public class Transaction {
    final String name;
    final String blocks;
    final String cost;
    final String date;
    final String time;

    final boolean[] locations;

    Transaction(String name, String blocks, String cost, String date, String time, boolean[] locations) {
        this.name = name;
        this.blocks = blocks;
        this.cost = cost;
        this.date = date;
        this.time = time;
        this.locations = locations.clone();
    }
}
