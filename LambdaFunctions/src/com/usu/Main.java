package com.usu;


interface MyInterface {
    public void doThing();
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        int x = 10;
        doWork(() -> {

        });
    }

    public static void doWork(MyInterface callback) {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callback.doThing();
            System.out.println(x);
        }).start();
    }
}
