package com.usu;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Car car1 = new Car(new Engine());
        Car car2 = new Car(new V8Engine());

        car1.accelerate();
        car2.accelerate();
    }
}
