# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        # 递归
        # def inorder(root):
        #     if not root:
        #         return []
            
        #     inorder(root.left)
        #     ans.append(root.val)
        #     inorder(root.right)
        
        # ans = []
        # inorder(root)
        # return ans

        # 迭代
        ans = []
        stack = []

        # 空root
        if root == None:
            return ans

        while stack or root:
            while root:
                stack.append(root) # 添加根节点
                root = root.left  # 将root移动，移动到左节点，将左节点全部遍历
            temp = stack.pop() # 取出stack中缓存的节点
            ans.append(temp.val) # 将节点值存到ans中
            root = temp.right # 从此刻起向右转向一次
        return ans
