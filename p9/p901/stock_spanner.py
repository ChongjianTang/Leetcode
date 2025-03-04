class StockSpanner:
    """
    Mar 02, 2025 23:40
    Time Complexity:
        next - O(1)
    Space Complexity: O(n)
    """

    def __init__(self):
        self.data = []
        self.span = []

    def next(self, price: int) -> int:
        if not self.data:
            self.data.append(price)
            self.span.append(1)
        else:
            i = len(self.data) - 1
            while i >= 0 and self.data[i] <= price:
                i = i - self.span[i]

            self.data.append(price)
            self.span.append(len(self.data) - 1 - i)

        return self.span[-1]


class StockSpanner1:
    """
    Mar 02, 2025 23:47
    Time Complexity:
        next - O(1)
    Space Complexity: O(n)
    """

    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        span = 1
        while self.stack and self.stack[-1][1] <= price:
            span += self.stack.pop()[0]

        self.stack.append([span, price])
        return span


if __name__ == '__main__':
    obj = StockSpanner()
    prices = [100, 80, 60, 70, 60, 75, 85]
    for price in prices:
        print(obj.next(price))

# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
