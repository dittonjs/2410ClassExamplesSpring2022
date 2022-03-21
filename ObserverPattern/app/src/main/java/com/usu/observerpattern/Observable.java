package com.usu.observerpattern;

import java.util.ArrayList;

public abstract class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    public interface Observer {
        public void notify(Observable observable);
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe() {

    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.notify(this));
    }
}
