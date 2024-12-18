import string
from collections import Counter


class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        count = Counter(s)
        result = []
        curr_repeat = 0

        added = True
        while added:
            added = False
            for c in reversed(string.ascii_lowercase):
                if count[c] > 0:
                    if result == [] or result[-1] != c:
                        result.append(c)
                        count[c] -= 1
                        curr_repeat = 1
                        added = True
                        break
                    elif result[-1] == c and curr_repeat < repeatLimit:
                        result.append(c)
                        count[c] -= 1
                        curr_repeat += 1
                        added = True
                        break
                    else:
                        continue

        return "".join(result)