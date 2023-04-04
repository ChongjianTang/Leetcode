package leetcode.p2.p274;

import java.util.Arrays;

public class HIndex {
    /**
     * 08/27/2022 02:23
     * Time complexity: O(nlogn)
     * Space complexity: O(1)
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (i + 1 > citations[citations.length - 1 - i]) {
                return i;
            }
        }
        return citations.length;
    }

    // TODO O(n) approach
}
