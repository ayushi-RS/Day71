class TrieNode{
    private TrieNode[] links; 
    private boolean flag;
    
    TrieNode()
    {
        this.links = new TrieNode[26];
        this.flag = false;
    }
    
	//To check if the character exists in the current node
    public boolean containsChar(char ch)
    {
     return links[ch - 'a'] != null ; 
    }
    
	//To add the character in current node
    public void putChar(char ch , TrieNode node)
    {
        links[ch - 'a'] = node;
    }
    
	//Get the reference node of the current character
    public TrieNode getTrieNode(char ch)
    {
        return links[ch - 'a'];
    }
    
	//Setting indicator flag to true to mark the end of word in Trie
    public void setEnd()
    {
        this.flag = true;
    }
    
	//To check if this is the end of the word in Trie
    public boolean isEnd()
    {
        return this.flag;
    }
    
}


class Trie {
    
    TrieNode root; //main root of the Trie

    public Trie() {
        root = new TrieNode();
    }
    
    //TC : O(length of word)
    public void insert(String word) {
        
        TrieNode node  = root ;      
        for(int i =0 ;i < word.length();i++)
        {
            if(!node.containsChar(word.charAt(i)))
            {
                node.putChar(word.charAt(i) , new TrieNode());
            }
            node  = node.getTrieNode(word.charAt(i));
        }
        node.setEnd();
    }
    
    //TC : O(length of word)
    public boolean search(String word) {
        
        TrieNode node  = root;
        for(int i =0 ; i<word.length();i++)
        {
            if(!node.containsChar(word.charAt(i)))
            {
                return false;
            }
            
            node = node.getTrieNode(word.charAt(i));
        }
        return node.isEnd();
    }
    
    //TC : O(length of prefix)
    public boolean startsWith(String prefix) {
        
        TrieNode node  = root;
        for(int i=0;i<prefix.length();i++)
        {
            if(!node.containsChar(prefix.charAt(i)))
            {
                return false;
            }
            node = node.getTrieNode(prefix.charAt(i));
        }
        return true;
    }
}