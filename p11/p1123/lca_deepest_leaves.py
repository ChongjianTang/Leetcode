# Definition for a binary tree node.
from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Apr 04, 2025 16:25
    """
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue = deque()
        node_dict = {}
        queue.append((0, root))
        node_dict[0] = root

        next_queue = deque()
        while queue:
            first_index = queue[0][0]
            i = queue[0][0]
            while queue:
                i, node = queue.popleft()
                if node.left:
                    next_queue.append((2 * i + 1, node.left))
                    node_dict[2 * i + 1] = node.left

                if node.right:
                    next_queue.append((2 * i + 2, node.right))
                    node_dict[2 * i + 2] = node.right

            if not next_queue:
                left = first_index
                right = i
                while left != right:
                    left = (left - 1) // 2
                    right = (right - 1) // 2

                return node_dict[left]

            else:
                queue = next_queue.copy()
                next_queue.clear()

        return None


if __name__ == '__main__':
    obj = Solution()
    root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left.left = TreeNode(6)
    root.left.right = TreeNode(2)
    root.right.left = TreeNode(0)
    root.right.right = TreeNode(8)
    root.left.right.left = TreeNode(7)
    root.left.right.right = TreeNode(4)
    print(obj.lcaDeepestLeaves(root).val)
