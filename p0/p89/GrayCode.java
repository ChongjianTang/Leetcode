package leetcode.p0.p89;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    /**
     * Recursion and bit manipulation
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }
        List<Integer> temp = grayCode(n - 1);
        result.addAll(temp);
        int digit = 1 << n - 1;
        for (int i = 0; i < temp.size(); i++) {
            result.add(digit ^ temp.get(temp.size() - 1 - i));
        }
        return result;
    }
}
