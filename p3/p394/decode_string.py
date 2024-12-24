from collections import deque


class Solution:
    """
    Stack
    Dec 24, 2024 12:55
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def decodeString(self, s: str) -> str:
        stack = []

        for c in s:
            if c == ']':
                repeat_str = ""
                while stack:
                    if stack[-1] != '[':
                        repeat_str = stack.pop() + repeat_str
                    else:
                        stack.pop()
                        num = 0
                        place_value = 1
                        while stack and stack[-1].isdigit():
                            num += int(stack.pop()) * place_value
                            place_value *= 10
                        repeat_str *= num
                        stack.append(repeat_str)
                        break
            else:
                stack.append(c)

        return "".join(stack)


if __name__ == '__main__':
    sol = Solution()
    s = "3[a]2[bc]"
    print(sol.decodeString(s))
