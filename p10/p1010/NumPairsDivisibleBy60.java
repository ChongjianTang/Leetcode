package leetcode.p10.p1010;

import java.util.HashMap;

public class NumPairsDivisibleBy60 {
    /**
     * Mar 11, 2023 17:29
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            freqMap.put(time[i] % 60, freqMap.getOrDefault(time[i] % 60, 0) + 1);
        }
        int result = 0;
        for (int i = 1; i < 30; i++) {
            result += freqMap.getOrDefault(i, 0) * freqMap.getOrDefault(60 - i, 0);
        }

        if (freqMap.containsKey(0)) {
            long temp = freqMap.get(0);
            result += (temp * (temp - 1)) / 2;
        }

        if (freqMap.containsKey(30)) {
            long temp = freqMap.get(30);
            result += (temp * (temp - 1)) / 2;
        }
        return result;
    }
}
