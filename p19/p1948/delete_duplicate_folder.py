"""
Due to a bug, there are many duplicate folders in a file system. You are given a 2D array paths, where paths[i] is an array representing an absolute path to the ith folder in the file system.

For example, ["one", "two", "three"] represents the path "/one/two/three".
Two folders (not necessarily on the same level) are identical if they contain the same non-empty set of identical subfolders and underlying subfolder structure. The folders do not need to be at the root level to be identical. If two or more folders are identical, then mark the folders as well as all their subfolders.

For example, folders "/a" and "/b" in the file structure below are identical. They (as well as their subfolders) should all be marked:
/a
/a/x
/a/x/y
/a/z
/b
/b/x
/b/x/y
/b/z
However, if the file structure also included the path "/b/w", then the folders "/a" and "/b" would not be identical. Note that "/a/x" and "/b/x" would still be considered identical even with the added folder.
Once all the identical folders and their subfolders have been marked, the file system will delete all of them. The file system only runs the deletion once, so any folders that become identical after the initial deletion are not deleted.

Return the 2D array ans containing the paths of the remaining folders after deleting all the marked folders. The paths may be returned in any order.



Example 1:


Input: paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
Output: [["d"],["d","a"]]
Explanation: The file structure is as shown.
Folders "/a" and "/c" (and their subfolders) are marked for deletion because they both contain an empty
folder named "b".
Example 2:


Input: paths = [["a"],["c"],["a","b"],["c","b"],["a","b","x"],["a","b","x","y"],["w"],["w","y"]]
Output: [["c"],["c","b"],["a"],["a","b"]]
Explanation: The file structure is as shown.
Folders "/a/b/x" and "/w" (and their subfolders) are marked for deletion because they both contain an empty folder named "y".
Note that folders "/a" and "/c" are identical after the deletion, but they are not deleted because they were not marked beforehand.
Example 3:


Input: paths = [["a","b"],["c","d"],["c"],["a"]]
Output: [["c"],["c","d"],["a"],["a","b"]]
Explanation: All folders are unique in the file system.
Note that the returned array can be in a different order as the order does not matter.


Constraints:

1 <= paths.length <= 2 * 104
1 <= paths[i].length <= 500
1 <= paths[i][j].length <= 10
1 <= sum(paths[i][j].length) <= 2 * 105
path[i][j] consists of lowercase English letters.
No two paths lead to the same folder.
For any folder not at the root level, its parent folder will also be in the input.
"""
from typing import List, Set


class Solution:
    """
    Jul 20, 2025 17:18
    """
    class Node:
        def __init__(self):
            self.children = {}

    def get_hash(self, node, hash_vals: dict, duplicated: Set[Node]):
        hash_val = ""
        file_names = sorted(node.children.keys())
        for file in file_names:
            hash_val += file + self.get_hash(node.children[file], hash_vals, duplicated)
        if hash_val == "":
            return hash_val
        hash_val = "-" + hash_val + "+"

        if hash_val not in hash_vals:
            hash_vals[hash_val] = node
        else:
            duplicated.add(node)
            duplicated.add(hash_vals[hash_val])

        return hash_val

    def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:
        root = self.Node()
        for path in paths:
            node = root
            for f in path:
                if f not in node.children:
                    node.children[f] = self.Node()
                node = node.children[f]

        hash_vals = {}
        duplicated = set()
        self.get_hash(root, hash_vals, duplicated)
        if root in duplicated:
            return []

        result = []
        self.dfs(root, [], duplicated, result)
        return result

    def dfs(self, node: Node, curr: List[str], duplicated: Set[Node], result: List[List[str]]):
        for f in node.children:
            if node.children[f] not in duplicated:
                result.append(curr + [f])
                self.dfs(node.children[f], curr + [f], duplicated, result)


if __name__ == '__main__':
    obj = Solution()

    paths = [["a"], ["a", "c"], ["a", "c", "b"], ["a", "w"], ["a", "w", "y"], ["z", "c"], ["z", "c", "b"], ["z", "c", "w"],
     ["z", "c", "w", "y"], ["z"]]
    print(obj.deleteDuplicateFolder(paths))


    paths = [["a"], ["a", "b"], ["a", "c"], ["a", "b", "d"], ["a", "b", "e"], ["a", "c", "d"], ["a", "c", "d", "e"]]
    print(obj.deleteDuplicateFolder(paths))

    paths = [["a"], ["c"], ["a", "b"], ["c", "b"], ["a", "b", "x"], ["a", "b", "x", "y"], ["w"], ["w", "y"]]
    print(obj.deleteDuplicateFolder(paths))

    paths = [["a"], ["c"], ["d"], ["a", "b"], ["c", "b"], ["d", "a"]]
    print(obj.deleteDuplicateFolder(paths))
