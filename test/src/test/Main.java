package test;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        List<String> cities = new ArrayList<>(Arrays.asList("Las Vegas", "Los Angeles", "Chicago", "New York"));
        System.out.println(cities.stream()
                                 .peek(c -> System.out.println(c))
                                 .anyMatch(c -> c.contains("y") == false));
    }
}
