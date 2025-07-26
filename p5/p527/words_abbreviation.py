"""
Given an array of distinct strings words, return the minimal possible abbreviations for every word.

The following are the rules for a string abbreviation:

The initial abbreviation for each word is: the first character, then the number of characters in between, followed by the last character.
If more than one word shares the same abbreviation, then perform the following operation:
Increase the prefix (characters in the first part) of each of their abbreviations by 1.
For example, say you start with the words ["abcdef","abndef"] both initially abbreviated as "a4f". Then, a sequence of operations would be ["a4f","a4f"] -> ["ab3f","ab3f"] -> ["abc2f","abn2f"].
This operation is repeated until every abbreviation is unique.
At the end, if an abbreviation did not make a word shorter, then keep it as the original word.


Example 1:

Input: words = ["like","god","internal","me","internet","interval","intension","face","intrusion"]
Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
Example 2:

Input: words = ["aa","aaa"]
Output: ["aa","aaa"]


Constraints:

1 <= words.length <= 400
2 <= words[i].length <= 400
words[i] consists of lowercase English letters.
All the strings of words are unique.
"""
from typing import List


class Solution:
    """
    Jul 23, 2025 10:22
    """
    class TrieNode:
        def __init__(self):
            self.leaf_count = 0
            self.children = {}
            self.index = -1
            self.depth = 0

    def add_word(self, root: TrieNode, word: str, index: int):
        curr = root
        for c in word:
            c += word[-1]
            curr.leaf_count += 1
            curr.index = index
            if c not in curr.children:
                curr.children[c] = self.TrieNode()
                curr.children[c].depth = curr.depth + 1
            curr = curr.children[c]

        curr.index = index

    def wordsAbbreviation(self, words: List[str]) -> List[str]:
        result = ["" for _ in range(len(words))]
        roots = {}
        for i in range(len(words)):
            word = words[i]
            if len(word) not in roots:
                roots[len(word)] = self.TrieNode()
            self.add_word(roots[len(word)], word, i)

        for length in roots:
            root = roots[length]
            stack = [root]
            while stack:
                node = stack.pop()
                if node.leaf_count == 1 and node != root:
                    index = node.index
                    result[index] = self.get_abbr(words[index], node.depth)
                else:
                    for c in node.children:
                        stack.append(node.children[c])
        return result

    def get_abbr(self, word, prefix_len):
        if prefix_len >= len(word) - 2:
            return word

        middle_len = len(word) - prefix_len - 1
        return word[:prefix_len] + str(middle_len) + word[-1]


if __name__ == '__main__':
    obj = Solution()
    words = ["abcdefg", "abccefg", "abcckkg"]
    print(obj.wordsAbbreviation(words))

    words = ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
    print(obj.wordsAbbreviation(words))
