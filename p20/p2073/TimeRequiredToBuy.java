package leetcode.p20.p2073;

import java.util.Stack;

public class TimeRequiredToBuy {
    /**
     * Apr 08, 2024 23:33
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] >= tickets[k]) {
                if (i <= k) {
                    time += tickets[k];
                } else {
                    time += tickets[k] - 1;
                }
            } else {
                time += tickets[i];
            }
        }
        return time;
    }
}
