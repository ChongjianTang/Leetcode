package leetcode.p9.p948;

import java.util.Arrays;

public class BagOfTokensScore {
    /**
     * Mar 03, 2024 22:44
     * Greedy
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n) (From Arrays.sort())
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int max = 0;
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right && left < tokens.length && power > tokens[left]) {
            while (left < tokens.length && tokens[left] <= power) {
                power -= tokens[left];
                left++;
                score++;
            }
            max = Math.max(max, score);
            if (score > 0) {
                power += tokens[right];
                right--;
                score--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BagOfTokensScore b = new BagOfTokensScore();
        int[] tokens = new int[]{100, 200, 300, 400};
        int power = 200;
        int expected = 2;
        System.out.println(b.bagOfTokensScore(tokens, power) == expected);
    }
}