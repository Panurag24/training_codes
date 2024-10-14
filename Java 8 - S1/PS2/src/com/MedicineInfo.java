package com;

import java.util.Random;

interface MedicineInfo {
    void displayLabel();
}

class Tablet implements MedicineInfo {
    @Override
    public void displayLabel() {
        System.out.println("Tablet: Store in a cool dry place");
    }
}

class Syrup implements MedicineInfo {
    @Override
    public void displayLabel() {
        System.out.println("Syrup: Shake well before use");
    }
}

class Ointment implements MedicineInfo {
    @Override
    public void displayLabel() {
        System.out.println("Ointment: For external use only");
    }
}

