from typing import List


class Solution:
    """
    Mar 02, 2025 15:05
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def minSwaps(self, data: List[int]) -> int:
        length_of_window = sum(data)
        count = sum(data[:length_of_window])
        max_count = count
        for i in range(length_of_window, len(data)):
            delta = data[i] - data[i - length_of_window]
            count += delta

            if delta == 1:
                max_count = max(count, max_count)

        return length_of_window - max_count


if __name__ == '__main__':
    obj = Solution()
    print(obj.minSwaps([1, 0, 1, 0, 1]))
