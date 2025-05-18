class Logger:
    """
    May 14, 2025 16:54
    Time Complexity: O(1)
    Space Complexity: O(M)
        - M is the size of all msg
    """

    def __init__(self):
        self.msg_dict = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.msg_dict:
            self.msg_dict[message] = timestamp + 10
            return True
        else:
            if self.msg_dict[message] <= timestamp:
                self.msg_dict[message] = timestamp + 10
                return True
            else:
                return False

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
