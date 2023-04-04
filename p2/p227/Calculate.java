package leetcode.p2.p227;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculate {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }

    /**
     * My Method
     */
    public static int calculate(String s) {
        s = s.replace(" ", "");
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2") == 7);
        System.out.println(calculate(" 3/2 ") == 1);
        System.out.println(calculate(" 3+5 / 2") == 5);
    }
}
