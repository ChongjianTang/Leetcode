class ProductOfNumbers:
    """
    Feb 13, 2025 22:11
    add - Time Complexity: O(1)
    getProduct - Time Complexity: O(1)
    Space Complexity: O(n)
    """
    def __init__(self):
        self.queue = []
        self.product = 1

    def add(self, num: int) -> None:
        if num == 0:
            self.queue.clear()
            self.product = 1
        else:
            self.queue.append(self.product)
            self.product *= num

    def getProduct(self, k: int) -> int:
        if k > len(self.queue):
            return 0
        return int(self.product / self.queue[len(self.queue) - k])


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)

if __name__ == '__main__':
    obj = ProductOfNumbers()
    obj.add(3)
    obj.add(0)
    obj.add(2)
    obj.add(5)
    obj.add(4)
    print(obj.getProduct(1))
    print(obj.getProduct(2))
    print(obj.getProduct(3))
