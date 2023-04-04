package leetcode.p2.p208;


public class Trie {

    private TrieNode root;

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isWord;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}
