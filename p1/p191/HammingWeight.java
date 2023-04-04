package leetcode.p1.p191;

public class HammingWeight {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >> 1;
        }
        return result;
    }
}
