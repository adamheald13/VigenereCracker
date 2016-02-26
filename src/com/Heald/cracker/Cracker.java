package com.Heald.cracker;

import com.Heald.Cipher.Vigenere;

import java.util.ArrayList;
import java.util.HashSet;

public class Cracker {
    private HashSet<String> dictionary;

    public Cracker(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }

    public void crack(String ciphertext, int keyLength, int firstWordLength) {
        ArrayList<String> possiblePlaintexts = new ArrayList<String>();
        char[] key = new char[keyLength];
        for(int i = 0; i < Math.pow((double) 26, (double) keyLength); i++) {
            key = generateKey(key, keyLength);

            Vigenere.setKey(String.valueOf(key));
            String plaintext = Vigenere.crypt(ciphertext.substring(0, firstWordLength), false);

            if (dictionary.contains(plaintext)) {
                System.out.println("Recognized first word: " + plaintext );
                possiblePlaintexts.add(Vigenere.crypt(ciphertext, false));
            }
        }

        System.out.println("--- Possible plain texts ---");
        possiblePlaintexts.forEach(System.out::println);
    }

    private char[] generateKey(char[] key, int keyLength) {
        if(key[0] == 0) { //if the char array is empty, fill with initial aaa..
            for(int i = 0; i < keyLength; i++)
                key[i] = 'a';
        } else {
            int counter = 1;
            boolean haveIncremented = false;
            while (!haveIncremented) {
                if (key[keyLength - counter] == 'z') {
                    key[keyLength - counter] = 'a';
                } else {
                    int ascii = (int) key[keyLength - counter];
                    ascii++;
                    key[keyLength - counter] = (char) ascii;
                    haveIncremented = true;
                }
                counter++;
            }
        }
        return key;
    }
}
