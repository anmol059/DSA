import java.util.Scanner;

public class BinaryTreeUse {
	public static <T> void print(BinaryTree<T> root)
	{
		if(root == null)
		{
			return;
		}
		System.out.println(root.data);
		print(root.left);
		print(root.right);
	}
	
	public static <T> void printDetailed(BinaryTree<T> root)
	{
		if(root == null)
		{
			return;
		}
		
		System.out.print(root.data + " : ");
		if(root.left != null)
		{
			System.out.print("L " + root.left.data + ", ");
		}
		if(root.right != null)
		{
			System.out.print("R " + root.right.data);
		}
		System.out.println();
		
		
		print(root.left);
		print(root.right);
	}
	
	public static BinaryTree<Integer> takeInput()
	{
		System.out.println("Enter root data");
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		if(rootData == -1)
		{
			return null;
		}
		
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		BinaryTree<Integer> leftChild = takeInput();
		BinaryTree<Integer> rightChild = takeInput();
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	public static BinaryTree<Integer> taketTreeInputBetter(boolean isRoot, int parentData, boolean isLeft)
	{
		if(isRoot)
		{
			System.out.println("Enter root data");
		}
		else
		{
			if(isLeft)
			{
				System.out.println("Enter left child of " + parentData);
			}
			else
			{
				System.out.println("Enter right child of " + parentData);
			}
		}
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		if(rootData == -1)
		{
			return null;
		}
		
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		BinaryTree<Integer> leftChild = taketTreeInputBetter(false, rootData, true);
		BinaryTree<Integer> rightChild = taketTreeInputBetter(false, rootData, false);
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	public static int numNodes(BinaryTree<Integer> root)
	{
		// base case
		// tree is empty
		if(root == null)
		{
			return 0;
		}
		
		// PMI hypothesis
		int leftChildNodes = numNodes(root.left);
		int rightChildNodes = numNodes(root.right);
		
		// Induction step
		return 1 + leftChildNodes + rightChildNodes;
	}
	
	public static BinaryTree<Integer> removeLeafNodes(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return null;
		}
		if(root.left == null && root.right == null)
		{
			return  null;
		}
		
		root.left = removeLeafNodes(root.left);
		root.right = removeLeafNodes(root.right);
		return root;
	}
	
	public static isBalancedReturn isBalancedBetter(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			isBalancedReturn ans = new isBalancedReturn(0, true);
			return ans;
		}
		
		isBalancedReturn isLeftBalanced = isBalancedBetter(root.left);
		isBalancedReturn isRightBalanced = isBalancedBetter(root.right);
		
		boolean isBalanced = true;
		int height = 1 + Math.max(isLeftBalanced.height, isRightBalanced.height);
		
		if(Math.abs(isLeftBalanced.height - isRightBalanced.height) > 1)
		{
			isBalanced = false;
		}
		if(!isLeftBalanced.isBalanced || !isRightBalanced.isBalanced)
		{
			isBalanced = false;
		}
		isBalancedReturn ans = new isBalancedReturn(height, isBalanced);
		return ans;
	}
	
	public static boolean isBalanced(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return true;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1)
		{
			return false;
		}
		
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRightBalanced = isBalanced(root.right);
		
		return isLeftBalanced && isRightBalanced;
	}

	public static int height(BinaryTree<Integer> root) {
		if(root == null)
		{
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	

	public static int minimum(BinaryTree<Integer> root) {
		if(root == null)
		{
			return Integer.MAX_VALUE;
		}
		int leftMIN = minimum(root.left);
		int rightMIN = minimum(root.right);
		
		return Math.min(root.data, Math.min(leftMIN, rightMIN));
	}

	public static int maximum(BinaryTree<Integer> root) {
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		int leftMAX = maximum(root.left);
		int rightMAX = maximum(root.right);
		
		return Math.max(root.data, Math.max(leftMAX, rightMAX));
	}
	
	public static boolean isBST(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return true;
		}
		
		if(maximum(root.left) > root.data)
		{
			return false;
		}
		
		if(minimum(root.right) >= root.data)
		{
			return false;
		}
		
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		
		return isLeftBST && isRightBST;
	}
	
	public static isBSTReturn isBSTbetter(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			isBSTReturn ans = new isBSTReturn(0, 0, true);
			return ans;
		}
		
		isBSTReturn leftAns = isBSTbetter(root.left);
		isBSTReturn rightAns = isBSTbetter(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		
		boolean isBST = true;
		if(root.data < leftAns.max)
		{
			isBST = false;
		}
		
		if(root.data >= rightAns.min)
		{
			isBST = false;
		}
		
		if(!leftAns.isBST)
		{
			isBST = false;
		}
		
		if(!rightAns.isBST)
		{
			isBST = false;
		}
		
		isBSTReturn ans = new isBSTReturn(min, max, isBST);
		return ans;
	}
	
	public static boolean isBSTbest(BinaryTree<Integer> root, int minRange, int maxRange)
	{
		if(root == null)
		{
			return true;
		}
		
		if(root.data < minRange || root.data > maxRange)
		{
			return false;
		}
		
		boolean leftWithinRange = isBSTbest(root.left, minRange, root.data);
		boolean rightWithinRange = isBSTbest(root.right, root.data + 1, maxRange);
		
		return leftWithinRange && rightWithinRange;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> root = taketTreeInputBetter(true, 0, true);
		printDetailed(root);
		System.out.print("Number of nodes :");
		System.out.println(numNodes(root));
		
		System.out.println("isBalanced :" + isBalancedBetter(root).isBalanced);
		BinaryTree<Integer> newRoot = removeLeafNodes(root);
//		printDetailed(newRoot);
		System.out.println("isBalanced :" + isBalancedBetter(newRoot).isBalanced);
		
		System.out.println("isBST " + isBST(root));
	}

}
