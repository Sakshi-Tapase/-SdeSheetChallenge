public class Solution {

 

   public static int floorInBST(TreeNode<Integer> node, int x) {

TreeNode<Integer> parent = null;

       while(node!=null && node.data !=x){

           if(node.data > x){

               node = node.left;

           }else{

               parent = node;

               node = node.right;

           }

       }

       if(node==null){

           if(parent==null){

               return -1;

           }

           return parent.data;

       }

       return node.data;     

  }

}

