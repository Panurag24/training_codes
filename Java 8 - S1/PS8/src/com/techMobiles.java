package com;


import java.util.function.Consumer;

class Mobile {
    private int ram;
    private int storage;
    private int battery;
    private int camera;
    private String processor;
    private double screenSize;

    public Mobile(MobileBuilder builder) {
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.battery = builder.battery;
        this.camera = builder.camera;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
    }

    @Override
    public String toString() {
        return "Specifications - RAM: " + ram + " Storage: " + storage + " Battery: " + battery
                + "\nCamera: " + camera + "MP Processor: " + processor + " Display: " + screenSize + "''";
    }
}

class MobileBuilder {
    int ram;
    int storage;
    int battery;
    int camera;
    String processor;
    double screenSize;

    public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
        buildFields.accept(this);
        return this;
    }

    public Mobile createMobile() {
        return new Mobile(this);
    }
}

public class techMobiles {
    public static void main(String[] args) {
        // Create a Mobile using Builder pattern
        MobileBuilder builder = new MobileBuilder();
        Mobile mobile = builder.with(b -> {
            b.ram = 4;
            b.storage = 0;
            b.battery = 4000;
            b.camera = 12; // in MP
            b.processor = "A12 Bionic";
            b.screenSize = 0.000000; // in inches
        }).createMobile();

        // Print the specifications of the mobile
        System.out.println(mobile);
    }
}

