"""
You have n bulbs in a row numbered from 1 to n. Initially, all the bulbs are turned off. We turn on exactly one bulb every day until all bulbs are on after n days.

You are given an array bulbs of length n where bulbs[i] = x means that on the (i+1)th day, we will turn on the bulb at position x where i is 0-indexed and x is 1-indexed.

Given an integer k, return the minimum day number such that there exists two turned on bulbs that have exactly k bulbs between them that are all turned off. If there isn't such day, return -1.



Example 1:

Input: bulbs = [1,3,2], k = 1
Output: 2
Explanation:
On the first day: bulbs[0] = 1, first bulb is turned on: [1,0,0]
On the second day: bulbs[1] = 3, third bulb is turned on: [1,0,1]
On the third day: bulbs[2] = 2, second bulb is turned on: [1,1,1]
We return 2 because on the second day, there were two on bulbs with one off bulb between them.
Example 2:

Input: bulbs = [1,2,3], k = 1
Output: -1


Constraints:

n == bulbs.length
1 <= n <= 2 * 104
1 <= bulbs[i] <= n
bulbs is a permutation of numbers from 1 to n.
0 <= k <= 2 * 104
"""
from typing import List

# TODO More Methods

class Solution:
    """
    Jun 23, 2025 15:34
    Time Complexity: O(n^2)
    Space Complexity: O(n)

    """
    def kEmptySlots(self, bulbs: List[int], k: int) -> int:
        result = [0 for _ in bulbs]
        for day in range(len(bulbs)):
            i = bulbs[day]
            result[i - 1] = 1
            flag = True
            for j in range(k):
                if i + j == len(bulbs) or result[i + j] == 1:
                    flag = False
                    break

            if flag and i + k < len(bulbs) and result[i + k] == 1:
                return day + 1

            flag = True
            for j in range(k):
                if i - 2 - j == -1 or result[i - 2 - j] == 1:
                    flag = False
                    break

            if flag and i - 2 - k >= 0 and result[i - 2 - k] == 1:
                return day + 1

        return -1


if __name__ == '__main__':
    sol = Solution()
    bulbs = [1, 2, 3]
    k = 1
    print(sol.kEmptySlots(bulbs, k) == -1)

    bulbs = [1, 3, 2]
    k = 1
    print(sol.kEmptySlots(bulbs, k) == 2)
