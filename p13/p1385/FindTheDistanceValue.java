package leetcode.p13.p1385;

public class FindTheDistanceValue {
    /**
     * Brute Force
     */
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    count++;
                    break;
                }
            }
        }
        return arr1.length - count;
    }

    public static void main(String[] args) {
        int[] arr1, arr2;

        arr1 = new int[]{4, 5, 8};
        arr2 = new int[]{10, 9, 1, 8};
        System.out.println(findTheDistanceValue(arr1, arr2, 2) == 2);

        arr1 = new int[]{1, 4, 2, 3};
        arr2 = new int[]{-4, -3, 6, 10, 20, 30};
        System.out.println(findTheDistanceValue(arr1, arr2, 3) == 2);
    }
}
