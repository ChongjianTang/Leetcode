package leetcode.p6.p648;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i));
        }
        String[] words = sentence.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += trie.replace(words[i]);
            if (i != words.length - 1) {
                result += " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReplaceWords r = new ReplaceWords();
        List<String> dictionary = new ArrayList<>();
        String sentence;
        String expected;

        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");

        sentence = "the cattle was rattled by the battery";

        expected = "the cat was rat by the bat";
        System.out.println(r.replaceWords(dictionary, sentence).equals(expected));
    }
}

class TrieNode {
    Boolean isWord;
    TrieNode[] children;

    TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

class Trie {
    /**
     * Jun 06, 2024 19:08
     * Trie
     */
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    String replace(String s) {
        TrieNode cur = root;
        String currWord = "";
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (cur.children[index] != null) {
                currWord += s.charAt(i);
                cur = cur.children[index];
                if (cur.isWord) {
                    return currWord;
                }
            } else {
                break;
            }
        }
        return s;
    }
}
