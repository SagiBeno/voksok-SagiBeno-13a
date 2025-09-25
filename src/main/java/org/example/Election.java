package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Election {
    private static void debugger() {
        int i = 0;
    }

    public static List<String> szavazatok = new ArrayList<>();

    public static List<String> getSzavazatok() {
        return szavazatok;
    }

    public static void setSzavazatok(List<String> szavazatok) {
        Election.szavazatok = szavazatok;
    }

    public static String readfile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String sor = scanner.nextLine();
            szavazatok.add(sor);
        }

        if (!szavazatok.isEmpty()) {
           return "adatok tárolva";
        } else {
            return "az adatokat nem sikerült beolvasni";
        }
    }

    public static int szamlalo(String szervezet) {
        int szavazatokSzama = 0;

        for (String szervezetek : getSzavazatok()) {
            if (szervezetek.equalsIgnoreCase(szervezet)) {
                szavazatokSzama++;
            }
        }
        return szavazatokSzama;
    }


    public static String szazalek() {
        List<String> szevezetekEgyszer = new ArrayList<>();

        for (String szervezet : getSzavazatok()) {
            if (!szevezetekEgyszer.contains(szervezet)){
                szevezetekEgyszer.add(szervezet);
            }
        }

        int[] szavazatiSzamok = new int[szevezetekEgyszer.size()];

        for (int i = 0; i < szevezetekEgyszer.size(); i++) {
            for (String szavazat : getSzavazatok()) {
                if (szevezetekEgyszer.get(i).equals(szavazat)) {
                    szavazatiSzamok[i] += 1;
                }
            }
        }

        double[] szazalekok = new double[szevezetekEgyszer.size()];

        for (int i = 0; i < szavazatiSzamok.length; i++) {
            szazalekok[i] = (double) szavazatiSzamok[i] / getSzavazatok().size() * 100;
        }

        String[][] szervezetEsSzazalek = new String[szazalekok.length][2];
        for (int i = 0; i < szevezetekEgyszer.size(); i++) {
            szervezetEsSzazalek[i][0] = szevezetekEgyszer.get(i);
            szervezetEsSzazalek[i][1] = String.valueOf(String.format("%.2f",szazalekok[i]));
        }

        String[][] nagyasagrend = new String[1][1];
        for (int i = 0; i < szervezetEsSzazalek.length - 1; i++) {
            if (szazalekok[i] < szazalekok[i + 1] ) {
                nagyasagrend[0] = szervezetEsSzazalek[i];
                szervezetEsSzazalek[i] = szervezetEsSzazalek[i + 1];
                szervezetEsSzazalek[i + 1] = nagyasagrend[0];
            }
        }

        String kiiras = "";
        for (int i = 0; i < szervezetEsSzazalek.length; i++) {
            kiiras += "\n" + szervezetEsSzazalek[i][0] + "  " + szervezetEsSzazalek[i][1] + "%";
        }

        return kiiras;

    }
}
