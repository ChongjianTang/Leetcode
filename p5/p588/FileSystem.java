package leetcode.p5.p588;

import java.util.*;

public class FileSystem {

    FileNode root;

    public FileSystem() {
        root = new FileNode(true);
    }

    public List<String> ls(String path) {
        String[] paths = path.split("/");
        FileNode temp = root;
        for (String s : paths) {
            if (!s.equals("")) {
                if (temp.subDir.get(s) == null) {
                    temp.subDir.put(s, new FileNode(true));
                }
                temp = temp.subDir.get(s);
            }
        }
        if (temp.isDir) {
            return temp.ls();
        } else {
            List<String> result = new ArrayList<>();
            result.add(paths[paths.length - 1]);
            return result;
        }
    }

    public void mkdir(String path) {
        String[] paths = path.split("/");
        FileNode temp = root;
        for (String s : paths) {
            if (!s.equals("")) {
                if (temp.subDir.get(s) == null) {
                    temp.subDir.put(s, new FileNode(true));
                }
                temp = temp.subDir.get(s);
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        FileNode temp = root;
        for (int i = 0; i < paths.length - 1; i++) {
            if (!paths[i].equals("")) {
                if (temp.subDir.get(paths[i]) == null) {
                    temp.subDir.put(paths[i], new FileNode(true));
                }
                temp = temp.subDir.get(paths[i]);
            }
        }
        String path = paths[paths.length - 1];
        if (temp.subDir.get(path) == null) {
            FileNode fileNode = new FileNode(false);
            fileNode.fileContent = content;
            temp.subDir.put(path, fileNode);
        } else {
            temp.subDir.get(path).fileContent += content;
        }
    }

    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        FileNode temp = root;
        for (String path : paths) {
            if (!path.equals("")) {
                temp = temp.subDir.get(path);
            }
        }
        return temp.fileContent;
    }
}


class FileNode {
    Boolean isDir;
    HashMap<String, FileNode> subDir;
    String fileContent;

    public FileNode(boolean isDir) {
        this.isDir = isDir;
        if (isDir) {
            subDir = new HashMap<>();
            fileContent = null;
        } else {
            subDir = null;
            fileContent = "";
        }
    }

    public List<String> ls() {
        List<String> result = new ArrayList<>(subDir.keySet());
        result.sort(Comparator.naturalOrder());
        return result;
    }

    public FileNode getChild(String name) {
        return subDir.get(name);
    }
}
