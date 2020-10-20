# original : 4560ms min(g) -> g[0] -> 52ms
class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        #预排序 pre-sort
        g.sort()
        s.sort()
        count = 0
        for i in range(len(s)):
            if len(g) == 0: # g被删除空
                break
            # elif min(g) > s[i]:
            elif g[0] > s[i]: # 最小胃口的都无法被s[i]满足,继续找更大的s
                continue
            else: # 删除被满足的最小胃口孩子，count+1
                # g_select = min([x for x in g if x <= s[i]])
                # g.remove(g_select)
                del(g[0])
                count = count + 1
        return count
                
# 修改1：48ms
class Solution(object):
    def findContentChildren(self, g, s):
        s.sort()
        g.sort()
        kid = 0
        i = 0
        for a in s:
            if i == len(g):
                break
            if g[i] <= a:
                 kid += 1
                 i += 1
        return kid