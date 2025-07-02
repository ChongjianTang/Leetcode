"""
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search.
"""


class WordDictionary:
    """
    Jun 30, 2025 16:09
    """
    class TrieNode:
        def __init__(self):
            self.is_word = False
            self.children = {}

    def __init__(self):
        self.root = self.TrieNode()

    def addWord(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = self.TrieNode()
            node = node.children[c]

        node.is_word = True

    def search(self, word: str) -> bool:
        return self.search_helper(self.root, word, 0)

    def search_helper(self, node: TrieNode, word, index) -> bool:
        if index == len(word):
            return node.is_word

        if word[index] == '.':
            for c in node.children:
                if self.search_helper(node.children[c], word, index + 1):
                    return True
            return False
        else:
            if word[index] not in node.children:
                return False

            return self.search_helper(node.children[word[index]], word, index + 1)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)

if __name__ == '__main__':
    obj = WordDictionary()
    obj.addWord("a")
    obj.addWord("a")
    print(obj.search("."))
    print(obj.search("a"))
    print(not obj.search("aa"))
    print(obj.search("a"))
    print(obj.search(".a") == False)
    print(obj.search("a.") == False)

    obj = WordDictionary()
    obj.addWord("bad")
    obj.addWord("dad")
    obj.addWord("mad")
    print(not obj.search("pad"))
    print(obj.search("bad"))
    print(obj.search(".ad"))
    print(obj.search("b.."))
