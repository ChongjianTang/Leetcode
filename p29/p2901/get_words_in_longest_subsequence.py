from asyncore import write
from tokenize import group
from typing import List


class Solution:
    """
    May 16, 2025 15:23
    TODO: Analyze
    """
    def getWordsInLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        result = []
        words_info_dict = {}
        for i in range(len(words)):
            word = words[i]
            subsequence = [word]

            for prev_word in words_info_dict:
                if self.is_hamming_distance_one(word, prev_word) and words_info_dict[prev_word][1] != groups[i]:
                    new_subsequence = words_info_dict[prev_word][0] + [word]
                    if len(new_subsequence) > len(subsequence):
                        subsequence = new_subsequence


            words_info_dict[word] = (subsequence, groups[i])

            if len(words_info_dict[word][0]) > len(result):
                result = words_info_dict[word][0]
        return result

    def is_hamming_distance_one(self, str1, str2):
        if len(str1) != len(str2):
            return False

        differences = 0
        for c1, c2 in zip(str1, str2):
            if c1 != c2:
                differences += 1
                if differences > 1:
                    return False

        return differences == 1


if __name__ == '__main__':
    sol = Solution()

    words = ["bab", "dab", "cab"]
    groups = [1, 2, 2]
    print(sol.getWordsInLongestSubsequence(words, groups))
