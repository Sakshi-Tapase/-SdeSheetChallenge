public boolean isValidBST(TreeNode root) {
long min=Long.MIN_VALUE;
long max=Long.MAX_VALUE;
return check(root,min,max);

}
public boolean check(TreeNode root,long min,long max){
    if(root==null){
        return true;
    }
    
    
    return (root.val>min && root.val<max) &&check(root.left,min,root.val) && check(root.right,root.val,max);
}
