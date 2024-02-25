package leetcode.p1.p118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate {
    /**
     * Feb 11, 2024 16:59
     * Pure math and binomial theorem
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                line.add(binomialCoefficient(i, j));
            }
            pascalTriangle.add(line);
        }
        return pascalTriangle;
    }

    public int binomialCoefficient(double n, double k) {
        double result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i) / (k - i);
        }
        return (int) Math.round(result);
    }
    //TODO For method 1, we can reduce the calculation by half because the binomial coefficient is symmetric.

    /**
     * Feb 11, 2024 17:24
     * DP
     * Time Complexity: O(numRows^2)
     * Space Complexity: O(1)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            if (pascalTriangle.isEmpty()) {
                line.add(1);
            } else {
                List<Integer> previousLine = pascalTriangle.getLast();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        line.add(1);
                    } else {
                        line.add(previousLine.get(j - 1) + previousLine.get(j));
                    }
                }
            }
            pascalTriangle.add(line);
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        Generate g = new Generate();
        int numRows;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(List.of(1)));
        result.add(new ArrayList<>(List.of(1, 1)));
        result.add(new ArrayList<>(List.of(1, 2, 1)));
        result.add(new ArrayList<>(List.of(1, 3, 3, 1)));
        result.add(new ArrayList<>(List.of(1, 4, 6, 4, 1)));

        numRows = 5;
        System.out.println(g.generate(numRows).equals(result));

        result.add(new ArrayList<>(List.of(1, 5, 10, 10, 5, 1)));
        result.add(new ArrayList<>(List.of(1, 6, 15, 20, 15, 6, 1)));
        result.add(new ArrayList<>(List.of(1, 7, 21, 35, 35, 21, 7, 1)));

        numRows = 8;
        System.out.println(g.generate(numRows).equals(result));


    }
}
