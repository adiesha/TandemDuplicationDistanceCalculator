package org.msu.adiesha.utils;

public class LCS {
    public static char[] lcs(String source, String target, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        // Following steps build L[m+1][n+1] in bottom up
        // fashion. Note that L[i][j] contains length of LCS
        // of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (source.charAt(i - 1) == target.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j],
                            L[i][j - 1]);
            }
        }

        // Following code is used to print LCS
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index];


        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same,
            // then current character is part of LCS
            if (source.charAt(i - 1) == target.charAt(j - 1)) {
                // Put current character in result
                lcs[index - 1] = source.charAt(i - 1);

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }

        // Print the lcs
        System.out.print("LCS of " + source + " and " + target
                + " is ");
        for (int k = 0; k < temp; k++)
            System.out.print(lcs[k]);
        System.out.println();
        return lcs;
    }
}
