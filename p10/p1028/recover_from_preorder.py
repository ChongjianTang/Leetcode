# Definition for a binary tree node.
from msilib.schema import tables
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Feb 22, 2025 00:38
    Time Complexity: O(n)
    Space Complexity: O(logn)
    """
    def recoverFromPreorder(self, traversal: str) -> Optional[TreeNode]:
        stack = []
        root = None
        dash_count = 0
        i = 0
        while i < len(traversal):
            while traversal[i] == "-":
                dash_count += 1
                i += 1

            num_list = []
            while i < len(traversal) and traversal[i] != "-":
                num_list.append(traversal[i])
                i += 1

            val = int("".join(num_list))

            if not root:
                root = TreeNode(val)
                stack.append(root)
            else:
                while len(stack) > dash_count:
                    stack.pop()
                next_node = TreeNode(val)
                if not stack[-1].left:
                    stack[-1].left = next_node
                else:
                    stack[-1].right = next_node

                stack.append(next_node)
                dash_count = 0

        return root


if __name__ == '__main__':
    obj = Solution()
    print(obj.recoverFromPreorder("1-401--349---90--88"))
