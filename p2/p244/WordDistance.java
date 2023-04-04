package leetcode.p2.p244;

public class WordDistance {
    public WordDistance(String[] wordsDict) {

    }

    public int shortest(String word1, String word2) {
        return 0;
    }

    public static void main(String[] args) {
        String[] wordsDict;
        String word1, word2;
        int output;

        wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(wordsDict);
        word1 = "coding";
        word2 = "practice";
        output = 3;
        System.out.println(wordDistance.shortest(word1, word2) == output);
        word1 = "makes";
        word2 = "coding";
        output = 1;
        System.out.println(wordDistance.shortest(word1, word2) == output);
    }
}
