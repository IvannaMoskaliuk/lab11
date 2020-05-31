/*
 * Classname Main
 *
 * Version info 1
 *
 * Copyright Moskaliuk Ivanna KNUTE
 */
package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String harry = new String(Files.readAllBytes(Paths.get("C:\\java\\" +
                "lab11\\harry.txt")));

        String harryCleaned = harry.replaceAll("[^a-zA-Z0-9 ]", "");
        String[] harryWords = harryCleaned.split(" ");
        String[] harryLines = harry.split("\\n");


        //---------------------------
        // 1. Find the longest word in the above text.
        String longestWord = "";
        for (int i = 0; i < harryWords.length; i++) {
            if ( harryWords[i].length() > longestWord.length()){
                longestWord = harryWords[i];
            }
        }
        System.out.println("Найдовше слово у тексті - " + longestWord);

        //---------------------------
        // 2. Count the LINES where the word "Harry" is met.
        int counter = 0;
        for (int i = 0; i < harryLines.length; i++) {
            if (harryLines[i].contains("Harry")) {
                counter++;
            }
        }
        System.out.println("Слово Гаррі зустрічається у " + counter +
                " рядках.");

        //---------------------------
        // 3.Take the array of distinct words from Harry Potter.
        // Create an array of hashes.
        String distinktString = "";
        for (int i = 0; i < harryWords.length; i++) {
            if ( !distinktString.contains(harryWords[i])) {
                distinktString += harryWords[i] + " ";
            }
        }
        String[] distinktArray = distinktString.split(" ");
        System.out.println( "Всього слів у тексті - " + harryWords.length);
        System.out.println( "Distinct words - " + distinktArray.length);

        Integer[] hashArray = new Integer[distinktArray.length];
        for (int i = 0; i < distinktArray.length; i++) {
            hashArray[i] = distinktArray[i].hashCode();
            //System.out.println(distinktArray[i] + " " + hashArray[i]);
        }

        //---------------------------
        // 4. Count the intersections of hashes.
        for (int i = 0; i < hashArray.length; i++) {
            counter = 0;
            for (int j = i+1; j < hashArray.length; j++) {
                if ( hashArray[j] != null) {
                    if ( hashArray[i] == hashArray[j] ) {
                        counter ++;
                        hashArray[j] = null;
                    }
                }
            }
            if ( counter != 0){
                System.out.println( "Хеші перетинаються - " + hashArray[i] +
                        " - " + counter);
            }
        }
        System.out.println(counter);
    }
}
