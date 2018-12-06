package mendelProblems;
import java.util.Arrays;
import java.util.TreeSet;

/*
 * You have a row of N flower pots, laid out from pot 0 to pot N - 1
 * Each day, exactly one plant will go into bloom, and stay in bloom indefinitely
 * On day i, the flower in pot bloom[i] will bloom (bloom is an array of length N)
 *
 * A group is defined as a contiguous section of blooming flowers (that can not be extended on either side)
 * Ex: if N = 8, XX--XXXX, there are two groups: a group from 0-1, and a group from 4-7
 *
 * Given a number k, find the first day on which there is a group of exactly size k. If there is no such day, return -1
 *
 * Required: O(NlogN) time, O(N) space
 */
public class FlowerPotsSoln {
//    public static int findDay(int[] bloom, int k) {
//        int days = bloom.length;
//        if (k <= 0 || days < k)
//            return -1;
//        if (days == k)
//            return k - 1;
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i = 0; i < days; i++) {
//            set.add(bloom[i]);
//            if (i >= k - 1) {
//                for (int j = 0; j < days - k + 1; j++) {
//                    SortedSet<Integer> sub = set.subSet(j, j + k);
//                    if (sub.size() == k) {
//                        if ((sub.first() - 1 < 0 || !set.contains(sub.first() - 1)) && (sub.last() + 1 == days || !set.contains(sub.last() + 1))) {
//                            return i;
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }
    static class Group implements Comparable<Group> {
        int start;
        int end;

        Group(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Group grp) {
            return start - grp.start;
        }

        int size() {
            return end - start + 1;
        }
    }

    public static int findDay(int[] bloom, int k) {
        int days = bloom.length;
        if (k <= 0 || days < k)
            return -1;
        if (days == k)
            return k - 1;
        TreeSet<Group> set = new TreeSet<>();
        for (int i = 0; i < days; i++) {
            Group grp = new Group(bloom[i], bloom[i]);
            Group lower = set.lower(grp);
            Group higher = set.higher(grp);
            if (lower != null && lower.end == grp.start - 1 && higher != null && higher.start == grp.end + 1) { // merge groups
                Group merged = new Group(lower.start, higher.end);
                set.remove(lower);
                set.remove(higher);
                set.add(merged);
                if (merged.size() == k) {
                    return i;
                }
            } else if (lower != null && lower.end == grp.start - 1) { // extend group on right
                lower.end = bloom[i];
                if (lower.size() == k) {
                    return i;
                }
            } else if (higher != null && higher.start == grp.end + 1) { // extend group on left
                higher.start = bloom[i];
                if (higher.size() == k) {
                    return i;
                }
            } else { // add new group to set
                set.add(grp);
                if (grp.size() == k) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int findLastDay(int[] bloom, int k) {
        if (k <= 0 || bloom.length < k)
            return -1;
        if (bloom.length == k)
            return k - 1;
        int[] range = { 0, bloom.length -1 };
        return bloomOnDay(bloom, k, range) - 1;
    }

    private static int bloomOnDay(int[] bloom, int k, int[] range) {
        int groupSize = range[1] - range[0] + 1;
        if (groupSize < k || bloom.length == 0) {
            return 0;
        } else if (groupSize == k) {
            return bloom.length;
        } else {
            int pot = bloom[bloom.length - 1];
            int[] subBloom = Arrays.copyOfRange(bloom, 0, bloom.length - 1); // O(n^2)
            if (range[0] <= pot && pot <= range[1]) {
                int[] left = { range[0], pot - 1 };
                int[] right = { pot + 1, range[1] };
                return Math.max(bloomOnDay(subBloom, k, left), bloomOnDay(subBloom, k, right)); // O(2^n) -- bottleneck
            } else {
                range[1] = subBloom.length - 1;
                return bloomOnDay(subBloom, k, range);
            }
        }
    }
}