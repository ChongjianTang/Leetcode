from typing import List


class Solution:
    """
    Nov 11, 2024 18:38
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        i = j = k = 0
        result = []
        while i < len(arr1) and j < len(arr2) and k < len(arr3):
            if arr1[i] == arr2[j] == arr3[k]:
                result.append(arr1[i])
                i += 1
                j += 1
                k += 1
            else:
                if arr1[i] <= arr2[j] and arr1[i] <= arr3[k]:
                    i += 1
                elif arr2[j] <= arr1[i] and arr2[j] <= arr3[k]:
                    j += 1
                else:
                    k += 1

        return result
