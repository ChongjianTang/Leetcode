"""
Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

Implement the MaxStack class:

MaxStack() Initializes the stack object.
void push(int x) Pushes element x onto the stack.
int pop() Removes the element on top of the stack and returns it.
int top() Gets the element on the top of the stack without removing it.
int peekMax() Retrieves the maximum element in the stack without removing it.
int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
You must come up with a solution that supports O(1) for each top call and O(logn) for each other call.



Example 1:

Input
["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
[[], [5], [1], [5], [], [], [], [], [], []]
Output
[null, null, null, null, 5, 5, 1, 5, 1, 5]

Explanation
MaxStack stk = new MaxStack();
stk.push(5);   // [5] the top of the stack and the maximum number is 5.
stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
stk.top();     // return 5, [5, 1, 5] the stack did not change.
stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
stk.top();     // return 1, [5, 1] the stack did not change.
stk.peekMax(); // return 5, [5, 1] the stack did not change.
stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
stk.top();     // return 5, [5] the stack did not change.


Constraints:

-107 <= x <= 107
At most 105 calls will be made to push, pop, top, peekMax, and popMax.
There will be at least one element in the stack when pop, top, peekMax, or popMax is called.
"""
import heapq


class MaxStack:
    """
    Jun 25, 2025 11:23
    Time Complexity:
        push: O(logn)
        pop: O(1)
        top: O(1)
        peekMax: O(logn)
        popMax: O(logn)
    Space Complexity: O(n)
    """

    def __init__(self):
        self.count = 0
        self.vals = set()
        self.stack = []
        self.max_heap = []

    def push(self, x: int) -> None:
        self.stack.append((x, self.count))
        heapq.heappush(self.max_heap, (-x, -self.count))
        self.vals.add(self.count)
        self.count += 1

    def pop(self) -> int:
        x, index = self.stack.pop()
        while index not in self.vals:
            x, index = self.stack.pop()

        self.vals.remove(index)
        return x

    def top(self) -> int:
        x, index = self.stack[-1]
        while index not in self.vals:
            self.stack.pop()
            x, index = self.stack[-1]

        return x

    def peekMax(self) -> int:
        x, index = self.max_heap[0]
        while -index not in self.vals:
            heapq.heappop(self.max_heap)
            x, index = self.max_heap[0]

        return -x

    def popMax(self) -> int:
        x, index = heapq.heappop(self.max_heap)
        while -index not in self.vals:
            x, index = heapq.heappop(self.max_heap)

        self.vals.remove(-index)
        return -x


# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()

if __name__ == '__main__':
    stk = MaxStack()
    stk.push(15)
    print(stk.pop() == 15)
    stk.push(1)
    stk.push(-52)
    stk.push(80)
    stk.push(-39)
    print(stk.popMax() == 80)
    stk.push(91)
    print(stk.pop() == 91)
    print(stk.pop() == -39)
    print(stk.top() == -52)
    stk.push(36)

    stk = MaxStack()
    stk.push(92)
    print(stk.peekMax() == 92)
    stk.push(54)
    print(stk.peekMax() == 92)
    stk.push(22)
    print(stk.pop() == 22)
    print(stk.pop() == 54)
    stk.push(-57)
    print(stk.peekMax() == 92)
    stk.push(-24)
    print(stk.popMax() == 92)
    print(stk.top() == -24)
    stk.push(26)
    stk.push(-71)
    print(stk.peekMax() == 26)
    print(stk.popMax() == 26)
    print(stk.popMax() == -24)

    # stk = MaxStack()
    # stk.push(5)
    # stk.push(1)
    # stk.push(5)
    # print(stk.top() == 5)
    # print(stk.popMax() == 5)
    # print(stk.top() == 1)
    # print(stk.peekMax() == 5)
    # print(stk.pop() == 1)
    # print(stk.top() == 5)
