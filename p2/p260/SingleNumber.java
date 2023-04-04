package leetcode.p2.p260;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask = bitmask ^ num;
        }
        bitmask = bitmask & -bitmask;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & bitmask) == 0) {
                result[0] = result[0] ^ num;
            } else {
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }
}
