package leetcode.p24.p2444;

public class CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int leftEnd = 0;
        int leftStart = -1;
        long result = 0;
        int[] minMaxFrequencies = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftStart = i;
                leftEnd = i + 1;
                minMaxFrequencies[0] = 0;
                minMaxFrequencies[1] = 0;
            } else {
                if (nums[i] == minK) {
                    minMaxFrequencies[0] += 1;
                }
                if (nums[i] == maxK) {
                    minMaxFrequencies[1] += 1;
                }
                while (leftEnd < nums.length && ((nums[leftEnd] != minK && nums[leftEnd] != maxK) || (nums[leftEnd] == minK && minMaxFrequencies[0] > 1) || (nums[leftEnd] == maxK && minMaxFrequencies[1] > 1))) {
                    if (nums[leftEnd] == minK) {
                        minMaxFrequencies[0] -= 1;
                    }
                    if (nums[leftEnd] == maxK) {
                        minMaxFrequencies[1] -= 1;
                    }
                    leftEnd++;
                }
                if (minMaxFrequencies[0] >= 1 && minMaxFrequencies[1] >= 1) {
                    result += leftEnd - leftStart;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubarrays c = new CountSubarrays();
        int[] nums;
        int minK, maxK;


        nums = new int[]{35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913};
        minK = 35054;
        maxK = 945315;
        System.out.println(c.countSubarrays(nums, minK, maxK) == 81);

        nums = new int[]{1, 1, 1, 1};
        minK = 1;
        maxK = 1;
        System.out.println(c.countSubarrays(nums, minK, maxK) == 10);

        nums = new int[]{1, 3, 5, 2, 7, 5};
        minK = 1;
        maxK = 5;
        System.out.println(c.countSubarrays(nums, minK, maxK) == 2);
    }
}
