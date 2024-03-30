package leetcode.p7.p740;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!numsMap.containsKey(nums[i])){
                numsMap.put(nums[i], 0);
            } else {
                numsMap.put(nums[i], numsMap.get(nums[i]));
            }
        }
        Map<Set<Integer>, Integer> dp = new HashMap<>();
        for(int num : numsMap.keySet()){
            Set<Integer> set = new HashSet<>();
            set.add(num);
            dp.put(set, numsMap.get(num) * num);
        }
        return 0;
        // TODO: Fix this
    }
}
