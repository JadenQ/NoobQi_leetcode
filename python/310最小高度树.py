class Solution(object):
    def findMinHeightTrees(n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        # 用来保存结果
        res = []
        # 仅有一个元素的情况
        if n == 1:
            res.append(0)
            return res
        # 统计各个节点的度 & graph保存每个节点的邻居
        degree = [0 for x in range(n)]
        graph = [[] for _ in range(n)]
        
        for edge in edges:
            degree[edge[0]] += 1
            degree[edge[1]] += 1
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
    
        # queue用来保存每一次最外层节点
        queue = []
        for i in range(n):
            if degree[i] == 1:
                queue.append(i)
    
        while(len(queue) != 0):
            res = []
            size = len(queue)
            # 外层每一个节点都存为res，直到循环结束
            for j in range(size):
                cur = queue[0]
                del queue[0]
                res.append(cur)
                # 取出
                neighbors = graph[cur]
                # BFS
                for neighbor in neighbors:
                    degree[neighbor] -= 1
                    if degree[neighbor] == 1:
                        queue.append(neighbor)
        return res
    
    
#n = 6
#edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

#print(findMinHeightTrees(n, edges))



        
            


            