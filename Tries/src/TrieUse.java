
public class TrieUse {
	
	public static void main(String[]args)
	{
		Trie t = new Trie();
		t.add("anmol");
		System.out.println(t.search("anmol"));
		t.remove("anmol");
		System.out.println(t.search("anmol"));	
	}
}
