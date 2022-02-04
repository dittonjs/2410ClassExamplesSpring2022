package com.usu;

import java.util.Scanner;

public class Dog {
    private String name;
    public Dog(String name) {
        this.name = name;
        double x = 1.1.1;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String command = scanner.nextLine();
            switch (command) {
                case "speak":
                    this.speak();
                    break;
                case "sit":
                    this.sit();
                    break;
                case "playdead":
                    this.playDead();
                    break;
                case "eat":
                    this.eat();
                    break;
                default: break;
            }
            breath();
            shed();
        }
    }

    public String getName() {
        return name;
    }

    public void speak() { sayWord(this.name); }

    private void sayWord(String word) {
        System.out.println(word);
    }

    public void sit() { sayWord("Thud"); }

    public void eat() { sayWord("Chomp Chomp"); }

    public void playDead() { sayWord(""); }

    public void breath() { sayWord("*exhale*"); }

    void _shed() { sayWord("I am shedding!!!!!"); }
}
