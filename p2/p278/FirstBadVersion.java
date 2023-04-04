package leetcode.p2.p278;

class VersionControl {
    boolean isBadVersion(int n) {
        return true;
    }
}

public class FirstBadVersion extends VersionControl {
    /**
     * Binary Search
     * Time complexity: O(logn)
     * Space complexty: O(1)
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int temp;
        while (left < right) {
            temp = left + (right - left) / 2;
            if (isBadVersion(temp)) {
                right = temp - 1;
            } else {
                left = temp + 1;
            }
        }
        if (left == right) {
            if (!isBadVersion(left)) {
                return left + 1;
            } else {
                return left;
            }
        } else {
            if (isBadVersion(left)) {
                return left;
            } else {
                return right;
            }
        }
    }
}
