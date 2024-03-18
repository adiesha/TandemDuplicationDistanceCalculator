package org.msu.adiesha.utils;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

public class StabilizedPermutations {

    /**
     * This method will take two strings and create two stabilized permutations. however, the alphabet of the two strings
     * Should be the same. If they are not the same this method will assert false
     *
     * @param source source string
     * @param target target string
     * @return StabilizedPermutationDTO that contains the stabilized permutations
     */
    public static StabilizedPermsDTO getStabilizedPermutations(String source, String target) {
        assert Utils.checkAlphabet(source, target);
        // this ensures that the keys in the following maps are the same set (alphabet)
        // get the counts of source
        Map<Character, Integer> sourceCounts = new HashMap<>();
        updateCounts(sourceCounts, source);

        // get the counts of the target
        Map<Character, Integer> targetCounts = new HashMap<>();
        updateCounts(targetCounts, target);

        // for every character in the alphabet if counts are not equal, put the extra characters into the strings that
        // lacks them, append them next to the last occurrence of that character
        StringBuilder sourcesb = new StringBuilder(source);
        StringBuilder targetsb = new StringBuilder(target);

        for (Character character : sourceCounts.keySet()) {
            if (sourceCounts.get(character) > targetCounts.get(character)) {
                // since source contains more of character chars add extra to target
                int extra = sourceCounts.get(character) - targetCounts.get(character);
                targetsb.insert(targetsb.lastIndexOf(String.valueOf(character)), String.valueOf(character).repeat(extra));
            } else if (sourceCounts.get(character) < targetCounts.get(character)) {
                int extra = targetCounts.get(character) - sourceCounts.get(character);
                sourcesb.insert(sourcesb.lastIndexOf(String.valueOf(character)), String.valueOf(character).repeat(extra));
            } else {
                continue;
            }
        }

        StabilizedPermsDTO stabilizedPermsDTO = new StabilizedPermsDTO(sourcesb.toString(), targetsb.toString(),
                sourcesb.length() - source.length(), targetsb.length() - target.length());
        return stabilizedPermsDTO;

    }

    public static StabilizedPermsDTO getGeneralizedStabilizedPermutations(String source, String target) {
        Set<Character> alphabet = new HashSet<>();
        alphabet.addAll(List.of(ArrayUtils.toObject(source.toCharArray())));
        alphabet.addAll(List.of(ArrayUtils.toObject(target.toCharArray())));
        Map<Character, Integer> sourceCounts = new HashMap<>();
        alphabet.forEach(s -> sourceCounts.put(s, 0));
        updateCounts(sourceCounts, source);

        // get the counts of the target
        Map<Character, Integer> targetCounts = new HashMap<>();
        alphabet.forEach(s -> targetCounts.put(s, 0));
        updateCounts(targetCounts, target);

        // for every character in the alphabet if counts are not equal, put the extra characters into the strings that
        // lacks them, append them next to the last occurrence of that character
        StringBuilder sourcesb = new StringBuilder(source);
        StringBuilder targetsb = new StringBuilder(target);

        for (Character c : alphabet) {
            if (sourceCounts.get(c) > targetCounts.get(c)) {
                // since source contains more of character chars add extra to target
                int extra = sourceCounts.get(c) - targetCounts.get(c);
                // if c does not occur in target take the index of the source occurrence and put it there
                int lastIndex = targetsb.lastIndexOf(String.valueOf(c));
                if (lastIndex == -1) {
                    lastIndex = Math.min(sourcesb.lastIndexOf(String.valueOf(c)), targetsb.length());
                }
                targetsb.insert(lastIndex, String.valueOf(c).repeat(extra));
            } else if (sourceCounts.get(c) < targetCounts.get(c)) {
                int extra = targetCounts.get(c) - sourceCounts.get(c);
                int lastIndex = sourcesb.lastIndexOf(String.valueOf(c));
                if (lastIndex == -1){
                    lastIndex = Math.min(targetsb.lastIndexOf(String.valueOf(c)), sourcesb.length());
                }
                sourcesb.insert(lastIndex, String.valueOf(c).repeat(extra));
            } else {
                continue;
            }
        }

        StabilizedPermsDTO stabilizedPermsDTO = new StabilizedPermsDTO(sourcesb.toString(), targetsb.toString(),
                sourcesb.length() - source.length(), targetsb.length() - target.length());
        return stabilizedPermsDTO;
    }

    private static void updateCounts(Map<Character, Integer> characterCounts, String string) {
        Arrays.stream(ArrayUtils.toObject(string.toCharArray())).forEach(character -> {
            if (characterCounts.containsKey(character)) {
                characterCounts.put(character, characterCounts.get(character) + 1);
            } else {
                characterCounts.put(character, 1);
            }
        });
    }

    /**
     * This method takes two stabilized permutations and consider the source string as the identity permutation.
     * Then it will map the target string into permutation relative to the source permutation. The mothod will run a
     * check alphabet assertion before converting to permutations.
     *
     * @param stabilizedPermsDTO input should contain two stabilized strings in the DTO
     * @return stabilized
     */
    public static StabilizedPermsDTO mapStabilizedPerms(StabilizedPermsDTO stabilizedPermsDTO) {
        //
        assert Utils.checkAlphabet(stabilizedPermsDTO.source_stab, stabilizedPermsDTO.target_stab);
        String source = stabilizedPermsDTO.source_stab;
        // get the alphabet
        Set<Character> alphabetSource = new HashSet<>(List.of(ArrayUtils.toObject(source.toCharArray())));
        // create the count map
        Map<Character, SortedSet<Integer>> characterSetMap = new HashMap<>();
        // put a empty Integer set for each character
        alphabetSource.forEach(s -> characterSetMap.put(s, new TreeSet<>()));
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            // add the index to the set
            characterSetMap.get(c).add(i);
        }
        String target = stabilizedPermsDTO.target_stab;
        Integer[] targetPerm = new Integer[source.length()];
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            // read the character map and get an index and put it in the targetPerm
            SortedSet<Integer> indices = characterSetMap.get(c);
//            targetPerm[i] = indices.stream().toList().get(0);
            targetPerm[i] = indices.first();
            // then remove the index from the map
            indices.remove(targetPerm[i]);
        }
        Integer[] identityPerm = new Integer[source.length()];
        for (int i = 0; i < identityPerm.length; i++) {
            identityPerm[i] = i;
        }

        stabilizedPermsDTO.identityPerm = identityPerm;
        stabilizedPermsDTO.targetPerm = targetPerm;

        System.out.println(Arrays.toString(identityPerm));
        System.out.println(source);
        System.out.println(target);
        System.out.println(Arrays.toString(targetPerm));

        return stabilizedPermsDTO;
    }


    public static class StabilizedPermsDTO {
        public final String source_stab;
        public final String target_stab;

        public int source_additions = 0;
        public int target_reduction = 0;

        public Integer[] identityPerm;
        public Integer[] targetPerm;

        public StabilizedPermsDTO(String s1, String s2, int addition, int reduction) {
            this.source_stab = s1;
            this.target_stab = s2;
            this.source_additions = addition;
            this.target_reduction = reduction;

        }

        @Override
        public String toString() {
            return "StabilizedPermsDTO{" +
                    "source_stab='" + source_stab + '\'' +
                    ", target_stab='" + target_stab + '\'' +
                    '}';
        }
    }
}
