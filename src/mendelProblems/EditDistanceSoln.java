package mendelProblems;
import java.util.Arrays;

/*
 * Challenge: Edit distance
 * You have two strings. You are allowed to delete a character from a string, insert a letter, or change one letter to another
 * What is the minimum number of operations to make one string equal to the other
 *
 * Do either tabulation or memoization. Getting this at all could be a challenge.
 *
 * O(mn) time and space
 *
 */
public class EditDistanceSoln {
    public static int minDistanceMemo(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return minDistanceMemoHelper(word1, 0, word2, 0, memo);
    }

    private static int minDistanceMemoHelper(String str, int strIdx, String target, int targetIdx, int[][] memo) {
        if (strIdx == str.length() && targetIdx == target.length()) return 0; // reached end of both strings
        if (strIdx == str.length()) return target.length() - targetIdx; // must insert remaining
        if (targetIdx == target.length()) return str.length() - strIdx; // must delete remaining
        if (memo[strIdx][targetIdx] != -1) return memo[strIdx][targetIdx];

        if (str.charAt(strIdx) == target.charAt(targetIdx)) { // just move on
            return minDistanceMemoHelper(str, strIdx + 1, target, targetIdx + 1, memo);
        }

        int min = Integer.MAX_VALUE;
        int replace = 1 + minDistanceMemoHelper(str, strIdx + 1, target, targetIdx + 1, memo); // try replace
        if (replace < min) min = replace;
        int insert = 1 + minDistanceMemoHelper(str, strIdx, target, targetIdx + 1, memo); // try insert
        if (insert < min) min = insert;
        int delete = 1 + minDistanceMemoHelper(str, strIdx + 1, target, targetIdx, memo); // try delete
        if (delete < min) min = delete;

        memo[strIdx][targetIdx] = min;
        return min;
    }

    /*
     * CARE
     * CANS
     *
     * X -  C  A  R  E
     * - 0  1  2  3  4
     * C 1  0  1 .2 .3
     * A 2  1  0  1  2
     * N 3  2  1  1  2
     * S 4  3  2  2  2
     *
     * MARS
     * STARTS
     *
     * X  -  M  A  R  S
     * -  0  1  2  3  4     top = insert
     * S  1  1  2  3  3     left = delete
     * T  2  2  2  3  4     top-left = replace
     * A  3  3  2  3  4
     * R  4  4  3  2  3
     * T  5  5  4  3  3
     * S  6  6  5  4  3
     *
     */
    public static int minDistanceTab(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int[][] tab = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            tab[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            tab[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    tab[i][j] = tab[i - 1][j - 1];
                } else {
                    int replace = 1 + tab[i - 1][j - 1];
                    int insert = 1 + tab[i - 1][j];
                    int delete = 1 + tab[i][j - 1];
                    tab[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return tab[word1.length()][word2.length()];
    }
}