package ctciCh1;
import java.util.*;

public class StringsAndArrays {
    // 1.3
    public static void replaceSpaces(char[] str, int trueLen) {
        int numSpaces = 0;
        for (int i = 0; i < trueLen; i++) {
            if (str[i] == ' ') {
                numSpaces++;
            }
        }

        int index = (trueLen + numSpaces * 2) - 1;
        for (int i = trueLen - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index -= 3;
            } else {
                str[index] = str[i];
                index--;
            }
        }
    }

    // 1.4
    public static boolean isPalindromePermutation(String str) {
        int numSpaces = 0;
        int[] charCounts = new int[128]; // assumes ASCII

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                numSpaces++;
            } else {
                charCounts[c]++;
            }
        }

        int numOdds = 0;
        boolean isEven = (str.length() - numSpaces) % 2 == 0;
        for (int num : charCounts) {
            if (num % 2 != 0) {
                numOdds++;
            }
            if ((isEven && numOdds > 0) || (!isEven && numOdds > 1)) {
                return false;
            }
        }
        return true;
    }

    // 1.5
    public static boolean oneEditAway(String s, String t) {
        int dif = s.length() - t.length();
        if (dif == 0) return oneReplaceAway(s, t);
        if (dif == -1) return oneInsertAway(s, t);
        if (dif == 1) return oneInsertAway(t, s);
        return false;
    }

    private static boolean oneReplaceAway(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }

    private static boolean oneInsertAway(String s1, String s2) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < s1.length() && idx2 < s2.length()) {
            if (s1.charAt(idx1) != s2.charAt(idx2)) {
                if (idx1 != idx2) return false;
                idx2++;
            } else {
                idx1++;
                idx2++;
            }
        }
        return true;
    }

    // 1.6
    public static String compressString(String s) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressed.append(s.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }
        return compressed.length() < s.length() ? compressed.toString() : s;
    }

    // 1.7
    public static void rotateMatrix(int[][] matrix) {
        if (matrix.length < 2)
            return;
        for (int r = 0; r < (matrix.length + 1) / 2; r++) {
            for (int c = r; c < matrix.length - 1 - r; c++) {
                rotatePosition(r, c, matrix);
            }
        }
    }

    private static void rotatePosition(int row, int col, int[][] matrix) {
        int tmp = matrix[row][col];
        for (int i = 0; i < 3; i++) {
            int newRow = matrix.length - 1 - col;
            int newCol = row;
            matrix[row][col] = matrix[newRow][newCol];
            row = newRow;
            col = newCol;
        }
        matrix[row][col] = tmp;
    }

    // 1.8
    public static void nullifyRowsAndCols(int[][] matrix) {
        ArrayList<Integer> nullRows = new ArrayList<>();
        ArrayList<Integer> nullCols = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    nullRows.add(r);
                    nullCols.add(c);
                }
            }
        }
        nullifyRows(nullRows, matrix);
        nullifyCols(nullCols, matrix);
    }

    private static void nullifyRows(ArrayList<Integer> nullRows, int[][] matrix) {
        for (Integer r : nullRows) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = 0;
            }
        }
    }

    private static void nullifyCols(ArrayList<Integer> nullCols, int[][] matrix) {
        for (Integer c : nullCols) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = 0;
            }
        }
    }

    // 1.9
    public static boolean isRotation(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;
        String twiceS = s + s;
        return twiceS.contains(t);
    }
}