package leetcode.p7.p780;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReachingPoints {
    /**
     * Naive Search
     * TLE
     */
    public static boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        Queue<int[]> openList = new ArrayDeque<>();
        openList.add(new int[]{sx, sy});
        while (!openList.isEmpty()) {
            int[] temp = openList.poll();
            if (temp[0] == tx && temp[1] == ty) {
                return true;
            }
            int val = temp[0] + temp[1];
            if (val <= tx) {
                int[] leftChild = new int[]{val, temp[1]};
                openList.add(leftChild);
            }
            if (val <= ty) {
                int[] rightChild = new int[]{temp[0], val};
                openList.add(rightChild);
            }
        }
        return false;
    }

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }
            if (tx > ty) {
                if (ty > sy) {
                    tx %= ty;
                } else {
                    int temp = tx - sx;
                    return temp % ty == 0;
                }
            } else {
                if (tx > sx) {
                    ty %= tx;
                } else {
                    int temp = ty - sy;
                    return temp % tx == 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(reachingPoints(6, 5, 11, 16));
        System.out.println(!reachingPoints(1, 1, 2, 2));
        System.out.println(reachingPoints(1, 1, 3, 5));
    }
}
