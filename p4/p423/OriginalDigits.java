package leetcode.p4.p423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class OriginalDigits {
    /**
     * too slow but it works
     */
    public static String originalDigits1(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.merge(s.charAt(i), 1, Integer::sum);
        }
        String[] digitsString = new String[]{"zero", "eight", "three", "two", "six", "seven", "five", "four", "one", "nine"};
        int[] digit = new int[]{0, 8, 3, 2, 6, 7, 5, 4, 1, 9};
        for (int i = 0; i < digitsString.length; i++) {
            boolean isExist = true;
            for (int j = 0; j < digitsString[i].length(); j++) {
                if (hashMap.get(digitsString[i].charAt(j)) == null) {
                    isExist = false;
                    break;
                }
            }
            if (isExist) {
                for (int j = 0; j < digitsString[i].length(); j++) {
                    if (hashMap.get(digitsString[i].charAt(j)) != null) {
                        int temp = hashMap.get(digitsString[i].charAt(j)) - 1;
                        if (temp == 0) {
                            hashMap.remove(digitsString[i].charAt(j));
                        } else {
                            hashMap.put(digitsString[i].charAt(j), temp);
                        }
                    }
                }
                nums.add(digit[i]);
                i--;
            }
        }
        Collections.sort(nums);
        String result = "";
        for (int i : nums) {
            result += i;
        }
        return result;
    }

    /**
     * ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]
     * Still too slow but better than method 1
     */
    public static String originalDigits2(String s) {
        String chars = "zwuxghsvtin";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            hashMap.put(chars.charAt(i), 0);
        }
        for (int i = 0; i < s.length(); i++) {
            hashMap.merge(s.charAt(i), 1, Integer::sum);
        }
        int[] digits = new int[11];
        digits[0] = hashMap.get('z');
        digits[2] = hashMap.get('w');
        digits[4] = hashMap.get('u');
        digits[6] = hashMap.get('x');
        digits[8] = hashMap.get('g');
        digits[3] = hashMap.get('h') - digits[8];
        digits[7] = hashMap.get('s') - digits[6];
        digits[5] = hashMap.get('v') - digits[7];
        digits[9] = hashMap.get('i') - digits[6] - digits[5] - digits[8];
        digits[1] = hashMap.get('n') - digits[7] - 2 * digits[9];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            result.append(String.valueOf(i).repeat(Math.max(0, digits[i])));
        }
        return result.toString();
    }

    /**
     * Use Array instead of HashMap
     */
    public static String originalDigits(String s) {
        String alphabet = "zwuxghsvin";
        int[] chars = new int[alphabet.length()];
        Arrays.fill(chars, 0);
        for (int i = 0; i < s.length(); i++) {
            int index = alphabet.indexOf(s.charAt(i));
            if (index != -1) {
                chars[index]++;
            }
        }
        int[] digits = new int[11];
        digits[0] = chars[0];
        digits[2] = chars[1];
        digits[4] = chars[2];
        digits[6] = chars[3];
        digits[8] = chars[4];
        digits[3] = chars[5] - digits[8];
        digits[7] = chars[6] - digits[6];
        digits[5] = chars[7] - digits[7];
        digits[9] = chars[8] - digits[6] - digits[5] - digits[8];
        digits[1] = chars[9] - digits[7] - 2 * digits[9];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            result.append(String.valueOf(i).repeat(Math.max(0, digits[i])));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("zerozero").equals("00"));
        System.out.println(originalDigits("fviefuro").equals("45"));
        System.out.println(originalDigits("owoztneoer").equals("012"));
    }
}
