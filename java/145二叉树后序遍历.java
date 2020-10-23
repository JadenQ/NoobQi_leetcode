/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // 递归
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }
    // 递归函数
    public void postorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}

// 迭代1： 入栈添加，需要先加入结果。
import java.util.Collections;
class Solution{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        
        TreeNode cur = root;
        while(cur != null || !stk.isEmpty()){
            while(cur != null){
                res.add(cur.val);
                stk.push(cur);
                cur = cur.right;
            }
            cur = stk.pop();
            cur = cur.left;
        }
        Collections.reverse(res);
        return res;
    }
}

// 迭代2： 出栈
import java.util.Collections;
class Solution{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        if(root == null){
            return res;
        }
        stk.push(root);
        TreeNode cur = root;
        while(!stk.isEmpty()){
            cur = stk.pop();
            res.add(cur.val);
            // 当有左/右节点时，左/右节点先放进来，保证根节点最后被加入 - DFS
            if(cur.left != null){
                stk.push(cur.left);
            }
            if(cur.right != null){
                stk.push(cur.right);
            }
        
        }
        Collections.reverse(res);
        return res;
    }
}
