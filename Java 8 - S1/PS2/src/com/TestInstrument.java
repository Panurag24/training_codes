package com;

public class TestInstrument {
	public static void main(String[] args) {
	    Instrument[] instruments = new Instrument[10];
	    instruments[0] = new Piano();
	    instruments[1] = new Flute();
	    instruments[2] = new Guitar();

	    for (int i = 0; i < instruments.length; i++) {
	        System.out.println("Checking instrument at index " + i + ": " + instruments[i]);
	        if (instruments[i] instanceof Piano) {
	            System.out.println("Instrument at index " + i + " is a Piano");
	        } else if (instruments[i] instanceof Flute) {
	            System.out.println("Instrument at index " + i + " is a Flute");
	        } else if (instruments[i] instanceof Guitar) {
	            System.out.println("Instrument at index " + i + " is a Guitar");
	        }
	        if (instruments[i] != null) {
	            instruments[i].play();
	        }
	    }
	}

}