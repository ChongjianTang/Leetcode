package leetcode.p2.p202;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    /**
     * HashSet
     */
    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            visited.add(n);
            int newN = 0;
            while (n != 0) {
                int temp = n % 10;
                n = n / 10;
                newN += temp * temp;
            }
            if (visited.contains(newN)) {
                return false;
            }
            n = newN;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
