//package mendelProblems;
//import java.util.*;
//
//public class Foo {
//
//}
//
//class Foo implements Comparable<Foo> {
//
//public int num;
//public char letter;
//
//public Foo(int num, char letter) {
//        this.num = num;
//        this.letter = letter;
//        }
//
//// Sort list by num, tiebreak using letter
//public static List<Foo> sortFoo(List<Foo> list) {
//        return Collections.sort(list);
//        }
//
//public int compareTo(Foo foo) {
//        if (this.num == foo.num)
//        return foo.letter - this.letter;
//        return foo.num - this.num;
//        }
//        }
//
//
//// Do not modify this class
//class Foo {
//
//    public int num;
//    public char letter;
//
//    public Foo(int num, char letter) {
//        this.num = num;
//        this.letter = letter;
//    }
//}
//
//class FooComparator extends Comparator<Foo> {
//    public int compare(Foo foo1, Foo foo2) {
//        if (foo1.num == foo2.num)
//            foo1.letter - foo2.letter;
//        foo1.num - foo2.num;
//    }
//}
//
//
//class Solution {
//
//    public static List<Foo> sort(List<Foo> list) {
//        fooComp = new FooComparator();
//        Collection.sort(list, fooComp);
//    }
//}
//
//
//class NextFinder {
//    // For each number in nums, get the smallest element in list that is greater than or equal to the number (or null if no such interface)
//    /* Ex: list = [10, 5, 15], nums = [4, 10, 11, 16]
//     * return [5, 10, 15, null]
//     *
//     * list.length = L, nums.length = N
//     *
//     * Nlog(L) + Llog(L)
//     * Do not implement a sort or binary search
//     *
//     * Try: https://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html
//     */
//    public List<Integer> findNext(List<Integer> list, List<Integer> nums) {
//        int[] result = new int[nums.length];
//        TreeSet<Integer> set = new TreeSet<Integer>();
//
//        for (Integer i : list) {
//            set.add(i);
//        }
//        for(int i = 0; i < nums.length; i++) {
//            result[i] = set.ceiling(nums[i]);
//        }
//        return result;
//    }
//}
//
//class NextFinder {
//    // For each number in nums, get the smallest element in list that is greater than or equal to the number (or null if no such interface)
//    /* Ex: list = [10, 5, 15], nums = [4, 10, 11, 16]
//     * return [5, 10, 15, null]
//     *
//     * list.length = L, nums.length = N
//     *
//     * Nlog(L) + Llog(L)
//     * Do not implement a sort or binary search
//     *
//     * Try: https://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html
//     */
//    public List<Foo> findNext(List<Foo list, List<Foo> foos) {
//        int[] result = new int[foos.length];
//        FooComparator fooComp = new FooComparator();
//        TreeSet<Foo> set = new TreeSet<Foo>(fooComp);
//
//        for (Foo foo : list) {
//            set.add(foo);
//        }
//        for(int i = 0; i < foos.length; i++) {
//            result[i] = set.ceiling(foos[i]);
//        }
//        return result;
//    }
//}
//
//// Foo class
//class Foo {
//    public Foo(int num, char letter);
//    public int num;
//    public char letter;
//}
//
//// FooComparator class
//class FooComparator implements Comparator<Foo> {
//    public FooComparator(){
//
//    }
//    public int compare(Foo foo1, Foo foo2) {
//        if (foo1.num == foo2.num)
//            return foo1.letter - foo2.letter;
//        return foo1.num - foo2.num;
//    }
//}
//
//
//
//// Foo class: CAN be modified
//class Foo {
//    public Foo(int num, char letter);
//    public int num;
//    public char letter;
//
//    public boolean equals(Object other) {
//        return this.num == other.num;
//    }
//
//    public int hashCode() {
//        return num;
//    }
//}
//
//class Object {
//
//    public boolean equals(Object other);
//    public int hashCode();
//
//}
//
//class Solution {
//
//    // Return the foos, where the num of each foo is unique (i.e. remove foos with duplicate nums)
//    // Tiebreak: use the foo that occurs later in the list
//    // ~10 lines
//    // O(N) time
//    public Set<Foo> condense(List<Foo> list) {
//        HashSet<Foo> set = new HashSet<Foo>();
//        Collections.reverse(list);
//        for (Foo foo : list) {
//            set.add(foo);
//        }
//        return set;
//    }
//}
//
//
//// Return the longest palindromic substring
//
//// RKABAGTA
//
//
//
//class Solution {
//    public String longestPalindrome(String s) {
////     String result = "";
//
////     for(int i = 0; i < s.length(); i++) {
////       for(int j = i; j <= s.length(); j++) {
////         String substr = s.substring(i, j)
////         if(isPalindrome(substr)) {
////           if(substr.length() > result.length()) {
////             result = substr;
////           }
////         }
////       }
////     }
////     return result;
//    }
//
//
//    // public boolean isPalindrome(String s) {
//    //   int start = 0;
//    //   int end = s.length() - 1;
//    //   while(start < end) {
//    // if(s.charAt(start) != s.charAt(end)) {
//    //       return false;
//    //     }
//    //     start++;
//    //     end--;
//    //   }
//    //   return true;
//    // }
//}