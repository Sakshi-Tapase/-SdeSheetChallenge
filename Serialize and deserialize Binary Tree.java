public class Codec {

    // the easiest way to accurately read in an entire tree imo is BFS
    // because BFS gives you the exact order of the tree depth-by-depth
       
    Queue<TreeNode> q = new LinkedList<>();
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        q.add(root);
        StringBuilder sb = new StringBuilder();
        
        //bfs
        while(!q.isEmpty()) {
            TreeNode n = q.remove();
            if(n == null) {
                sb.append('X');
            } else {
                sb.append(n.val);
                q.add(n.left);
                q.add(n.right);
            }
            if(!q.isEmpty()) {
                sb.append(',');
            }
        };
        
        return sb.toString();
    }

    // Here we expect a level-order represenation of the tree
    
    // Decodes your encoded data to tree.
    int idx = 0;
    public TreeNode deserialize(String data) {

        TreeNode root = readNode(data);
        if(root != null) {
            q.add(root);
        }

        //bfs
        while(!q.isEmpty()) {
            TreeNode n = q.remove();     
            
            // left
            n.left = readNode(data);
            if(n.left != null) {
                q.add(n.left);
            }

            // right
            n.right = readNode(data);
            if(n.right != null) {
                q.add(n.right);
            }
        }
        
        return root;
    }
    
    TreeNode readNode(String data) {
        char c = data.charAt(idx++);
        int num = 0;
        int mul = 1;
        while(c != ',') {
            if(c == 'X') {
                idx++;
                return null;
            }
            if(c == '-') {
                mul = -1;
            } else {
                num = num * 10 + (c - '0');
            }
            c = data.charAt(idx++);
        }
        
        return new TreeNode(mul * num);
    }
}
