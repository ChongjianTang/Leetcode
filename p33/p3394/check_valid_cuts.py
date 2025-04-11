from typing import List


class Solution:
    """
    Mar 25, 2025 13:48
    """
    def checkValidCuts(self, n: int, rectangles: List[List[int]]) -> bool:
        x_coordinates = [[rectangle[0], rectangle[2]] for rectangle in rectangles]
        y_coordinates = [[rectangle[1], rectangle[3]] for rectangle in rectangles]

        sorted_xs = sorted(x_coordinates, key=lambda x: x[0])
        sorted_ys = sorted(y_coordinates, key=lambda y: y[0])

        prev = sorted_xs[0][1]

        count = 1
        for i in range(1, len(sorted_xs)):
            if sorted_xs[i][0] < prev:
                prev = max(prev, sorted_xs[i][1])
            else:
                count += 1
                if count == 3:
                    return True
                prev = sorted_xs[i][1]

        prev = sorted_ys[0][1]
        count = 1
        for i in range(1, len(sorted_ys)):
            if sorted_ys[i][0] < prev:
                prev = max(prev, sorted_ys[i][1])
            else:
                count += 1
                if count == 3:
                    return True
                prev = sorted_ys[i][1]

        return False


if __name__ == '__main__':
    obj = Solution()
    rectangles = [[1, 0, 5, 2], [0, 2, 2, 4], [3, 2, 5, 3], [0, 4, 4, 5]]
    print(obj.checkValidCuts(5, rectangles))
