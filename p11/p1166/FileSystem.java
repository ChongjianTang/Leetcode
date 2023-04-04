package leetcode.p11.p1166;

import java.util.HashMap;
import java.util.Map;

/**
 * 09/25/2022 14:39
 * Trie
 */
public class FileSystem {

    private TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }

    public boolean createPath(String path, int value) {
        String[] paths = path.split("/");
        TrieNode temp = root;
        if (!paths[0].equals("")) {
            return false;
        }
        for (int i = 1; i < paths.length - 1; i++) {
            if (temp.children.containsKey(paths[i])) {
                temp = temp.children.get(paths[i]);
            } else {
                return false;
            }
        }
        if (!temp.children.containsKey(paths[paths.length - 1])) {
            temp.children.put(paths[paths.length - 1], new TrieNode(value));
            return true;
        } else {
            return false;
        }
    }

    public int get(String path) {
        String[] paths = path.split("/");
        TrieNode temp = root;
        if (!paths[0].equals("")) {
            return -1;
        }
        for (int i = 1; i < paths.length; i++) {
            if (temp.children.containsKey(paths[i])) {
                temp = temp.children.get(paths[i]);
            } else {
                return -1;
            }
        }
        return temp.value;
    }

    class TrieNode {
        Map<String, TrieNode> children;
        int value;

        public TrieNode() {
            children = new HashMap<>();
        }

        public TrieNode(int value) {
            children = new HashMap<>();
            this.value = value;
        }
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.createPath("/leet", 1));
        System.out.println(fileSystem.createPath("/leet/code", 2));
        System.out.println(fileSystem.get("/leet/code"));
    }
}
