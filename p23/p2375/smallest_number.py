from typing import Set, List


class Solution:
    """
    Feb 17, 2025 17:21
    Backtracking
    Time Complexity: ?
    Space Complexity: ?
    """

    def smallestNumber(self, pattern: str) -> str:
        best_list = []
        self.helper(pattern, -1, set(), [], best_list)
        return ''.join(best_list)

    def helper(self, pattern: str, index: int, visited: Set[int], num_list: List[str], best_list: List[str]):
        if index == len(pattern):
            num = ''.join(num_list)
            if len(best_list) == 0:
                best_list += num_list
            elif int(num) < int(''.join(best_list)):
                best_list.clear()
                best_list += num_list.copy()

        else:
            if index == -1:
                for i in range(1, 10):
                    visited.add(i)
                    num_list.append(str(i))
                    self.helper(pattern, index + 1, visited, num_list, best_list)
                    visited.remove(i)
                    num_list.pop()

            else:
                prev = int(num_list[-1])
                if pattern[index] == 'I':
                    for i in range(prev + 1, 10):
                        if i not in visited:
                            visited.add(i)
                            num_list.append(str(i))
                            self.helper(pattern, index + 1, visited, num_list, best_list)
                            visited.remove(i)
                            num_list.pop()
                else:
                    for i in range(prev - 1, 0, -1):
                        if i not in visited:
                            visited.add(i)
                            num_list.append(str(i))
                            self.helper(pattern, index + 1, visited, num_list, best_list)
                            visited.remove(i)
                            num_list.pop()


class Solution1:
    """
    Feb 17, 2025 17:27
    Better Backtracking
    Time Complexity: ?
    Space Complexity: ?
    """

    def smallestNumber(self, pattern: str) -> str:
        return self.helper(pattern, -1, set(), [])

    def helper(self, pattern: str, index: int, visited: Set[int], num_list: List[str]) -> str:
        if index == len(pattern):
            num = ''.join(num_list)
            return num

        else:
            if index == -1:
                for i in range(1, 10):
                    visited.add(i)
                    num_list.append(str(i))
                    result = self.helper(pattern, index + 1, visited, num_list)
                    if result != "":
                        return result
                    visited.remove(i)
                    num_list.pop()

            else:
                prev = int(num_list[-1])
                if pattern[index] == 'I':
                    for i in range(prev + 1, 10):
                        if i not in visited:
                            visited.add(i)
                            num_list.append(str(i))
                            result = self.helper(pattern, index + 1, visited, num_list)
                            if result != "":
                                return result
                            visited.remove(i)
                            num_list.pop()
                else:
                    for i in range(1, prev):
                        if i not in visited:
                            visited.add(i)
                            num_list.append(str(i))
                            result = self.helper(pattern, index + 1, visited, num_list)
                            if result != "":
                                return result
                            visited.remove(i)
                            num_list.pop()

        return ""


if __name__ == '__main__':
    obj = Solution1()
    print(obj.smallestNumber("IIIDIDDD"))
