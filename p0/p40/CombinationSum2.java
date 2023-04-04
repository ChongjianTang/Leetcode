package leetcode.p0.p40;

import java.util.*;

public class CombinationSum2 {
    /**
     * This is the updated method from problem 39
     * TLE
     */
    public static List<List<Integer>> combinationSum21(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = helper(candidates, 0, target);
        if (result == null) {
            return new ArrayList<>();
        }
        return result;
    }

    public static List<List<Integer>> helper(int[] candidates, int start, int target) {
        if (target == 0) {
            return new ArrayList<>();
        }
        if (start == candidates.length || target < candidates[start]) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> temp2 = helper(candidates, start + 1, target - candidates[start]);
        if (temp2 != null) {
            if (temp2.size() == 0) {
                List<Integer> temp3 = new ArrayList<>();
                temp3.add(candidates[start]);
                temp2.add(temp3);
            } else {
                for (List<Integer> list : temp2) {
                    list.add(candidates[start]);
                }
            }
            for (List<Integer> list : temp2) {
                if (!result.contains(list)) {
                    result.add(list);
                }
            }
        }
        List<List<Integer>> temp1 = helper(candidates, start + 1, target);
        if (temp1 != null) {
            for (List<Integer> list : temp1) {
                if (!result.contains(list)) {
                    result.add(list);
                }
            }
        }
        if (result.size() == 0) {
            return null;
        }
        return result;
    }

    /**
     * Backtracking
     */
    public static List<List<Integer>> combinationSum22(int[] candidates, int target) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : candidates) {
            counter.merge(num, 1, Integer::sum);
        }

        int[] keys = new int[counter.size()];
        int i = 0;
        for (int key : counter.keySet()) {
            keys[i] = key;
            i++;
        }
        List<List<Integer>> results = new ArrayList<>();
        backtracking2(new ArrayList<>(), target, 0, 0, keys, counter, results);
        return results;
    }

    public static void backtracking2(List<Integer> comb, int remain, int curr, int num, int[] keys, HashMap<Integer, Integer> counter, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new ArrayList<>(comb));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = curr; i < keys.length; i++) {
            if (num != counter.get(keys[i])) {
                comb.add(keys[i]);
                backtracking2(comb, remain - keys[i], i, num + 1, keys, counter, results);
                comb.remove(comb.size() - 1);
            }
            num = 0;
        }
    }

    /**
     * Backtracking with index
     */
    public static List<List<Integer>> combinationSum23(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs3(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }


    public static void dfs3(int[] candidates, int remain, int curr, List<Integer> comb, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        if (remain < 0) {
            return;
        }
        if (curr == candidates.length) {
            return;
        }
        if (remain < candidates[curr]) {
            return;
        }
        comb.add(candidates[curr]);
        dfs3(candidates, remain - candidates[curr], curr + 1, comb, result);
        comb.remove(comb.size() - 1);
        int i = curr + 1;
        while (i < candidates.length && candidates[i] == candidates[i - 1]) {
            i++;
        }
        if (i == candidates.length) {
            return;
        }
        dfs3(candidates, remain, i, comb, result);
    }


    /**
     * Backtracking with index
     * Another way of recursion
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtracking4(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtracking4(int[] candidates, int target, int index, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target >= candidates[i]) {
                comb.add(candidates[i]);
                backtracking4(candidates, target - candidates[i], i + 1, comb, result);
                comb.remove(comb.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> a;

        a = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : a) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();

        a = combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1}, 30);
        for (List<Integer> list : a) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
        /*
        2 2 1
        5
         */
        a = combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        for (List<Integer> list : a) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();

        /*
        5 3
         */
        a = combinationSum2(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : a) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
