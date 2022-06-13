class Solution {
    List<Integer> h= new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root){
        int a;
        if(root!=null)
        {
            inorderTraversal(root.left);
            h.add(root.val);
            inorderTraversal(root.right);
        }    
     return h;
    }
}
