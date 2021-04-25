package com.treeleaf.task;

public class CharacterShift {
    public static String setNextCharacter(String str) {
        StringBuilder shiftedString = new StringBuilder();
        // Used this similar technique to convert lowercase letter to upper case in c++ ,

        /**
         * ASCII Codes for English letters
         * A - 65, Z - 90
         * a - 97, z - 122
         */
        // get the ASCII value of char and increment it by 1
        for (int i = 0; i < str.length(); i++) {
            int asciiCode = (int) str.charAt(i);
            asciiCode += 1;
            // for lowercase, check if value exceeds 'z' & set it to a
            asciiCode = asciiCode > 122 ? 97 : asciiCode;
            // for lowercase, check if value exceeds 'z' and set it to A
            asciiCode = asciiCode > 90 && asciiCode < 97 ? 65 : asciiCode;
            shiftedString.append((char) asciiCode);
        }
        return shiftedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(setNextCharacter("ACKKKZZklzaabdfdfr"));
        System.out.println(setNextCharacter("Hello"));

    }
}
