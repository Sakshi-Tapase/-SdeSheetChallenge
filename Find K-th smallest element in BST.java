class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        inOrderTraversal(root , list);
        
        return list.get(k-1);
        
    }
    
    void inOrderTraversal(TreeNode root , ArrayList<Integer>list){
        if(root == null)return;
        inOrderTraversal(root.left ,list);
        list.add(root.val);
        inOrderTraversal(root.right , list);
    }
}
