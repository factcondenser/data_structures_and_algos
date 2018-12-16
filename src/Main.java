import java.util.*;
import ctciCh1.StringsAndArrays;
import mendelProblems.*;

public class Main {
    public static void main(String[] args) {
        // ctci 1.3
        char[] input13 = "Mr John Smith    ".toCharArray();
        StringsAndArrays.replaceSpaces(input13, 13);
        System.out.println(input13);
        // ctci 1.4
        String input14 = "tact coa";
        Boolean output14 = StringsAndArrays.isPalindromePermutation(input14);
        System.out.println(output14);
        // ctci 1.5
        String[][] input15 = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bae"}};
        ArrayList<Boolean> results15 = new ArrayList<>();
        for (String[] arr : input15) {
            results15.add(StringsAndArrays.oneEditAway(arr[0], arr[1]));
        }
        String output15 = Arrays.toString(results15.toArray());
        System.out.println(output15);
        // ctci 1.6
        String input16 = "aabcccccaaa";
        String output16 = StringsAndArrays.compressString(input16);
        System.out.println(output16);
        // ctci 1.7
        int[][] input17 = new int[5][5];
        int num17 = 0;
        for (int r = 0; r < input17.length; r++) {
            for (int c = 0; c < input17.length; c++) {
                input17[r][c] = num17++;
            }
        }
        StringsAndArrays.rotateMatrix(input17);
        System.out.println(Arrays.deepToString(input17));
        // ctci 1.8
        int[][] input18 = new int[5][5];
        int num18 = 1;
        for (int r = 0; r < input18.length; r++) {
            for (int c = 0; c < input18.length; c++) {
                input18[r][c] = num18++;
            }
        }
        input18[2][2] = 0;
        StringsAndArrays.nullifyRowsAndCols(input18);
        System.out.println(Arrays.deepToString(input18));
        // ctci 1.9
        String[] inputs19 = { "abcdefg", "cdefgab", "abcdefga", "cdefgba" };
        Boolean[] outputs19 = new Boolean[inputs19.length];
        for (int i = 0; i < inputs19.length; i++) {
            outputs19[i] = StringsAndArrays.isRotation("abcdefg", inputs19[i]);
        }
        System.out.println(Arrays.toString(outputs19));
        // flower pots first day
        int[] bloomF = { 3, 5, 6, 1, 4, 0, 2 };
        int[] kFarr = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        ArrayList<Integer> firstDay = new ArrayList<>();
        for (int k : kFarr) {
            firstDay.add(FlowerPotsSoln.findDay(bloomF, k));
        }
        System.out.println(Arrays.toString(firstDay.toArray()));
        // flower pots last day
        int[] bloomL = { 3, 5, 6, 1, 4, 0, 2 };
        int[] kLarr = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        ArrayList<Integer> lastDay = new ArrayList<>();
        for (int k : kLarr) {
            lastDay.add(FlowerPotsSoln.findLastDay(bloomL, k));
        }
        System.out.println(Arrays.toString(lastDay.toArray()));
        // num paths
        System.out.println(NumPathsSoln.numPathsMemo(4, 4));
        System.out.println(NumPathsSoln.numPathsTab(4,4));
        boolean[][] grid = {
                { false, true, false, false },
                { false, false, false, false },
                { true, false, true, false },
                { false, false, false, false }
        };
        System.out.println(NumPathsSoln.numPathsWithBlocks(grid));
        // coins
        int[] coins = { 1, 5, 25 };
        System.out.println(CoinsSoln.minCoinsMemo(coins, 32));
        System.out.println(CoinsSoln.minCoinsTab(coins, 32));
        // house robber
        int[] houseMons = { 1, 2, 4, 0, 3, 6, 0, 5 };
        System.out.println(HouseRobberSoln.robMemo(houseMons));
        System.out.println(HouseRobberSoln.robTab(houseMons));
        // edit string
        System.out.println(EditDistanceSoln.minDistanceMemo("horse", "ros"));
        System.out.println(EditDistanceSoln.minDistanceTab("horse", "ros"));
        // bst
        // trie
        Trie trie = new Trie();
        trie.add("absolve");
        System.out.println(trie.contains("absolve"));
        trie.add("absolute");
        System.out.println(trie.contains("absolute"));
        trie.add("effect");
        System.out.println(trie.contains("effect"));
        trie.add("effective");
        System.out.println(trie.contains("effective"));
        trie.add("efficient");
        System.out.println(trie.contains("efficient"));
        trie.add("elegant");
        System.out.println(trie.contains("elegant"));
        trie.printSorted();
    }
}
