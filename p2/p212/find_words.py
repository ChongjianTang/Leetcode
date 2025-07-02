"""
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
"""
from typing import List


class Solution:
    """
    Jul 01, 2025 16:18
    More time effective then solution 1
    """

    class TrieNode:
        def __init__(self):
            self.c = ""
            self.is_word = False
            self.parent = None
            self.children = {}

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = self.TrieNode()
        for word in words:
            self.add(root, word)

        result = []

        for i in range(len(board)):
            for j in range(len(board[0])):
                if root.children and board[i][j] in root.children:
                    c = board[i][j]
                    board[i][j] = ""
                    self.helper(board, root.children[c], i, j, c, result)
                    board[i][j] = c

        return result

    def helper(self, board: List[List[str]], node: TrieNode, x: int, y: int, curr_str: str, result: List[str]):
        if node.is_word:
            temp = node
            result.append(curr_str)
            temp.is_word = False
            while not temp.children and not temp.is_word:
                if not temp.parent:
                    break
                parent = temp.parent
                parent.children.pop(temp.c)
                temp = parent

        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        for i in range(len(dx)):
            new_x = x + dx[i]
            new_y = y + dy[i]
            if 0 <= new_x < len(board) and 0 <= new_y < len(board[0]):
                if board[new_x][new_y] in node.children:
                    c = board[new_x][new_y]
                    board[new_x][new_y] = ""
                    self.helper(board, node.children[c], new_x, new_y, curr_str + c, result)
                    board[new_x][new_y] = c

    def add(self, root: TrieNode, word: str):
        curr = root
        for c in word:
            if c not in curr.children:
                curr.children[c] = self.TrieNode()
                curr.children[c].c = c
                curr.children[c].parent = curr
            curr = curr.children[c]

        curr.is_word = True


class Solution1:
    """
    Jun 30, 2025 18:26
    """

    class TrieNode:
        def __init__(self):
            self.is_word = False
            self.children = {}

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = self.TrieNode()
        for word in words:
            self.add(root, word)

        result = set()

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] in root.children:
                    c = board[i][j]
                    board[i][j] = ""
                    self.helper(board, root.children[c], i, j, c, result)
                    board[i][j] = c

        return list(result)

    def helper(self, board: List[List[str]], node: TrieNode, x: int, y: int, curr_str: str, result: set):
        if node.is_word:
            result.add(curr_str)

        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        for i in range(len(dx)):
            new_x = x + dx[i]
            new_y = y + dy[i]
            if 0 <= new_x < len(board) and 0 <= new_y < len(board[0]):
                if board[new_x][new_y] in node.children:
                    c = board[new_x][new_y]
                    board[new_x][new_y] = ""
                    self.helper(board, node.children[c], new_x, new_y, curr_str + c, result)
                    board[new_x][new_y] = c

    def add(self, root: TrieNode, word: str):
        curr = root
        for c in word:
            if c not in curr.children:
                curr.children[c] = self.TrieNode()
            curr = curr.children[c]

        curr.is_word = True


if __name__ == '__main__':
    obj = Solution()
    board = [["a", "b"]]
    words = ["a", "b"]

    print(obj.findWords(board, words))

    board = [["a", "a"]]
    words = ["aaa"]
    print(obj.findWords(board, words))
    board = [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]]
    words = ["oa", "oaa"]
    print(obj.findWords(board, words))
