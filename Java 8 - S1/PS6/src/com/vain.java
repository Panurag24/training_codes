package com;

import java.util.ArrayList;
import java.util.List;

public class vain {
    public static void main(String[] args) {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 318.65, 10.0));
        stocks.add(new Stock("MSFT", 166.86, 45.0));
        stocks.add(new Stock("Google", 99.0, 12.5));
        stocks.add(new Stock("AMZ", 1866.74, 45.0));
        stocks.add(new Stock("G00GL", 1480.2, 3.5));
        stocks.add(new Stock("AAPL", 318.65, 8.0));
        stocks.add(new Stock("AMZ", 1866.74, 9.0));

        // 1. Print all stocks details using forEach and Method Reference
        System.out.println("1 All stocks details:");
        stocks.forEach(System.out::println);

        // 2. Print all stocks details whose symbol is AMZ using generic filter method
        System.out.println("\n2 Stocks with symbol AMZ:");
        List<Stock> amzStocks = StockFilters.filter(stocks, stock -> stock.getSymbol().equals("AMZ"));
        amzStocks.forEach(System.out::println);

        // 3. Print all stocks details whose price is above 300 using generic filter method
        System.out.println("\n3 Stocks with price above 300:");
        List<Stock> highPriceStocks = StockFilters.filter(stocks, stock -> stock.getPrice() > 300);
        highPriceStocks.forEach(System.out::println);
    }
}
