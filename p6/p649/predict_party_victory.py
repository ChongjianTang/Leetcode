from collections import deque


class Solution:
    """
    Dec 24, 2024 13:11
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def predictPartyVictory(self, senate: str) -> str:
        queue = deque()
        senate = deque(senate)
        while senate:
            senator = senate.popleft()
            if not queue:
                queue.append(senator)
            else:
                if queue[0] == senator:
                    queue.append(senator)
                else:
                    senate.append(queue.popleft())

        if queue[0] == 'R':
            return 'Radiant'
        else:
            return 'Dire'
