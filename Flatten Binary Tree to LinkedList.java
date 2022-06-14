class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode l = null;
        TreeNode r = null;
        if(root.left != null){
            l = root.left;
            flatten(l);
        }
        if(root.right != null){
            r = root.right;
            flatten(r);
        } 
        root.left = null;
        TreeNode temp = l;
        if(l != null){
            root.right = l;
        }else{
            if(r != null) root.right = r;
            return;
        }
        
        
        while(temp != null && temp.right != null) temp = temp.right;
        if(temp != null) temp.right = r;
    }
    }
