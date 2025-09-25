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
            String sor = scanner.nextLine().trim();
            szavazatok.add(sor);
        }

        if (!szavazatok.isEmpty()) {
           return "adatok tárolva";
        } else {
            return "az adatokat nem sikerült beolvasni";
        }
    }
}
