package leetcode.p4.p468;

import java.util.Arrays;
import java.util.Locale;

public class ValidIPAddress {
    /**
     * Sep 30, 2022 14:21
     */
    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) {
            return "IPv4";
        } else if (isIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean isIPv4(String queryIP) {
        String[] data = queryIP.split("\\.", 4);
        if (data.length != 4) {
            return false;
        }
        for (String num : data) {
            if (num.equals("") || num.length() > 3) {
                return false;
            }
            for (int j = 0; j < num.length(); j++) {
                if (!Character.isDigit(num.charAt(j))) {
                    return false;
                }
            }
            int temp = Integer.parseInt(num);
            if (temp < 0 || temp > 255) {
                return false;
            }

            if (!num.equals("0") && num.charAt(0) == '0') {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String queryIP) {
        String[] data = queryIP.split(":", 8);
        if (data.length != 8) {
            return false;
        }
        for (String num : data) {
            num = num.toLowerCase();
            if (num.length() > 4 || num.equals("")) {
                return false;
            }
            for (int i = 0; i < num.length(); i++) {
                if (!Character.isDigit(num.charAt(i)) && (num.charAt(i) < 'a' || num.charAt(i) > 'f')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
