package org.example;

import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static void debugger() {
        int i = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // 1. feladat
        System.out.println("1. feladat: Voksok");

        // 2. feladat
        Election.readfile("ForrasFileok/voksok.txt");
        System.out.println("2. feladat: adatok tárolva");
        debugger();
    }
}