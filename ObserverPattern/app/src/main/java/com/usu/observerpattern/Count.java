package com.usu.observerpattern;

public class Count extends Observable {
    private int count = 0;

    public void increment() {
        count ++;
        notifyObservers();
    }

    public void decrement() {
        count --;
        notifyObservers();
    }

    public int getCount() {
        return count;
    }
}
