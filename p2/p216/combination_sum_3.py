from typing import List


class Solution:
    """
    Feb 15, 2025 12:57
    """
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        result = []
        candidates = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        self.backtracking(candidates, 0, k, n, [], result)
        return result

    def backtracking(self, candidates: List[int], index: int, k: int, target: int, curr_list: List[int],
                     result: List[List[int]]):
        if target == 0 and k == 0:
            result.append(curr_list.copy())
        if k > 0:
            for i in range(index, len(candidates)):
                if candidates[i] <= target:
                    curr_list.append(candidates[i])
                    self.backtracking(candidates, i + 1, k - 1, target - candidates[i], curr_list, result)
                    curr_list.pop()


if __name__ == '__main__':
    obj = Solution()
    print(obj.combinationSum3(3, 7))
