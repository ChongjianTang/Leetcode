package leetcode.p2.p294;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanWin {
    /**
     * Feb 17, 2024 21:50
     * an excellent example of DP algorithm.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public boolean canWin(String currentState) {
        Map<String, Boolean> map = new HashMap<>();
        canWinHelper(currentState, true, map);
        return map.get(currentState);
    }

    public boolean canWinHelper(String currentState, boolean firstPlayerMoves, Map<String, Boolean> hashMap) {
        if (hashMap.containsKey(currentState)) {
            return hashMap.get(currentState);
        }
        List<String> nextStates = generatePossibleNextMoves(currentState);
        if (!nextStates.isEmpty()) {
            for (int i = 0; i < nextStates.size(); i++) {
                if (canWinHelper(nextStates.get(i), !firstPlayerMoves, hashMap) == firstPlayerMoves) {
                    hashMap.put(currentState, firstPlayerMoves);
                    return firstPlayerMoves;
                }
            }
        }
        hashMap.put(currentState, !firstPlayerMoves);
        return !firstPlayerMoves;
    }

    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                String s = "";
                if (i > 0) {
                    s += currentState.substring(0, i);
                }
                s += "--";
                if (i + 2 < currentState.length()) {
                    s += currentState.substring(i + 2);
                }
                result.add(s);
            }
        }
        return result;
    }
}