
public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

       int ceil = -1;
        while(node != null){
            if(x == node.data){
                ceil = node.data;
                return ceil;
            }
            if(x < node.data){
                ceil = node.data;
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return ceil;

    }
}
