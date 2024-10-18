class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        # Convert the number to a list of digits
        num_str = list(str(num))
        # Initialize array to store the last position of each digit 0-9
        last = {int(x): i for i, x in enumerate(num_str)}

        # Traverse the number's digits
        for i, digit in enumerate(num_str):
            # Check from the largest digit to the current digit if we can swap to get a larger number
            for d in range(9, int(digit), -1):
                if d in last and last[d] > i:
                    # Swap the current digit with the larger digit found at a later position
                    num_str[i], num_str[last[d]] = num_str[last[d]], num_str[i]
                    # Return the new number formed after the swap
                    return int(''.join(num_str))

        # If no swap is done, return the original number
        return num
