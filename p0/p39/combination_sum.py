from typing import List


class Solution:
    """
    Feb 15, 2025 01:10
    Let n be the number of candidates, T be the target value, and M be the minimal value among the candidates.
    Time Complexity: O(n^(T/M+1))
    Space Complexity: O(T/M)
    """

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        return self.backtracking(candidates, 0, target)

    def backtracking(self, candidates: List[int], index: int, target: int) -> List[List[int]]:
        result = []
        for i in range(index, len(candidates)):
            if candidates[i] == target:
                result.append([candidates[i]])
            elif candidates[i] < target:
                sub_result = self.backtracking(candidates, i, target - candidates[i])
                for combination in sub_result:
                    combination.append(candidates[i])
                    result.append(combination)

        return result
