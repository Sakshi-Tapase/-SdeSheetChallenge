class Solution {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		Map<Integer, Integer> mp = getMap(inorder);
		return constructTree(0, n - 1, inorder, 0, n - 1, postorder, mp);
	}

	private static TreeNode constructTree(int iS, int iE, int[] inorder, int postS, int postE, int[] postorder, Map<Integer, Integer> mp) {
		if (iS > iE || postS > postE) return null;
		TreeNode root = new TreeNode(postorder[postE]);
		int ind = mp.get(root.val);
		int left = ind - iS;

		root.left = constructTree(iS, ind - 1, inorder, postS, postS + left - 1, postorder, mp);
		root.right = constructTree(ind + 1, iE, inorder, postS + left, postE - 1, postorder, mp);

		return root;
	}

	private static Map<Integer, Integer> getMap(int[] traversal) {
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < traversal.length; i++) mp.put(traversal[i], i);
		return mp;
	}
}
