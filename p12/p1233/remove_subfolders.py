from typing import List


class Solution:
    """
    Oct 27, 2024 16:35
    Time Complexity: O(nlogn)
    Space Complexity: O(1)
    """

    def removeSubfolders(self, folder: List[str]) -> List[str]:
        folder.sort()

        result = []
        for f in folder:
            if not result or not f.startswith(result[-1] + '/'):
                result.append(f)

        return result
