import java.util.*;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {

		if(root==null || key<0) {
			ArrayList<Integer> ans= new ArrayList<Integer>();
			ans.add(-1);
			ans.add(-1);
			return ans;
		}


		HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> map= mapto_parent(root);
		//ArrayList<Integer> ans= new ArrayList<Integer>();
		ArrayList<Integer> ans= predecessorSuccessorhelper(root,map,key);
        
        
        
		return ans;


	}

	private static ArrayList<Integer> predecessorSuccessorhelper(BinaryTreeNode<Integer> root,
			HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map,int key) {


		if(root==null || key<0) {
			
			ArrayList<Integer> ans= new ArrayList<Integer>(2);
        
            ans.add(-1);	
            ans.add(-1);
            return ans;
		}



		if(root.data==key) {

			//left
			ArrayList<Integer> ans= new ArrayList<Integer>(2);
			if(root.left!=null) {
				ans.add(root.left.data);
			}else if(map.containsKey(root)){

				BinaryTreeNode<Integer> parent=map.get(root);
				if(parent.data<root.data) {
					ans.add(parent.data);
				}else {
                    ans.add(-1);
                }
			}else {
                    ans.add(-1);
            }

			//right
			if(root.right!=null) {
				ans.add(root.right.data);
			}else if(map.containsKey(root)){

				BinaryTreeNode<Integer> parent=map.get(root);
				if(parent.data>root.data) {
					ans.add(parent.data);
				}else {
                    ans.add(-1);
                }


			}else {
                    ans.add(-1);
            }




			return ans;

		}

		else if(key<root.data) {
			ArrayList<Integer> leftans=predecessorSuccessorhelper(root.left,map,key);
			if(leftans.size()>0 && leftans!=null) {
				return leftans;
			}
		}else {
			ArrayList<Integer> rightans=predecessorSuccessorhelper(root.right,map,key);
			if(rightans.size()>0  && rightans!=null) {
				return rightans;
			}
		}
        
		
        return null;    


	}

	private static HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> mapto_parent(
			BinaryTreeNode<Integer> root) {
		HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> map= new HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>>();

		Queue<BinaryTreeNode<Integer>> q1= new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			BinaryTreeNode<Integer> front = q1.poll();
			if(front.left!=null) {
				map.put(front.left,front);
				q1.add(front.left);
			}
			if(front.right!=null) {
				map.put(front.right,front);
				q1.add(front.right);
			}
		}
		return map;
	}
}
