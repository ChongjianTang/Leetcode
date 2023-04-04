package leetcode.p0.p9;

public class IsPalindrome {
    /**
     * My method
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (j > i) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        // TODO
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
