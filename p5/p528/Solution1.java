package leetcode.p5.p528;

import java.util.Random;

public class Solution1 {
    int[] weightSum;

    public Solution1(int[] w) {
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
        for (int i = 0; i < weightSum.length; i++) {
            if (temp < weightSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
