package com;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

class Persons implements Comparable<Person> {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Persons(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Persons persons = (Persons) obj;
        return id == persons.id &&
                age == persons.age &&
                Double.compare(persons.salary, salary) == 0 &&
                Objects.equals(name, persons.name);
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.id, o.id);
    }

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
}

public class TestPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        // Add some sample persons
        persons.add(new Person(1, "Jerry", 12, 999.0));
        persons.add(new Person(2, "Smith", 22, 2999.0));
        persons.add(new Person(3, "Popeye", 21, 5999.0));
        persons.add(new Person(4, "Jones", 22, 6999.0));
        persons.add(new Person(5, "John", 32, 1999.0));
        persons.add(new Person(6, "Tom", 42, 3999.0));

        System.out.println("Choose an operation:");
        System.out.println("1. Print all the persons details using the Method Reference features.");
        System.out.println("2. Print all the persons details by sorting the names in ascending order using Comparator.");
        System.out.println("3. Print all the persons details by sorting the names in descending order using Comparator.");
        System.out.println("4. Print all the persons details whose age is greater than 25 using the Predicate build-in functional.");
        System.out.println("5. Print the id, name and salary of each person using the Consumer build-in functional interface.");
        System.out.println("6. Print all the names of person in Uppercase using the Function build-in functional interface.");
        System.out.println("7. Print the names and salary of each person after applying the appraisal of 10% using the ToDoubleFunction build-in functional interface.");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                persons.forEach(System.out::println);
                break;
            case 2:
                persons.stream()
                        .sorted(Comparator.comparing(Person::getName))
                        .forEach(System.out::println);
                break;
            case 3:
                persons.stream()
                        .sorted(Comparator.comparing(Person::getName).reversed())
                        .forEach(System.out::println);
                break;
            case 4:
                Predicate<Person> ageGreaterThan25 = person -> person.getAge() > 25;
                persons.stream()
                        .filter(ageGreaterThan25)
                        .forEach(System.out::println);
                break;
            case 5:
                Consumer<Person> printDetails = person -> System.out.println("Id: " + person.getId() + ", Name: " + person.getName() + ", Salary: " + person.getSalary());
                persons.forEach(printDetails);
                break;
            case 6:
                Function<Person, String> toUpperCase = person -> person.getName().toUpperCase();
                persons.stream()
                        .map(toUpperCase)
                        .forEach(System.out::println);
                break;
            case 7:
                ToDoubleFunction<Person> applyAppraisal = person -> person.getSalary() * 1.1;
                persons.stream()
                        .forEach(person -> System.out.println("Name: " + person.getName() + ", Salary after appraisal: " + applyAppraisal.applyAsDouble(person)));
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
}

