from collections import deque
from typing import List


class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        tree_dict = []
        for i in range(len(amount)):
            tree_dict.append([])

        for edge in edges:
            tree_dict[edge[0]].append(edge[1])
            tree_dict[edge[1]].append(edge[0])

        n = len(amount)
        visited = [False] * n

        queue = deque([(0, [0])])
        visited[0] = True

        a_to_b_path = []
        while queue:
            node, path = queue.popleft()
            for next_node in tree_dict[node]:
                if next_node == bob:
                    a_to_b_path = path + [next_node]
                    queue.clear()
                    break
                if not visited[next_node]:
                    queue.append((next_node, path + [next_node]))
                    visited[next_node] = True

        mid = len(a_to_b_path) // 2
        path_len = len(a_to_b_path)
        for i in range(mid):
            amount[a_to_b_path[path_len - 1 - i]] = 0
        if len(a_to_b_path) % 2 != 0:
            amount[a_to_b_path[mid]] //= 2

        stack = [(0, amount[0])]
        visited = [False] * n
        visited[0] = True

        max_profit = None
        while stack:
            node, profit = stack.pop()
            if len(tree_dict[node]) == 1 and node != 0:
                if not max_profit:
                    max_profit = profit
                else:
                    max_profit = max(max_profit, profit)
            else:
                for next_node in tree_dict[node]:
                    if not visited[next_node]:
                        stack.append((next_node, profit + amount[next_node]))
                        visited[next_node] = True

        return max_profit

# TODO: Faster

class Solution1:
    def __init__(self):
        self.bob_path = {}
        self.visited = []
        self.tree = []

    def mostProfitablePath(self, edges, bob, amount):
        n = len(amount)
        max_income = float("-inf")
        self.tree = [[] for _ in range(n)]
        self.bob_path = {}
        self.visited = [False] * n
        node_queue = deque([(0, 0, 0)])

        # Form tree with edges
        for edge in edges:
            self.tree[edge[0]].append(edge[1])
            self.tree[edge[1]].append(edge[0])

        # Find the path taken by Bob to reach node 0 and the times it takes to get there
        self.find_bob_path(bob, 0)

        # Breadth First Search
        self.visited = [False] * n
        while node_queue:
            source_node, time, income = node_queue.popleft()

            # Alice reaches the node first
            if (
                source_node not in self.bob_path
                or time < self.bob_path[source_node]
            ):
                income += amount[source_node]
            # Alice and Bob reach the node at the same time
            elif time == self.bob_path[source_node]:
                income += amount[source_node] // 2

            # Update max value if current node is a new leaf
            if len(self.tree[source_node]) == 1 and source_node != 0:
                max_income = max(max_income, income)

            # Explore adjacent unvisited vertices
            for adjacent_node in self.tree[source_node]:
                if not self.visited[adjacent_node]:
                    node_queue.append((adjacent_node, time + 1, income))

            # Mark and remove current node
            self.visited[source_node] = True

        return max_income

    # Depth First Search
    def find_bob_path(self, source_node, time):
        # Mark and set time node is reached
        self.bob_path[source_node] = time
        self.visited[source_node] = True

        # Destination for Bob is found
        if source_node == 0:
            return True

        # Traverse through unvisited nodes
        for adjacent_node in self.tree[source_node]:
            if not self.visited[adjacent_node]:
                if self.find_bob_path(adjacent_node, time + 1):
                    return True

        # If node 0 isn't reached, remove current node from path
        self.bob_path.pop(source_node, None)
        return False

if __name__ == '__main__':
    obj = Solution()
    edges = [[0, 1], [1, 2], [2, 3]]
    bob = 3
    amount = [-5644, -6018, 1188, -8502]

    print(obj.mostProfitablePath(edges, bob, amount) == -11662)
    edges = [[0, 1]]
    bob = 1
    amount = [-7280, 2350]
    print(obj.mostProfitablePath(edges, bob, amount) == -7280)

    edges = [[0, 1], [1, 2], [1, 3], [3, 4]]
    bob = 3
    amount = [-2, 4, 2, -4, 6]
    print(obj.mostProfitablePath(edges, bob, amount) == 6)
