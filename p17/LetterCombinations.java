package leetcode.p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> temp = new ArrayList<>();
        if (digits.equals("")) {
            return temp;
        }
        temp.add("a");
        temp.add("b");
        temp.add("c");
        map.put("2", temp);
        temp = new ArrayList<>();
        temp.add("d");
        temp.add("e");
        temp.add("f");
        map.put("3", temp);
        temp = new ArrayList<>();
        temp.add("g");
        temp.add("h");
        temp.add("i");
        map.put("4", temp);
        temp = new ArrayList<>();
        temp.add("j");
        temp.add("k");
        temp.add("l");
        map.put("5", temp);
        temp = new ArrayList<>();
        temp.add("m");
        temp.add("n");
        temp.add("o");
        map.put("6", temp);
        temp = new ArrayList<>();
        temp.add("p");
        temp.add("q");
        temp.add("r");
        temp.add("s");
        map.put("7", temp);
        temp = new ArrayList<>();
        temp.add("t");
        temp.add("u");
        temp.add("v");
        map.put("8", temp);
        temp = new ArrayList<>();
        temp.add("w");
        temp.add("x");
        temp.add("y");
        temp.add("z");
        map.put("9", temp);
        Stack<String> stack = new Stack<>();
        for (int i = digits.length() - 1; i >= 0; i--) {
            stack.push(String.valueOf(digits.charAt(i)));
        }
        while (stack.size() > 1) {
            String prev = stack.pop();
            String next = stack.pop();
            temp = combine(map.get(prev), map.get(next));
            prev += next;
            map.put(prev, temp);
            stack.push(prev);
        }
        return map.get(stack.pop());
    }

    public static List<String> combine(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
