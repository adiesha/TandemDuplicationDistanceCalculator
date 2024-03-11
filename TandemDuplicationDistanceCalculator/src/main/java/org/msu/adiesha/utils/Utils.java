package org.msu.adiesha.utils;

import org.apache.commons.lang.ArrayUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

    public static boolean checkAlphabet(String source, String target) {
        Set<Character> alphabetSource = new HashSet<>(List.of(ArrayUtils.toObject(source.toCharArray())));
        Set<Character> alphabetTarget = new HashSet<>(List.of(ArrayUtils.toObject(target.toCharArray())));
        return alphabetSource.size() == alphabetTarget.size() && alphabetTarget.containsAll(alphabetSource);
    }
}
