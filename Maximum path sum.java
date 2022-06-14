class Solution 
{
    int ans;
    
    public int maxPathSum(TreeNode root) 
    {
        ans=root.val;
        int x=helper(root);
        return ans;
    }
    
    public int helper(TreeNode root) 
    {
        if(root==null)
        return 0;
        
        int l=helper(root.left);
        int r=helper(root.right);
        
        int left=root.val+l;
        int right=root.val+r;
        int complete=root.val+l+r;
        
        int half_part=Math.max(left,right);
        half_part=Math.max(half_part,root.val);
        
        int complete_part=Math.max(half_part,complete);
        
        ans=Math.max(ans,Math.max(half_part,complete));
        
        return half_part;
    }
}
