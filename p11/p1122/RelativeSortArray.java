package leetcode.p11.p1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    /**
     * 08/30/2022 19:31
     * My approach
     * sort
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] temp = new Integer[arr1.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr1[i];
        }
        Arrays.sort(temp, (o1, o2) -> {
            if (!map.containsKey(o1) && !map.containsKey(o2)) {
                return o1 - o2;
            }
            if (!map.containsKey(o1)) {
                return -1;
            }
            if (!map.containsKey(o2)) {
                return 1;
            }
            return map.get(o2) - map.get(o1);
        });

        int[] result = new int[temp.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}
