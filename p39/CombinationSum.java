package leetcode.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {
    /**
     * D&C all integers are distinct. So it is ok to use addAll for the list.
     * There will be no duplicate combination.
     * But the duplicate combination will become a problem in the next problem (40).
     */
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = helper1(candidates, 0, target);
        if (result == null) {
            return new ArrayList<>();
        }
        return result;
    }

    public static List<List<Integer>> helper1(int[] candidates, int start, int target) {
        if (target == 0) {
            return new ArrayList<>();
        }
        if (start == candidates.length || target < candidates[start]) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> temp2 = helper1(candidates, start, target - candidates[start]);
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
            result.addAll(temp2);
        }
        List<List<Integer>> temp1 = helper1(candidates, start + 1, target);
        if (temp1 != null) {
            result.addAll(temp1);
        }
        if (result.size() == 0) {
            return null;
        }
        return result;
    }

    /**
     * Backtracking (DFS the tree with n children)
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack2(new ArrayList<>(), target, 0, candidates, result);
        return result;
    }

    public static void backtrack2(List<Integer> comb, int remain, int curr, int[] candidates, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = curr; i < candidates.length; i++) {
            comb.add(candidates[i]);
            backtrack2(comb, remain - candidates[i], i, candidates, result);
            comb.remove((Integer) candidates[i]);
        }
    }

    /**
     * DFS a binary tree.
     * Actually this method is the same as the combinationSum1.
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, new ArrayList<>(), target, 0, result);
        return result;
    }

    public static void dfs(int[] candidates, List<Integer> comb, int remain, int curr, List<List<Integer>> result) {
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
        comb.add(candidates[curr]);
        dfs(candidates, comb, remain - candidates[curr], curr, result);
        comb.remove((Integer) candidates[curr]);

        dfs(candidates, comb, remain, curr + 1, result);
    }


    public static void main(String[] args) {
        List<List<Integer>> a;
        System.out.println();
        a = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : a) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();

        a = combinationSum(new int[]{2}, 1);
        for (List<Integer> list : a) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();

        a = combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : a) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
