#迭代
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for i in nums:
            result = result + [[i] + num for num in result]

        return result
#递归
class Solution:
    def subsets(self, nums:List[int]) -> List[List[int]]:
        result = []
        n = len(nums)
        # 回溯函数
        def combination(i, temp):
            result.append(temp)
            for j in range(i, n):
                combination(j+1, temp + [nums[j]])

        combination(0, [])
        return result