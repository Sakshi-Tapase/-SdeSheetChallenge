class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node a=q.poll();
            if(a==null && q.isEmpty())
                return root;
            else if(a==null){
                q.offer(null);
                continue;
            }
            else{
                a.next=q.peek();
                if(a.left!=null)
                    q.offer(a.left);
                if(a.right!=null)
                    q.offer(a.right);
            }
        }
        return root;
        
        
    }
}
