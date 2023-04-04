package leetcode.p8.p811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> table = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] str = cpdomain.split(" ");
            int count = Integer.parseInt(str[0]);
            table.merge(str[1], count, Integer::sum);
            for (int j = 0; j < str[1].length(); j++) {
                if (str[1].charAt(j) == '.') {
                    table.merge(str[1].substring(j + 1), count, Integer::sum);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String s : table.keySet()) {
            String str = table.get(s) + " " + s;
            result.add(str);
        }
        return result;
    }
}
