package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

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

        // 3. feladat
        System.out.println("3. feladat: " + Election.getSzavazatok().size() + " polgár szavazott.");

        // 4. feladat
        Scanner scanner = new Scanner(System.in);
        System.out.print("4. feladat: Kérek egy induló szervezetet: ");
        String szervezet = scanner.nextLine();
        System.out.println(szervezet.toUpperCase() + " " + Election.szamlalo(szervezet) + " szavazatot kapott.");

        // 5. feladat

        debugger();
    }
}