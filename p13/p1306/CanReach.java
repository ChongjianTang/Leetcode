package leetcode.p13.p1306;

public class CanReach {
    /**
     * Feb 10, 2024 18:46
     * DFS
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        if (arr[start] == -1) {
            return false;
        }
        int[] delta = new int[]{-arr[start], arr[start]};
        arr[start] = -1;
        for (int i = 0; i < delta.length; i++) {
            int index = start + delta[i];
            if (index >= 0 && index < arr.length) {
                if (canReach(arr, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanReach canReach = new CanReach();
        int[] arr;
        int start;

        arr = new int[]{0, 3, 0, 6, 3, 3, 4};
        start = 6;
        System.out.println(canReach.canReach(arr, start));
    }
}
