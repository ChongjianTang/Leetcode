package leetcode.p0.p93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIpAddresses {
    /**
     * My method
     */
    public static List<String> restoreIpAddresses1(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String[] ip = new String[4];
        Arrays.fill(ip, "");
        backtracking1(s, 0, 0, ip, result);
        return result;
    }

    public static void backtracking1(String s, int index, int indexOfIPArray, String[] ip, List<String> result) {
        if (index == s.length()) {
            if (indexOfIPArray == 3) {
                String answer = ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3];
                result.add(answer);
            }
        } else {
            if (ip[indexOfIPArray].length() == 0) {
                ip[indexOfIPArray] = String.valueOf(s.charAt(index));
                backtracking1(s, index + 1, indexOfIPArray, ip, result);
                ip[indexOfIPArray] = "";
            } else if (ip[indexOfIPArray].charAt(0) == '0') {
                if (indexOfIPArray < 3) {
                    backtracking1(s, index, indexOfIPArray + 1, ip, result);
                }
            } else {
                String original = ip[indexOfIPArray];
                String temp = original + s.charAt(index);
                if (!(original.charAt(0) == '0' && ip.length == 1) && Integer.parseInt(temp) <= 255) {
                    ip[indexOfIPArray] = temp;
                    backtracking1(s, index + 1, indexOfIPArray, ip, result);
                    ip[indexOfIPArray] = original;
                }
                if (indexOfIPArray < 3 && s.length() - index <= (3 - indexOfIPArray) * 3) {
                    backtracking1(s, index, indexOfIPArray + 1, ip, result);
                }
            }
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking2(s, -1, 0, result);
        return result;
    }

    public static void backtracking2(String s, int pos, int dotNum, List<String> result) {
        if (dotNum == 3) {
            if (checkIP(s)) {
                result.add(s);
            }
        } else {
            String prefix = s.substring(0, pos + 1);
            if (pos + 2 < s.length()) {
                backtracking2(prefix + s.substring(pos + 1, pos + 2) + "." + s.substring(pos + 2), pos + 2, dotNum + 1, result);
            }
            if (pos + 3 < s.length()) {

                backtracking2(prefix + s.substring(pos + 1, pos + 3) + "." + s.substring(pos + 3), pos + 3, dotNum + 1, result);
            }
            if (pos + 4 < s.length()) {
                backtracking2(prefix + s.substring(pos + 1, pos + 4) + "." + s.substring(pos + 4), pos + 4, dotNum + 1, result);
            }
        }
    }

    public static boolean checkIP(String s) {
        String[] data = s.split("\\.");
        if (data.length != 4) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].length() > 1 && data[i].charAt(0) == '0') {
                return false;
            }
            if (data[i].length() > 3) {
                return false;
            }
            if (Integer.parseInt(data[i]) > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(restoreIpAddresses("25525511135"));
//        System.out.println(restoreIpAddresses("0000"));
//        System.out.println(restoreIpAddresses("101023"));
        System.out.println(restoreIpAddresses("0279245587303"));
    }
}
