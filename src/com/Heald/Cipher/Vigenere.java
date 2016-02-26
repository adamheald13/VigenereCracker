package com.Heald.Cipher;

import java.util.HashMap;
import java.util.Map;

public class Vigenere {
    private static String key;

    public static String crypt(String plaintext, boolean encrypt) {
        plaintext = plaintext.replace(" ", "");
        char[] charArray = plaintext.toCharArray();
        int[] intArray = textToInts(plaintext.replace(" ", ""));
        int[] keyInts = textToInts(key.replace(" ", ""));

        //do the encryption/decryption
        int keyIndex = 0;
        for(int i = 0; i < charArray.length; i++) {
            int temp;
            if(encrypt) {
                temp = (intArray[i] + keyInts[keyIndex]) % 26;
            }
            else {
                temp = (intArray[i] - keyInts[keyIndex]) % 26;
            }

            if(temp < 0)
                temp += 26;

            char replacementChar = intToCharMap.get(temp);
            charArray[i] = replacementChar;

            keyIndex++;
            if(keyIndex >= key.length()) {
                keyIndex = 0;    //go back to the start of the key
            }
        }

        return String.valueOf(charArray);
    }

    public static int[] textToInts(String plaintext) {
        int[] intArray = new int[plaintext.length()];

        for(int i = 0; i < plaintext.length(); i++) {
            intArray[i] = charToIntMap.get(plaintext.charAt(i));
        }

        return intArray;
    }

    public static void setKey(String key) {
        Vigenere.key = key.replace(" ", "");
    }

    public static final Map<Character, Integer> charToIntMap;
    static {
        charToIntMap = new HashMap<>();
        charToIntMap.put('A', 0);
        charToIntMap.put('a', 0);
        charToIntMap.put('B', 1);
        charToIntMap.put('b', 1);
        charToIntMap.put('C', 2);
        charToIntMap.put('c', 2);
        charToIntMap.put('D', 3);
        charToIntMap.put('d', 3);
        charToIntMap.put('E', 4);
        charToIntMap.put('e', 4);
        charToIntMap.put('F', 5);
        charToIntMap.put('f', 5);
        charToIntMap.put('G', 6);
        charToIntMap.put('g', 6);
        charToIntMap.put('H', 7);
        charToIntMap.put('h', 7);
        charToIntMap.put('I', 8);
        charToIntMap.put('i', 8);
        charToIntMap.put('J', 9);
        charToIntMap.put('j', 9);
        charToIntMap.put('K', 10);
        charToIntMap.put('k', 10);
        charToIntMap.put('L', 11);
        charToIntMap.put('l', 11);
        charToIntMap.put('M', 12);
        charToIntMap.put('m', 12);
        charToIntMap.put('N', 13);
        charToIntMap.put('n', 13);
        charToIntMap.put('O', 14);
        charToIntMap.put('o', 14);
        charToIntMap.put('P', 15);
        charToIntMap.put('p', 15);
        charToIntMap.put('Q', 16);
        charToIntMap.put('q', 16);
        charToIntMap.put('R', 17);
        charToIntMap.put('r', 17);
        charToIntMap.put('S', 18);
        charToIntMap.put('s', 18);
        charToIntMap.put('T', 19);
        charToIntMap.put('t', 19);
        charToIntMap.put('U', 20);
        charToIntMap.put('u', 20);
        charToIntMap.put('V', 21);
        charToIntMap.put('v', 21);
        charToIntMap.put('W', 22);
        charToIntMap.put('w', 22);
        charToIntMap.put('X', 23);
        charToIntMap.put('x', 23);
        charToIntMap.put('Y', 24);
        charToIntMap.put('y', 24);
        charToIntMap.put('Z', 25);
        charToIntMap.put('z', 25);
    }

    public static final Map<Integer, Character> intToCharMap;
    static {
        intToCharMap = new HashMap<>();
        intToCharMap.put(0, 'A');
        intToCharMap.put(1, 'B');
        intToCharMap.put(2, 'C');
        intToCharMap.put(3, 'D');
        intToCharMap.put(4, 'E');
        intToCharMap.put(5, 'F');
        intToCharMap.put(6, 'G');
        intToCharMap.put(7, 'H');
        intToCharMap.put(8, 'I');
        intToCharMap.put(9, 'J');
        intToCharMap.put(10, 'K');
        intToCharMap.put(11, 'L');
        intToCharMap.put(12, 'M');
        intToCharMap.put(13, 'N');
        intToCharMap.put(14, 'O');
        intToCharMap.put(15, 'P');
        intToCharMap.put(16, 'Q');
        intToCharMap.put(17, 'R');
        intToCharMap.put(18, 'S');
        intToCharMap.put(19, 'T');
        intToCharMap.put(20, 'U');
        intToCharMap.put(21, 'V');
        intToCharMap.put(22, 'W');
        intToCharMap.put(23, 'X');
        intToCharMap.put(24, 'Y');
        intToCharMap.put(25, 'Z');
    }
}
