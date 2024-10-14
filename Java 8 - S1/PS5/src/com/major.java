package com;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collectors.*;
import java.util.Set;
import java.util.stream.Collectors;

class Person {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Person(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters for all fields

    public int getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	

	public int getAge() {
		return age;
	}

	

	public double getSalary() {
		return salary;
	}

	

	@Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

public class major {
    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();
        persons.add(new Person(1, "Jerry", 12, 999.0));
        persons.add(new Person(2, "Smith", 22, 2999.0));
        persons.add(new Person(3, "Popeye", 21, 5999.0));
        persons.add(new Person(4, "Jones", 22, 6999.0));
        persons.add(new Person(5, "John", 32, 1999.0));
        persons.add(new Person(6, "Tom", 42, 3999.0));

        // 1. Print all the persons details using the Streams and Method Reference features.
        System.out.println("1. Print all the persons details:");
        persons.forEach(System.out::println);

        // 2. Print all the persons details by sorting the id in ascending order using Comparable and Streams.
        System.out.println("\n2. Print all the persons details by sorting the id in ascending order:");
        persons.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getId(), p2.getId()))
                .forEach(System.out::println);

        // 3. Print all the persons details by sorting the name in ascending order using Comparator and Streams.
        System.out.println("\n3. Print all the persons details by sorting the name in ascending order:");
        persons.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);

        // 4. Print all the persons details by sorting the names in descending order using Comparator and Streams.
        System.out.println("\n4. Print all the persons details by sorting the names in descending order:");
        persons.stream()
                .sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
                .forEach(System.out::println);

        // 5. Print all the persons details whose Name start with J using Streams.
        System.out.println("\n5. Print all the persons details whose Name start with J:");
        persons.stream()
                .filter(p -> p.getName().startsWith("J"))
                .forEach(System.out::println);

        // 6. Print the count number of persons using Streams.
        System.out.println("\n6. Number of persons: " + persons.size());

        // 7. Print the Max salary among all persons using Streams.
        System.out.println("\n7. Max salary among all persons: " +
                persons.stream().mapToDouble(Person::getSalary).max().orElse(0));

        // 8. Print the Min salary among all persons using Streams.
        System.out.println("\n8. Min salary among all persons: " +
                persons.stream().mapToDouble(Person::getSalary).min().orElse(0));

        // 9. Print the average of all salaries using Streams.
        System.out.println("\n9. Average salary of all persons: " +
                persons.stream().mapToDouble(Person::getSalary).average().orElse(0));

        // 10. Print the sum of all salaries using Streams.
        System.out.println("\n10. Sum of all salaries: " +
                persons.stream().mapToDouble(Person::getSalary).sum());

        // 11. Print the First Person whose Name start with J using Streams - filter and findFirst method.
        System.out.println("\n11. First person whose Name starts with J: " +
                persons.stream().filter(p -> p.getName().startsWith("J")).findFirst().orElse(null));

        // 12. Check whether all the persons age is greater than 10 using Streams – allMatch method.
        System.out.println("\n12. All persons age greater than 10? " +
                persons.stream().allMatch(p -> p.getAge() > 10));
        
     // 13. Check whether all the persons age is greater than 50 using Streams – noneMatch method
        boolean allAgesGreaterThan50 = persons.stream().noneMatch(p -> p.getAge() > 50);
        System.out.println("\n13 Are all persons age greater than 50? " + allAgesGreaterThan50);

        // 14. Print the average of all salaries using Streams and Collectors
        double averageSalaryCollectors = persons.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println("\n14 Average salary using Collectors: " + averageSalaryCollectors);

        // 15. Print all the persons details group by salary using Streams and Collectors
        System.out.println("\n15 Persons group by salary using Collectors:");
        Map<Double, List<Person>> personsBySalary = persons.stream().collect(Collectors.groupingBy(Person::getSalary));
        personsBySalary.forEach((salary, list) -> {
            System.out.println("Salary: " + salary);
            list.forEach(System.out::println);
        });

        // 16. Print all the names after joining whose age is greater than 18 using Streams and Collectors
        System.out.println("\n16 Names of persons whose age is greater than 18:");
        String namesOfPersons = persons.stream().filter(p -> p.getAge() > 18).map(Person::getName).collect(Collectors.joining(", "));
        System.out.println(namesOfPersons);

        // 17. Print the Min, Max, Count, Average and Sum of all persons using Statistics and Collectors
        DoubleSummaryStatistics salaryStatistics = persons.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("\n17 Salary Statistics:");
        System.out.println("Min: " + salaryStatistics.getMin());
        System.out.println("Max: " + salaryStatistics.getMax());
        System.out.println("Count: " + salaryStatistics.getCount());
        System.out.println("Average: " + salaryStatistics.getAverage());
        System.out.println("Sum: " + salaryStatistics.getSum());

        // 18. Determine the oldest person among all using Streams and Reduce
        Optional<Person> oldestPerson = persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println("\n18 Oldest Person: " + oldestPerson.orElse(new Person(0, "", 0, 0)));

        // 19. Add n number of multiple records and print the time taken with sequential using stream
        long startTimeSequential = System.nanoTime();
        // Add n number of multiple records here
        long endTimeSequential = System.nanoTime();
        long timeTakenSequential = endTimeSequential - startTimeSequential;
        System.out.println("\n19 Time taken with Sequential Stream: " + timeTakenSequential + " nanoseconds");

        // 20. Print the time taken with parallel using parallelStream
        long startTimeParallel = System.nanoTime();
        // Add n number of multiple records here
        long endTimeParallel = System.nanoTime();
        long timeTakenParallel = endTimeParallel - startTimeParallel;
        System.out.println("20 Time taken with Parallel Stream: " + timeTakenParallel + " nanoseconds");
    }
}

