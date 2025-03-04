class Solution:
    """
    Mar 03, 2025 18:50
    """
    def checkPowersOfThree(self, n: int) -> bool:
        while n > 0:
            if n % 3 == 2:
                return False
            n //= 3

        return True
