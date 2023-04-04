package leetcode.p0.p71;

import java.util.Stack;

public class SimplifyPath {
    /**
     * 05/16/2022 17:56
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        StringBuilder result = new StringBuilder();
        for (String directory : directories) {
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (!directory.equals(".") && !directory.equals("")) {
                    stack.push(directory);
                }
            }
        }
        for (String s : stack) {
            result.append("/").append(s);
        }
        if (stack.isEmpty()) {
            result = new StringBuilder("/");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String path;
        String output;

        path = "/home/";
        output = "/home";

        System.out.println(simplifyPath(path).equals(output));

        path = "/../";
        output = "/";
        System.out.println(simplifyPath(path).equals(output));

        path = "/home//foo/";
        output = "/home/foo";
        System.out.println(simplifyPath(path).equals(output));
    }
}
