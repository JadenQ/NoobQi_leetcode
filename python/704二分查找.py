# -*- coding: utf-8 -*-
"""
Created on Mon Oct 19 16:42:02 2020

@author: Jaden
"""
# while 循环判断条件很关键，left < right 时候，要在某一个条件下输出
# left <= right 条件下，可以保证只有一个元素的时候正确输出
# while内部的if进行判断，如果有数值就直接返回，不满足任何情况时，在left > right之后就返回-1

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid_label = left + (right - left) // 2
            mid = nums[mid_label]
            if target > mid:
                left = mid_label + 1
            elif target < mid:
                right = mid_label - 1
            elif target == mid:
                return mid_label
        return -1