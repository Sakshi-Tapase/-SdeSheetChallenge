class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
       Map<Integer,Integer>map=new HashMap<>();
        
       for(int i=0; i<inorder.length; i++){
           map.put(inorder[i],i);
       }
        return createBT(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    TreeNode createBT(int [] pre, int ps, int pe, int [] in, int is,int ie, Map<Integer,Integer>map){
        
        if(ps>pe || is>ie)return null;
        
        TreeNode node=new TreeNode(pre[ps]);
        
        int ind=map.get(pre[ps]);
        int ran=ind - is;
        
        node.left=createBT(pre,ps+1,ps+ran,in,is,ind-1,map);
        node.right=createBT(pre,ps+ran+1,pe,in,ind+1,ie,map);
        
        return node;
    }
}
