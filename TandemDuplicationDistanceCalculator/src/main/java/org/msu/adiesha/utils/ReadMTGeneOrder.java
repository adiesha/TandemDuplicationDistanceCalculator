package org.msu.adiesha.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadMTGeneOrder {

    private static final Set<Character> allowedCharacters = Set.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    public static List<String> readGeneOrderFromCustomFiles(String filename) {
        List<String> output = new ArrayList<>();
        try {
            File readFile = new File(filename);
            Scanner reader = new Scanner(readFile);
            while (reader.hasNextLine()) {
                output.add(reader.nextLine());
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Exception");
            throw new RuntimeException(e);
        }

        return output;
    }


    public static Map<String, Character> assignCharsToStringList(List<String> list) {

        Character[] characters = allowedCharacters.toArray(new Character[allowedCharacters.size()]);

        int i = 0;
        Map<String, Character> stringCharacterMap = new HashMap<>();

        for (String s : list) {
            if (!stringCharacterMap.containsKey(s)) {
                stringCharacterMap.put(s, characters[i++]);
            } else {
                System.out.println(s + " was already found");
            }
        }

        return stringCharacterMap;
    }

    public static String getTheChangedOutput(List<String> geneOrder, Map<String, Character> map) {
//        if (geneOrder.size() > map.size()) {
//            System.err.println("Not enough characters");
//            assert false;
//        }

        StringBuilder outputBuffer = new StringBuilder();

        for (String s : geneOrder) {
            outputBuffer.append(map.get(s));
            if (!map.containsKey(s)) {
                System.out.println(s + " is not in the map");
            }
        }

        return outputBuffer.toString();

    }

    public static boolean checkWhetherStringsContainSameCharacters(String str1, String str2) {
        boolean result = true;
        Set<Character> characters1 = new HashSet<>();
        Set<Character> characters2 = new HashSet<>();
        for (Character c : str1.toCharArray()) {
            characters1.add(c);
        }
        for (Character c : str2.toCharArray()) {
            characters2.add(c);
        }

        return characters1.equals(characters2);

    }


}
