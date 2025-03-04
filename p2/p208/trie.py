class Trie:
    """
    Feb 23, 2025 00:29
    """
    class TrieNode:
        def __init__(self):
            self.is_word = False
            self.children = {}

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = self.TrieNode()
            curr = curr.children[c]

        curr.is_word = True

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if c in curr.children:
                curr = curr.children[c]
            else:
                return False

        return curr.is_word

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if c in curr.children:
                curr = curr.children[c]
            else:
                return False

        return True


if __name__ == '__main__':
    trie = Trie()

    trie.insert('apple')
    print(trie.search('apple') == True)
    print(trie.search('app') == False)
