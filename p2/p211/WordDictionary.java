package leetcode.p2.p211;

import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty() && index <= word.length()) {
            Queue<TrieNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TrieNode cur = queue.poll();
                if (index < word.length()) {
                    if (word.charAt(index) == '.') {
                        for (int i = 0; i < cur.children.length; i++) {
                            if (cur.children[i] != null) {
                                nextQueue.offer(cur.children[i]);
                            }
                        }
                    } else {
                        int temp = word.charAt(index) - 'a';
                        if (cur.children[temp] != null) {
                            nextQueue.offer(cur.children[temp]);
                        }
                    }
                } else {
                    if (cur.isWord) {
                        return true;
                    }
                }
            }
            queue = nextQueue;
            index++;
        }
        return false;
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
