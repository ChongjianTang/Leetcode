from typing import List

from wheel.cli.convert import convert


class Solution:
    """
    Mar 02, 2025 16:00
    """
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        event1_start = self.convert_to_min(event1[0])
        event1_end = self.convert_to_min(event1[1])
        event2_start = self.convert_to_min(event2[0])
        event2_end = self.convert_to_min(event2[1])

        return not (event1_end < event2_start or event2_end < event1_start)

    def convert_to_min(self, time: str) -> int:
        time_list = time.split(":")
        return int(time_list[0]) * 60 + int(time_list[1])
