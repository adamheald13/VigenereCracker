package com.Heald;

import com.Heald.cracker.Cracker;

import java.io.*;
import java.util.HashSet;

public class Main {

    private static HashSet<String> dictionary;
    private static int dictionarySize;

    public static void main(String[] args) throws IOException {
        readDictionary();
        Cracker cracker = new Cracker(dictionary);
        long start = System.currentTimeMillis();

        System.out.println("First message");
        cracker.crack("MSOKKJCOSXOEEKDTOSLGFWCMCHSUSGX", 2, 6);
        System.out.println("Time to complete was " + (System.currentTimeMillis() - start) + " milliseconds\n");

        System.out.println("Second message");
        cracker.crack("OOPCULNWFRCFQAQJGPNARMEYUODYOUNRGWORQEPVARCEPBBSCEQYEARAJUYGWWYACYWBPRNEJBMDTEAEYCCFJNENSGWAQRTSJTGXNRQRMDGFEEPHSJRGFCFMACCB", 3, 7);
        System.out.println("Time to complete was " + (System.currentTimeMillis() - start) + " milliseconds\n");

        System.out.println("Third message");
        cracker.crack("MTZHZEOQKASVBDOWMWMKMNYIIHVWPEXJA", 4, 10);
        System.out.println("Time to complete was " + (System.currentTimeMillis() - start) + " milliseconds\n");

        System.out.println("Fourth message");
        cracker.crack("HUETNMIXVTMQWZTQMMZUNZXNSSBLNSJVSJQDLKR", 5, 11);
        System.out.println("Time to complete was " + (System.currentTimeMillis() - start) + " milliseconds\n");

        System.out.println("Fifth message");
        cracker.crack("LDWMEKPOPSWNOAVBIDHIPCEWAETYRVOAUPSINOVDIEDHCDSELHCCPVHRPOHZUSERSFS", 6, 9);
        System.out.println("Time to complete was " + (System.currentTimeMillis() - start) + " milliseconds\n");
    }

    private static void readDictionary() throws IOException {
        String currentLine;
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("C:\\Users\\heeal\\IdeaProjects\\VigenereCracker\\src\\com\\Heald\\dict.txt"));

        dictionarySize = countLines("C:\\Users\\heeal\\IdeaProjects\\VigenereCracker\\src\\com\\Heald\\dict.txt");

        dictionary = new HashSet<String>();
        for(int i = 0; i < dictionarySize; i++) {
            currentLine = reader.readLine();
            dictionary.add(currentLine);
        }
    }

    public static int countLines(String filename) throws IOException { //code adapted from martinus at http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count + 1;
        } finally {
            is.close();
        }
    }
}
