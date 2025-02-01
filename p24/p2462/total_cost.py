import heapq
from typing import List


class Solution:
    """
    Heap
    Jan 31, 2025 15:46
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        if 2 * candidates >= len(costs):
            return sum(sorted(costs)[:k])

        left = candidates - 1
        right = len(costs) - candidates
        heap = [(costs[i], i) for i in range(left + 1)] + [(costs[i], i) for i in range(right, len(costs))]

        heapq.heapify(heap)

        total_cost = 0
        for i in range(k):
            cost, index = heapq.heappop(heap)
            total_cost += cost
            if left + 1 < right:
                if index <= left:
                    left += 1
                    heapq.heappush(heap, (costs[left], left))
                else:
                    right -= 1
                    heapq.heappush(heap, (costs[right], right))

        return total_cost


if __name__ == '__main__':
    sol = Solution()
    print(sol.totalCost([1, 2, 4, 1], 3, 3) == 4)
    print(sol.totalCost([17, 12, 10, 2, 7, 2, 11, 20, 8], 3, 4) == 11)
