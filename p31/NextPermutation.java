package leetcode.p31;

public class NextPermutation {
    /**
     * Use bubble sort to deal with the suffix.
     */
    public static void nextPermutation1(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j > 0; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        helper(nums, i);
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }

    /**
     * Sort the array from index s;
     */
    public static void helper(int[] nums, int s) {
        for (int i = s; i < nums.length - 1; i++) {
            for (int j = s; j < nums.length - i + s - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Actually we don't need a nlogn sort to do sorting.
     * Becasue after the swap, the suffix is ordered.
     * What we should do is just reverse it.
     */
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j > 0; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        reverse(nums, i);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0);
    }

    /**
     * Reverse the array from index s.
     */
    public static void reverse(int[] nums, int s) {
        for (int i = s; i < (nums.length + s) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i + s - 1];
            nums[nums.length - i + s - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        nextPermutation(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
        nextPermutation(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
        nextPermutation(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
        nextPermutation(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
        nextPermutation(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
        a = new int[]{5, 4, 7, 5, 3, 2};
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
        nextPermutation(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
