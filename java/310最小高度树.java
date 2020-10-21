class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }

        /*出度*/
        int[] degree = new int[n];
        /*图：统计边的关系 - 二维数组*/
        List<List<Integer>> map = new ArrayList<>();
        /*map设置为二维数组*/
        for(int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        /*根据edge添加map信息*/
        
        for(int[] edge : edges){
            degree[edge[0]] ++;
            degree[edge[1]] ++;
            map.get(edge[0]).add(edge[1]); //get获取列表中的元素
            map.get(edge[1]).add(edge[0]);
        }
        /*建立队列保存叶子节点一层*/
        Queue<Integer> queue = new LinkedList<>();
        /*出度为1：叶子节点节点加入queue*/
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) queue.offer(i);
        }
        while(!queue.isEmpty()){
            res = new ArrayList<>(); //每循环一次保存一次结果
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                /*BFS*/
                for(int neighbor : neighbors){
                    degree[neighbor] --;
                    if(degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}

/*
Queue的操作：

offer，add 区别：

一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。

这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。

poll，remove 区别：

remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。

peek，element区别：

element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
*/