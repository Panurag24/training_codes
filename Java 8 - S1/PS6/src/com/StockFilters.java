package com;

import java.util.*;
import java.util.function.Predicate;

class Stock {
    private String symbol;
    private double price;
    private double units;

    public Stock(String symbol, double price, double units) {
        this.symbol = symbol;
        this.price = price;
        this.units = units;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public double getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Stock [symbol=" + symbol + ", price=" + price + ", units=" + units + "]";
    }
}

public class StockFilters {
    public static List<Stock> bySymbol(List<Stock> list, String symbol) {
        List<Stock> filteredData = new ArrayList<>();
        for (Stock stock : list) {
            if (stock.getSymbol().equals(symbol)) {
                filteredData.add(stock);
            }
        }
        return filteredData;
    }

    public static List<Stock> byPriceAbove(List<Stock> list, double price) {
        List<Stock> filteredData = new ArrayList<>();
        for (Stock stock : list) {
            if (stock.getPrice() > price) {
                filteredData.add(stock);
            }
        }
        return filteredData;
    }

    public static List<Stock> filter(List<Stock> list, Predicate<Stock> p) {
        List<Stock> filteredData = new ArrayList<>();
        for (Stock stock : list) {
            if (p.test(stock)) {
                filteredData.add(stock);
            }
        }
        return filteredData;
    }
}


