# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # 迭代1 只考虑stack出栈，保证左，右，根的顺序
        res = []
        stk = [root]
        if not root:
            return res
        while stk:
            cur = stk.pop()
            res.append(cur.val)
            if cur.left:
                stk.append(cur.left)
            if cur.right:
                stk.append(cur.right)
        return res[::-1]

        #迭代2 考虑入栈
        res = []
        if not root:
            return res
        cur = root
        stk = []
        while cur or stk:
            while cur:
                res.append(cur.val)
                stk.append(cur)
                cur = cur.right
            cur = stk.pop()
            cur = cur.left
        return res[::-1]