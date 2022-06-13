class Solution {
    List<Integer> h= new ArrayList<Integer>();
    
    public List<Integer> postorderTraversal(TreeNode root){
        int a;
        if(root!=null)
        {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            h.add(root.val);
        }
     return h;
    }
}
