"""
Given an array of unique strings words, return all the word squares you can build from words. The same word from words
can be used multiple times. You can return the answer in any order.

A sequence of strings forms a valid word square if the kth row and column read the same string,
where 0 <= k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both
horizontally and vertically.


Example 1:

Input: words = ["area","lead","wall","lady","ball"]
Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input: words = ["abat","baba","atan","atal"]
Output: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).


Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 4
All words[i] have the same length.
words[i] consists of only lowercase English letters.
All words[i] are unique.
"""
from asyncore import write
from typing import List


class Solution:
    """
    Jul 19, 2025 16:19
    """
    class Trie:
        class TrieNode:
            def __init__(self):
                self.is_word = False
                self.children = {}

        def __init__(self):
            self.root = self.TrieNode()

        def add_word(self, word: str):
            node = self.root
            for c in word:
                if c not in node.children:
                    node.children[c] = self.TrieNode()
                node = node.children[c]
            node.is_word = True

        def find_words_with_prefix(self, prefix: str):
            result = []
            node = self.root
            for c in prefix:
                if c not in node.children:
                    return []
                node = node.children[c]

            self.dfs(node, "", prefix, result)
            return result

        def dfs(self, node: TrieNode, curr: str, prefix: str, result: List[str]):
            if node.is_word:
                result.append(prefix + curr)

            for c in node.children:
                self.dfs(node.children[c], curr + c, prefix, result)

    def wordSquares(self, words: List[str]) -> List[List[str]]:
        trie = self.Trie()
        for word in words:
            trie.add_word(word)

        result = []
        for word in words:
            self.back_tracking([word], trie, result)

        return result

    def back_tracking(self, matrix: List[str], trie: Trie, result: List[List[str]]):
        if len(matrix) == len(matrix[0]):
            result.append(matrix.copy())
            return

        n = len(matrix)
        prefix = ""
        for i in range(n):
            prefix += matrix[i][n]

        words = trie.find_words_with_prefix(prefix)
        for word in words:
            self.back_tracking(matrix + [word], trie, result)

if __name__ == '__main__':
    obj = Solution()
    words = ["abat", "baba", "atan", "atal"]
    print(obj.wordSquares(words))
    words = ["area", "lead", "wall", "lady", "ball"]
    print(obj.wordSquares(words))