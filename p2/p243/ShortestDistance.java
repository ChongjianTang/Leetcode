package leetcode.p2.p243;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistance {
    /**
     * Brute-Force
     * Time complexity: O(n2)
     * Space complexity: O(1)
     */
    public static int shortestDistance1(String[] wordsDict, String word1, String word2) {
        int distance = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                for (int j = 0; j < wordsDict.length; j++) {
                    if (wordsDict[j].equals(word2)) {
                        int temp = Math.abs(i - j);
                        if (temp < distance) {
                            distance = temp;
                        }
                    }
                }
            }
        }
        return distance;
    }

    /**
     * One-pass
     * Time complexity: O(n*m) where N is the number of words in the input list,
     * and M is the total length of two input words.
     * This is because in Java, String.equals comparison is O(n)
     * Space complexity: O(1)
     *
     * We can reduce this complexity by comparing hashes of the strings,
     * instead of comparing strings directly. This technique is used in Rabin Karp string matching algorithm.
     */
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int distance = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    int temp = index1 - index2;
                    if (temp < distance) {
                        distance = temp;
                    }
                }
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    int temp = index2 - index1;
                    if (temp < distance) {
                        distance = temp;
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] wordsDict;
        String word1, word2;
        int output;

        wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        word1 = "coding";
        word2 = "practice";
        output = 3;
        System.out.println(shortestDistance(wordsDict, word1, word2) == output);

        wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        word1 = "makes";
        word2 = "coding";
        output = 1;
        System.out.println(shortestDistance(wordsDict, word1, word2) == output);
    }
}
