from typing import List


class Solution:
    """
    Jun 03, 2025 16:06
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxCandies(self, status: List[int], candies: List[int], keys: List[List[int]], containedBoxes: List[List[int]],
                   initialBoxes: List[int]) -> int:
        boxes_in_hand = set(initialBoxes)
        keys_in_hand = set()
        visited_box = set()
        opened_box = []
        for box_num in boxes_in_hand:
            if status[box_num] == 1:
                opened_box.append(box_num)
                visited_box.add(box_num)

        result = 0
        while opened_box:
            box_num = opened_box.pop()
            result += candies[box_num]
            for key in keys[box_num]:
                if key in boxes_in_hand and key not in visited_box:
                    opened_box.append(key)
                    visited_box.add(key)
                else:
                    keys_in_hand.add(key)

            for contained_box in containedBoxes[box_num]:
                if status[contained_box] == 1:
                    opened_box.append(contained_box)
                else:
                    if contained_box in keys_in_hand and contained_box not in visited_box:
                        opened_box.append(contained_box)
                        visited_box.add(contained_box)
                    else:
                        boxes_in_hand.add(contained_box)

        return result
