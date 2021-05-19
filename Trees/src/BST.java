
public class BST {
	private static BinaryTree<Integer> root;
	private int size;
	
	private static BinaryTree<Integer> insertHelper(BinaryTree<Integer> root, int data)
    {
        if(root == null)
        {
            BinaryTree<Integer> newRoot = new BinaryTree<>(data);
            return newRoot;
        }
        
        if(data >= root.data)
        {
            root.right = insertHelper(root.right, data);
        }
        else
        {
            root.left = insertHelper(root.left, data);
        }
        return root;
    }
        
	public void insert(int data) {
		//Implement the insert() function
        root = insertHelper(root, data);
        size++;
	}
	
	private static boolean isPresentHelper(BinaryTree<Integer> node, int x)
	{
		if(node == null)
		{
			return false;
		}
		
		if(node.data == x)
		{
			return true;
		}
		
		if(x < root.data)
		{
			return isPresentHelper(node.left, x);
		}
		else
		{
			return isPresentHelper(node.right, x);
		}
	}
	
	public boolean isPresent(int x)
	{
		return isPresentHelper(root, x);
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean deleteData(int x)
	{
		return false;
	}
	private static void printTreeHelper(BinaryTree<Integer> root)
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
		
		
		printTreeHelper(root.left);
		printTreeHelper(root.right);
	}
	public void printTree()
	{
		printTreeHelper(root);
	}
}
