package practise.leetcode;
//Leet code - 108
class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
	   void printTree(TreeNode node){
		   if(node==null)
			   return;
		   printTree(node.left);
		   System.out.print(node.val+" ");
		   printTree(node.right);
	   }
	 }

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	public TreeNode convert(int[] nums){
		return convertHelper(nums,0,nums.length-1);
	}

	private TreeNode convertHelper(int[] nums, int start, int end) {
		int mid;
		if(end<start)
			return null;
		mid = (start+end)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = convertHelper(nums, start, mid-1);
		node.right = convertHelper(nums, mid+1, end);
		return node;
	}
	public static void main(String[] args) {
		Convert_Sorted_Array_to_Binary_Search_Tree converter = new Convert_Sorted_Array_to_Binary_Search_Tree();
		TreeNode root = converter.convert(new int[]{-10,-3,0,5,9});
		root.printTree(root);		
	}
}