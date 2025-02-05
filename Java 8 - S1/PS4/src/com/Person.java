package com;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

class Person implements Comparable<Person> {
    int id;
    private String name;
    int age;
    private double salary;

    public Person(int id, String name, int age, double salary) {
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
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.id, o.id);
    }

    public static void main(String[] args) {
        TreeSet<Person> persons = new TreeSet<>();
        persons.add(new Person(1, "Jerry", 12, 999.0));
        persons.add(new Person(2, "Smith", 22, 2999.0));
        persons.add(new Person(3, "Popeye", 21, 5999.0));
        persons.add(new Person(4, "Jones", 22, 6999.0));
        persons.add(new Person(5, "John", 32, 1999.0));
        persons.add(new Person(6, "Tom", 42, 3999.0));

        // 1. Print all persons details using Method Reference
        System.out.println("1. All persons details:");
        persons.forEach(System.out::println);

        // 2. Print all persons details by sorting the names in ascending order using Comparator
        System.out.println("\n2. Persons sorted by name (ascending):");
        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        // 3. Print all persons details by sorting the names in descending order using Comparator
        System.out.println("\n3. Persons sorted by name (descending):");
        persons.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);

        // 4. Print all persons details whose age is greater than 25 using Predicate
        System.out.println("\n4. Persons whose age is greater than 25:");
        Predicate<Person> ageGreaterThan25 = person -> person.getAge() > 25;
        persons.stream()
                .filter(ageGreaterThan25)
                .forEach(System.out::println);

        // 5. Print the id, name, and salary of each person using Consumer
        System.out.println("\n5. Id, Name, and Salary of each person:");
        Consumer<Person> printDetails = person -> System.out.println("Id: " + person.getId() + ", Name: " + person.getName() + ", Salary: " + person.getSalary());
        persons.forEach(printDetails);

        // 6. Print all names of person in Uppercase using Function
        System.out.println("\n6. Names of persons in Uppercase:");
        Function<Person, String> toUpperCase = person -> person.getName().toUpperCase();
        persons.stream()
                .map(toUpperCase)
                .forEach(System.out::println);

        // 7. Print names and salary of each person after applying 10% appraisal using ToDoubleFunction
        System.out.println("\n7. Names and Salary after 10% appraisal:");
        ToDoubleFunction<Person> applyAppraisal = person -> person.getSalary() * 1.10;
        persons.stream()
                .forEach(person -> System.out.println("Name: " + person.getName() + ", Salary after appraisal: " + applyAppraisal.applyAsDouble(person)));
    }

    // Getters
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

