package mendelProblems;
import java.util.Arrays;

/*
 * You're given a list of coins of different values, and a total value
 * Find the minimum number of coins that get you the total value
 *
 * e.g. coins = [1, 5, 25], total = 32, answer = 4 (since 25 + 5 + 1 + 1 = 32)
 *
 * Do both tabulation and memoization.
 */
public class CoinsSoln {
    public static int minCoinsMemo(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount <= 0) return 0;

        int[] memo = new int[amount + 1];
        return minCoinsMemoHelper(coins, amount, memo);
    }

    private static int minCoinsMemoHelper(int[] coins, int rem, int[] memo) {
        if (rem < 0) return -1; // went over
        if (rem == 0) return 0; // just right
        if (memo[rem] != 0) return memo[rem]; // already computed

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = minCoinsMemoHelper(coins, rem - coin, memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        // assumes res won't actually be Integer.MAX_VALUE
        memo[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[rem];
    }

    public static int minCoinsTab(int[] coins, int amount) {
        if (amount <= 0) return 0;
        if (coins.length == 0) return -1;

        int[] tab = new int[amount + 1];
        Arrays.fill(tab, amount + 1);
        tab[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    tab[i] = Math.min(tab[i], tab[i - coin] + 1);
                }
            }
        }
        return (tab[amount] > amount) ? -1 : tab[amount];
    }
}
