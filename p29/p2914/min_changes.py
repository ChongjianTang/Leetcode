class Solution:
    """
    Nov 05, 2024 14:56
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def minChanges(self, s: str) -> int:
        count = 1
        is_one = s[0] == '1'
        result = 0
        first_even = False
        for i in range(1, len(s)):
            if is_one and s[i] == '1':
                count += 1
            elif not is_one and s[i] == '0':
                count += 1
            else:
                if count % 2 == 1:
                    first_even = not first_even
                    if first_even:
                        result += 1
                else:
                    if first_even:
                        result += 1
                is_one = not is_one
                count = 1

        return result


if __name__ == '__main__':
    sol = Solution()
    s = "1001"
    print(sol.minChanges(s))
