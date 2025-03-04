# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Feb 22, 2025 23:27
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        root = TreeNode(preorder[0])
        if len(preorder) == 1:
            return root

        if preorder[1] == postorder[-2]:
            root.left = self.constructFromPrePost(preorder[1:], postorder[:-1])
        else:
            right_val = postorder[-2]
            left_val = preorder[1]

            right_val_index_in_preorder = 0
            left_val_index_in_postorder = 0
            for i in range(len(preorder)):
                if preorder[i] == right_val:
                    right_val_index_in_preorder = i
                if postorder[i] == left_val:
                    left_val_index_in_postorder = i

            root.left = self.constructFromPrePost(preorder[1:right_val_index_in_preorder],
                                                  postorder[:left_val_index_in_postorder + 1])
            root.right = self.constructFromPrePost(preorder[right_val_index_in_preorder:],
                                                   postorder[left_val_index_in_postorder + 1:-1])

        return root


if __name__ == '__main__':
    obj = Solution()
    preorder = [2, 1, 3]

    postorder = [3, 1, 2]

    obj.constructFromPrePost(preorder, postorder)
