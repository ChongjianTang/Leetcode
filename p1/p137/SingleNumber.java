package leetcode.p1.p137;

public class SingleNumber {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int num : nums) {
                temp += num >> i & 1;
            }
            result = result | (temp % 3 << i);
        }
        return result;
    }

    /**
     * Two bitmasks
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }


    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
    }
}
