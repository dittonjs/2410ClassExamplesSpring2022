package com.usu;

public class Car {
    Engine myEngine;
    public Car (Engine engine) {
        myEngine = engine;
    }

    public void accelerate() {
        myEngine.injectFuel();
    }
}
