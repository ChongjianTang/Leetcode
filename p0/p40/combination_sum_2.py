from typing import List


class Solution:
    """
    Feb 15, 2025 01:46
    """
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        return self.backtracking(candidates, 0, target)

    def backtracking(self, candidates: List[int], index: int, target: int) -> List[List[int]]:
        result = []
        i = index
        while i < len(candidates):
            if candidates[i] == target:
                result.append([candidates[i]])
            elif candidates[i] < target:
                sub_result = self.backtracking(candidates, i + 1, target - candidates[i])
                for combination in sub_result:
                    combination.append(candidates[i])
                    result.append(combination)
            while i + 1 < len(candidates) and candidates[i + 1] == candidates[i]:
                i += 1
            i += 1

        return result


if __name__ == '__main__':
    obj = Solution()
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    print(obj.combinationSum2(candidates, target))
