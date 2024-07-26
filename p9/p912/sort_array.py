import random
from typing import List


class Solution:
    def sortArray1(self, nums: List[int]) -> List[int]:
        """
        Jul 25, 2024 18:32
        TLE
        Quick Sort
        :param nums:
        :return:
        """
        self.helper(nums, 0, len(nums))
        return nums

    def helper(self, nums: List[int], start: int, end: int) -> None:
        if end > start:
            pivot_index = random.randint(start, end - 1)
            nums[start], nums[pivot_index] = nums[pivot_index], nums[start]
            pivot = nums[start]
            left = start + 1
            for i in range(start + 1, end):
                if nums[i] < pivot:
                    if i != left:
                        nums[i], nums[left] = nums[left], nums[i]

                    left += 1

            nums[start], nums[left - 1] = nums[left - 1], nums[start]

            self.helper(nums, start, left - 1)
            self.helper(nums, left, end)

    def sortArray(self, nums: List[int]) -> List[int]:
        """
        Jul 25, 2024 18:51
        Merge Sort
        Time Complexity: O(nlogn)
        Space Complexity: O(n)
        :param nums:
        :return:
        """
        if len(nums) > 1:
            mid = len(nums) // 2
            nums_left = self.sortArray(nums[:mid])
            nums_right = self.sortArray(nums[mid:])

            left = 0
            right = 0
            for i in range(len(nums)):
                if left == len(nums_left):
                    nums[i] = nums_right[right]
                    right += 1
                elif right == len(nums_right):
                    nums[i] = nums_left[left]
                    left += 1
                elif nums_right[right] > nums_left[left]:
                    nums[i] = nums_left[left]
                    left += 1
                else:
                    nums[i] = nums_right[right]
                    right += 1
        return nums


if __name__ == '__main__':
    s = Solution()
    nums = [5, 1, 1, 2, 0, 0]
    s.sortArray(nums)
    print(nums == [0, 0, 1, 1, 2, 5])
    nums = [5, 2, 3, 1]
    s.sortArray(nums)
    print(nums == [1, 2, 3, 5])
