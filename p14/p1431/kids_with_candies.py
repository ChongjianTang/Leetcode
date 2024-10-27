class Solution:
    """
    Oct 20, 2024 15:13
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        max_candy = -float('inf')
        for candy in candies:
            if candy > max_candy:
                max_candy = candy

        result = []
        for candy in candies:
            if candy + extraCandies >= max_candy:
                result.append(True)
            else:
                result.append(False)

        return result