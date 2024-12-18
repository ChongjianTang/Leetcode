from typing import List
import heapq


class Solution:
    """
    Nov 11, 2024 18:23
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        heap = []
        sorted_queries = sorted(queries)
        for item in items:
            heapq.heappush(heap, (item[0], -item[1], item))

        map = {}
        max_beauty = 0
        for query in sorted_queries:
            while heap and heap[0][0] <= query:
                item = heapq.heappop(heap)[2]
                max_beauty = max(max_beauty, item[1])

            map[query] = max_beauty

        result = []
        for query in queries:
            result.append(map[query])

        return result


if __name__ == '__main__':
    sol = Solution()
    items = [[1, 2], [3, 2], [2, 4], [5, 6], [3, 5]]
    queries = [1, 2, 3, 4, 5, 6]
    print(sol.maximumBeauty(items, queries))
