package leetcode.p0.p68;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int lengthOfLine = 0;
        List<String> wordsOfLine = new ArrayList<>();
        for (String word : words) {
            if (lengthOfLine + word.length() > maxWidth) {
                result.add(helper(wordsOfLine, maxWidth));
                wordsOfLine.clear();
                lengthOfLine = 0;
            }
            wordsOfLine.add(word);
            lengthOfLine += word.length() + 1;
        }
        if (!wordsOfLine.isEmpty()) {
            StringBuilder temp = new StringBuilder();
            for (String s : wordsOfLine) {
                temp.append(s).append(" ");
            }
            if (maxWidth < temp.length()) {
                temp = new StringBuilder(temp.toString().trim());
            } else {
                temp.append(" ".repeat(maxWidth - temp.length()));
            }
            result.add(temp.toString());
        }
        return result;
    }

    public static String helper(List<String> words, int maxWidth) {
        if (words.size() == 1) {
            return words.get(0) + " ".repeat(maxWidth - words.get(0).length());
        }
        int len = 0;
        for (String word : words) {
            len += word.length();
        }
        int lengthOfSlot = (maxWidth - len) / (words.size() - 1);
        int numOfMoreSpace = maxWidth - len - (words.size() - 1) * lengthOfSlot;
        int j = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            result.append(words.get(i));
            result.append(" ".repeat(lengthOfSlot));
            if (j < numOfMoreSpace) {
                result.append(" ");
                j++;
            }
        }
        result.append(words.get(words.size() - 1));
        return result.toString();
    }

    public static void main(String[] args) {
        String[] words;
        List<String> result;

        words = new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};

        result = new ArrayList<>();
        result.add("This    is    an");
        result.add("example  of text");
        result.add("justification.  ");

        System.out.println(fullJustify(words, 16));


        words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        result = new ArrayList<>();
        result.add("This    is    an");
        result.add("example  of text");
        result.add("justification.  ");

        System.out.println(fullJustify(words, 16).equals(result));

        words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};

        result = new ArrayList<>();
        result.add("What   must   be");
        result.add("acknowledgment  ");
        result.add("shall be        ");

        System.out.println(fullJustify(words, 16).equals(result));


        words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};


        result = new ArrayList<>();
        result.add("Science  is  what we");
        result.add("understand      well");
        result.add("enough to explain to");
        result.add("a  computer.  Art is");
        result.add("everything  else  we");
        result.add("do                  ");


        System.out.println(fullJustify(words, 20).equals(result));
    }
}
