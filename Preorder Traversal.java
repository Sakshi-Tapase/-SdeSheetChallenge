class Solution {
    List<Integer> h= new ArrayList<Integer>();
    
    public List<Integer> preorderTraversal(TreeNode root){
        int a;
        if(root!=null)
        {
            h.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return h;
    }
}
