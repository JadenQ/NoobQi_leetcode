# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

# 遍历法 ： 超出时间限制
# class Solution:
#     def guessNumber(self, n):
#         pick = 1
#         while guess(pick) != 0:
#             pick = pick + 1
#         return pick

# 二分查找法
class Solution:
    def guessNumber(self, n: int) -> int:
        left = 1
        right = n
        while left < right:
            # 中位数
            mid = (left + right) >> 1
            if guess(mid) == 1:
                left = mid + 1
            elif guess(mid) == -1:
                right = mid
            else:
                return mid
        return left



