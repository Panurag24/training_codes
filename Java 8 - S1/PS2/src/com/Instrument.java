package com;

interface Instrument {
    void play();
}

class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("Piano is playing tan tan tan tan");
    }
}

class Flute implements Instrument {
    @Override
    public void play() {
        System.out.println("Flute is playing toot toot toot toot");
    }
}

class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("Guitar is playing tin tin tin");
    }
}

