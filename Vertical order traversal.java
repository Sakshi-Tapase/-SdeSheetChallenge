class Solution {
    
       public static class Pair implements Comparable<Pair> {
        int val, row, col;

        public Pair(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.row == o.row) return this.val - o.val;
            return this.row - o.row;
        }
    }
  
    static HashMap<Integer, List<Pair>> map = new HashMap<>();
    static int min = 0;
    static int max = 0;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> fans = new ArrayList<>();
        map = new HashMap<>();
        min = 0;
        max = 0;
        traverse(root, 0, 0);
        for (int i = min; i <= max; i++) {
            List<Pair> nl = map.get(i);
            Collections.sort(nl);
            List<Integer> ans = new ArrayList<>();
            for (Pair p : nl) ans.add(p.val);
            fans.add(ans);
        }
        return fans;
    }

    public static void traverse(TreeNode root, int row, int col) {
        if (root == null) return;

        min = Math.min(min, col);
        max = Math.max(max, col);

        if (map.containsKey(col)) {
            map.get(col).add(new Pair(root.val, row, col));
        } else {
            List<Pair> nl = new ArrayList<>();
            nl.add(new Pair(root.val, row, col));
            map.put(col, nl);
        }
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}
