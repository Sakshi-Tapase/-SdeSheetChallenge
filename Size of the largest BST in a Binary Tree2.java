class Solution {
    class Pair {
        boolean isBst;
        int min, max, sum;
        Pair() {}
        Pair (boolean isBst, int min, int max, int sum) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    
    int answer = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        findMax(root);
        return answer < 0 ? 0 : answer;
    }
    
    public Pair findMax(TreeNode root) {
        if (root == null) {
            return new Pair(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Pair myPair = new Pair();
        Pair l = findMax(root.left);
        Pair r = findMax(root.right);
		//  checking if the subtree with this root is BST or NOT
        myPair.isBst = l.isBst && r.isBst && (root.val > l.max && root.val < r.min);
        //  updating the max ans min
		myPair.min = Math.min(l.min, Math.min(root.val, r.min));
        myPair.max = Math.max(l.max, Math.max(root.val, r.max));
        myPair.sum = l.sum + r.sum + root.val;
        //  if isBst update the answer
		if (myPair.isBst) {
            answer = Math.max(answer, myPair.sum);
        }
        return myPair;
    }
}
