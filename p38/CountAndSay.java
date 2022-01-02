package leetcode.p38;

public class CountAndSay {
    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 0;
            for (int j = 0; j < result.length(); j++) {
                count++;
                if (j == result.length() - 1) {
                    temp.append(count).append(String.valueOf(result.charAt(j)));
                } else {
                    if (result.charAt(j) != result.charAt(j + 1)) {
                        temp.append(count).append(String.valueOf(result.charAt(j)));
                        count = 0;
                    }
                }
            }
            result = temp.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
    }
}
