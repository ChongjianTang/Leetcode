from typing import List, Optional


class Solution:
    """
    Feb 23, 2025 01:45
    """

    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        trie = Trie()
        for word in products:
            trie.insert(word)

        result = []
        prefix = []
        for c in searchWord:
            prefix.append(c)
            result.append(trie.start_with(''.join(prefix)))

        return result


class TrieNode:
    def __init__(self):
        self.is_word = False
        self.children: List[Optional[TrieNode]] = [None] * 26


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not curr.children[index]:
                curr.children[index] = TrieNode()
            curr = curr.children[index]

        curr.is_word = True

    def start_with(self, prefix):
        curr = self.root
        result = []
        for c in prefix:
            index = ord(c) - ord('a')
            if not curr.children[index]:
                return result
            else:
                curr = curr.children[index]

        self.dfs(curr, list(prefix), result)
        return result

    def dfs(self, node: TrieNode, word: List[str], result: List[str]):
        if len(result) == 3:
            return
        if node.is_word:
            result.append(''.join(word))

        for i in range(26):
            if node.children[i]:
                word.append(chr(i + ord('a')))
                self.dfs(node.children[i], word, result)
                word.pop()
                if len(result) == 3:
                    return
        return

# TODO

if __name__ == '__main__':
    obj = Solution()
    print(obj.suggestedProducts(["mobile", "mouse", "moneypot", "monitor", "mousepad"], "mouse"))
