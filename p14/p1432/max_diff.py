class Solution:
    """
    Jun 15, 2025 11:02
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def maxDiff(self, num: int) -> int:
        num_str = str(num)
        max_digit = ""
        for c in num_str:
            if c != '9':
                max_digit = c
                break
        if max_digit:
            max_num = int(num_str.replace(max_digit, '9'))
        else:
            max_num = num

        min_digit = ""
        new_digit = ""
        for i in range(len(num_str)):
            c = num_str[i]
            if c != '1' and c != '0':
                min_digit = c
                if i != 0:
                    new_digit = '0'
                else:
                    new_digit = '1'
                break
        if min_digit:
            min_num = int(num_str.replace(min_digit, new_digit))
        else:
            min_num = num
        return max_num - min_num


if __name__ == '__main__':
    sol = Solution()
    num = 111
    print(sol.maxDiff(num))
    num = 555
    print(sol.maxDiff(num))
    num = 1101057
    print(sol.maxDiff(num))
