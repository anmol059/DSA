class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data)
	{
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}
public class Trie {
	
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode('\0');
	}
	
	private void remove(TrieNode root, String word){
        if(word.length() == 0)
        {
            root.isTerminating = false;
            return;
        }
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
        {
            return;
        }
        
        remove(child, word.substring(1));
        // we can remove child node only if it is non terminating and number of children are 0
//        if(!root.isTerminating)
//        {
//        	int chC = 0;
//        	for(int i = 0; i < 26; i++)
//        	{
//        		if(child.children[i] != null)
//        		{
//        			chC++;
//        		}
//        	}
//        	if(chC == 0)
//        	{
//        		root.children[childIndex] = null;
//            	child = null;
//            	root.childCount--;
//        	}
//        }
        if(!root.isTerminating && child.childCount == 0)
        {
        	root.children[childIndex] = null;
        	child = null;
        	root.childCount--;
        }
	}

	public void remove(String word){
        remove(root, word);
    }
	
	public boolean search(TrieNode root, String word){
		// Write your code here
        if(word.length() == 0)
        {
            if(root.isTerminating == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
        {
            return false;
        }
        
        return search(child, word.substring(1));
	}

	public boolean search(String word){
        return search(root, word);
    }
	
	public void add(TrieNode root, String word) {
		if(word.length() == 0)
		{
			root.isTerminating = true;
			return;
		}
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		
		add(child, word.substring(1));
	}
	
	public void add(String word) {
		add(root, word);
	}
}
