package leetcode.p0.p69;

public class MySqrt {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x / 2 + 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            long val = (long) pivot * pivot;
            if (val == x) {
                return pivot;
            } else if (val > x) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return right;
    }
}
