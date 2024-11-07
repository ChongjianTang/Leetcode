class Solution:
    """
    Nov 02, 2024 18:02
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def isCircularSentence(self, sentence: str) -> bool:
        words = sentence.split()
        prev = words[-1][-1]
        for word in words:
            if word[0] == prev:
                prev = word[-1]
            else:
                return False

        return True
