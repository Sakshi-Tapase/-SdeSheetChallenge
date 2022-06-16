class Solution {
    List<Integer> list = new ArrayList<>();
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        // When we traverse in inorder travel, we get a sorted list
        // we can use this to our advantage and run a two pointer approach
        dfs(root);    
        
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            int val1 = list.get(i);
            int val2 = list.get(j);
            if(val1 + val2 == k) return true;
            else if(val1 + val2 < k) i++;
            else j--;
        }
        
        return false;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
