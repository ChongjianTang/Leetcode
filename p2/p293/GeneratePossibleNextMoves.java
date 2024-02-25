package leetcode.p2.p293;

import java.util.ArrayList;
import java.util.List;

public class GeneratePossibleNextMoves {
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
