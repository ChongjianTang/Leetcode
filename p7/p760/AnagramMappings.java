package leetcode.p7.p760;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramMappings {
    /**
     * My approach
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
//    Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < B.length; i++) {
//        if (!map.containsKey(B[i])) {
//            List<Integer> indexList = new ArrayList<>();
//            indexList.add(i);
//            map.put(B[i], indexList);
//        } else {
//            map.get(B[i]).add(i);
//        }
//    }
//    int[] result = new int[A.length];
//        for (int i = 0; i < A.length; i++) {
//        List<Integer> indexList = map.get(A[i]);
//        result[i] = indexList.get(0);
//        indexList.remove(0);
//    }
//        return result;
}
