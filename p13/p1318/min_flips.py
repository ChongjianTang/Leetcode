class Solution:
    """
    Feb 22, 2025 23:40
    Time Complexity: O(log(max(a,b,c)))
    Space Complexity: O(1)
    """

    def minFlips(self, a: int, b: int, c: int) -> int:
        length = len(format(max(a, b, c), 'b'))
        bin_a, bin_b, bin_c = format(a, f'0{length}b'), format(b, f'0{length}b'), format(c, f'0{length}b')

        count = 0
        for i in range(length):
            if bin_c[i] == '0':
                if bin_a[i] == '1':
                    count += 1
                if bin_b[i] == '1':
                    count += 1

            else:
                if bin_a[i] == '0' and bin_b[i] == '0':
                    count += 1

        return count


class Solution1:
    """
    Feb 22, 2025 23:47
    Time Complexity: O(log(max(a,b,c)))
    Space Complexity: O(1)
    """

    def minFlips(self, a: int, b: int, c: int) -> int:
        count = 0
        while a > 0 or b > 0 or c > 0:
            bit_a = a & 1
            bit_b = b & 1
            bit_c = c & 1

            if bit_c == 0:
                count += bit_a + bit_b
            else:
                if bit_a + bit_b == 0:
                    count += 1

            a >>= 1
            b >>= 1
            c >>= 1
        return count
