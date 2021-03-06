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
    public void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>(); 
        inorder(root, res);
        return res;
    }
    
}



// 迭代
class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        Deque<TreeNode> Stk = new LinkedList<TreeNode>();
        while(root != null || !Stk.isEmpty()){
            while(root != null){
                Stk.push(root);
                root = root.left;
            }
            root = Stk.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}