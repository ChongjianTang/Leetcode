package leetcode.p1.p189;

import java.util.Arrays;

public class Rotate {
    /**
     * My method
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int count = 0;
        int store;
        int temp;
        int start = 0;
        while (count != nums.length) {
            int i = start + k;
            store = nums[start];
            while (i != start) {
                temp = store;
                store = nums[i];
                nums[i] = temp;
                count++;
                i += k;
                i = i % nums.length;
            }
            nums[start] = store;
            count++;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] nums;
        int k;
        int[] output;
        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        output = new int[]{3, 99, -1, -100};

        rotate(nums, k);
        System.out.println(Arrays.equals(nums, output));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        k = 3;
        output = new int[]{5, 6, 7, 1, 2, 3, 4};

        rotate(nums, k);
        System.out.println(Arrays.equals(nums, output));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        k = 4;
        output = new int[]{3, 4, 5, 6, 1, 2};

        rotate(nums, k);
        System.out.println(Arrays.equals(nums, output));


//        String a = "abc";
//        String b = "abc";
//        String c = new String("abc");
//        System.out.println(a == b);
//        System.out.println(a == c);
//
//        System.out.println("Number: ");
//        Integer num1 = 1;
//        Integer num2 = 1;
//        System.out.println(num1 == num2);
//
//        num1 = 128;
//        num2 = 128;
//        System.out.println(num1 == num2);

    }
}
