package leetcode.p2.p216;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking1(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public static void backtracking1(int num, int k, int n, List<Integer> comb, List<List<Integer>> result) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<>(comb));
            }
            return;
        }
        for (int i = num; i < 10; i++) {
            if (n >= i) {
                comb.add(i);
                backtracking1(i + 1, k - 1, n - i, comb, result);
                comb.remove(comb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }
}
