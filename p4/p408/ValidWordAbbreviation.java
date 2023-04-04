package leetcode.p4.p408;

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int j = 0, i = 0;
        while (i < abbr.length()) {
            int start = i;
            if (Character.isDigit(abbr.charAt(i))) {
                i++;
            }
            int val = Integer.parseInt(abbr.substring(start, i));
            j += val;
        }
        // TODO
        return false;
    }

    public static void main(String[] args) {
        String word;
        String abbr;

        word = "internationalization";
        abbr = "i12iz4n";
        System.out.println(validWordAbbreviation(word, abbr));

        word = "apple";
        abbr = "a2e";
        System.out.println(!validWordAbbreviation(word, abbr));
    }
}
