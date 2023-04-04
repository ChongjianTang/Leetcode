package leetcode.p5.p528;

import java.util.Random;

public class Solution {
    int[] weightSum;

    public Solution(int[] w) {
        weightSum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            weightSum[i] = sum;
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int temp = r.nextInt(weightSum[weightSum.length - 1]);
        int start = 0;
        int end = weightSum.length;
        while (end - start > 3) {
            int i = (end + start) / 2;
            if (temp >= weightSum[i - 1] && temp < weightSum[i]) {
                return i;
            } else if (temp < weightSum[i - 1]) {
                end = i;
            } else {
                start = i;
            }
        }
        for (int i = start; i < end; i++) {
            if (temp < weightSum[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{7, 3, 1, 7, 4, 1, 2, 8, 5});
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());

    }

}
