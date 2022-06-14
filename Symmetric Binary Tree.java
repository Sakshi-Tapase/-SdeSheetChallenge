class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode root1, TreeNode root2){
        
        boolean res = false; 
        
        if(root1 == null && root2 == null) res= true;
        
        else if(root1 != null && root2 != null){
            
            boolean a = root1.val == root2.val;
            boolean b = isSymmetric(root1.left, root2.right);
            boolean c = isSymmetric(root1.right, root2.left);
            
            res = a && b && c;
            
        } else {
            res = false;
        }
        
        return res;
    }
}
