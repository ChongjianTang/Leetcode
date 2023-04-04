package leetcode.p4.p476;

public class FindComplement {
    /**
     * 08/31/2022 13:52
     * Bit manipulation
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public static int findComplement(int num) {
        int count = 0;
        int result = 0;
        while (num != 0) {
            int temp = num & 1;
            temp = (temp ^ 1) << count;
            result = result | temp;
            num = num >> 1;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
