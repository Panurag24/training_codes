package com;

import java.util.Random;

public class TestMedicine {
    public static void main(String[] args) {
        MedicineInfo[] medicines = new MedicineInfo[10];
        Random rand = new Random();

        for (int i = 0; i < medicines.length; i++) {
            int type = rand.nextInt(3) + 1;
            switch (type) {
                case 1:
                    medicines[i] = new Tablet();
                    break;
                case 2:
                    medicines[i] = new Syrup();
                    break;
                case 3:
                    medicines[i] = new Ointment();
                    break;
            }
            medicines[i].displayLabel();
        }
    }
}
