import random


class RandomizedSet:
    """
    Jun 02, 2025 15:16
    Time Complexity:
        insert: O(1)
        remove: O(1)
        getRandom: O(1)
    """

    def __init__(self):
        self.val_dict = {}
        self.val_list = []

    def insert(self, val: int) -> bool:
        if val not in self.val_dict:
            self.val_list.append(val)
            self.val_dict[val] = len(self.val_list) - 1
            return True

        return False

    def remove(self, val: int) -> bool:
        if val in self.val_dict:
            index = self.val_dict[val]
            self.val_list[index] = self.val_list[-1]
            self.val_dict[self.val_list[index]] = index
            self.val_list.pop()
            self.val_dict.pop(val)
            return True

        return False

    def getRandom(self) -> int:
        return self.val_list[random.randint(0, len(self.val_list) - 1)]


class RandomizedSet1:
    """
    Jun 02, 2025 15:07
    Time Complexity:
        insert: O(1)
        remove: O(n)
        getRandom: O(1)
    Space Complexity: O(n)
    """

    def __init__(self):
        self.val_set = set()
        self.val_list = []

    def insert(self, val: int) -> bool:
        if val not in self.val_set:
            self.val_set.add(val)
            self.val_list.append(val)
            return True

        return False

    def remove(self, val: int) -> bool:
        if val in self.val_set:
            self.val_set.remove(val)
            self.val_list.remove(val)
            return True

        return False

    def getRandom(self) -> int:
        return self.val_list[random.randint(0, len(self.val_set) - 1)]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
