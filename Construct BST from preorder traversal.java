class Solution {
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        return construct(preorder,min,max);
    }
    public TreeNode construct(int[] preorder,int min,int max){
        if(idx>=preorder.length){
            return null;
        }
        if(max>preorder[idx]&&min<preorder[idx]){
            TreeNode root=new TreeNode();
            root.val=preorder[idx];
            idx++;
            
        root.left=construct(preorder,min,root.val);
        root.right=construct(preorder,root.val,max);
             return root;
        }else{
            return null;
        }
       
    }
}
