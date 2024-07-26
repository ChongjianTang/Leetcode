package leetcode.p19.p1940;

import java.util.*;

public class LongestCommonSubsequence {
    /**
     * Jun 07, 2024 14:33
     *
     */
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrays[0].length; i++) {
            set.add(arrays[0][i]);
            list.add(arrays[0][i]);
        }
        for (int i = 1; i < arrays.length; i++) {
            Set<Integer> nextSet = new HashSet<>();
            List<Integer> nextList = new ArrayList<>();
            for (int j = 0; j < arrays[i].length; j++) {
                if (set.contains(arrays[i][j])) {
                    nextSet.add(arrays[i][j]);
                    nextList.add(arrays[i][j]);
                }
            }
            set = new HashSet<>(nextSet);
            list = new ArrayList<>(nextList);
        }
        return list;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        int[][] arrays;
        List<Integer> expected = new ArrayList<>();

        arrays = new int[2][];
        arrays[0] = new int[]{1, 3, 4};
        arrays[1] = new int[]{1, 4, 7, 9};

        expected.add(1);
        expected.add(4);

        System.out.println(expected.equals(l.longestCommonSubsequence(arrays)));
    }
}
