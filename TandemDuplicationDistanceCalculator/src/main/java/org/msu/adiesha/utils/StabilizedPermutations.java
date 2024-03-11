package org.msu.adiesha.utils;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StabilizedPermutations {

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

    private static void updateCounts(Map<Character, Integer> characterCounts, String string) {
        Arrays.stream(ArrayUtils.toObject(string.toCharArray())).forEach(character -> {
            if (characterCounts.containsKey(character)) {
                characterCounts.put(character, characterCounts.get(character) + 1);
            } else {
                characterCounts.put(character, 1);
            }
        });
    }

    public static class StabilizedPermsDTO {
        public final String source_stab;
        public final String target_stab;

        public int source_additions = 0;
        public int target_reduction = 0;

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
