public class _3_PatternMatching {
}
    Q.  Pattern Matching
-----------------------------------------------
        Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.
        -----------------------------------------------
        Create Project: Trie

        Create Package: default

Create class: TrieNode
        -----------------------------------------------
        Time complexity:  add -> O(word length)
        remove -> O(word length)
        search -> O(word length)
        -----------------------------------------------
        Time complexity of both HashMap & Trie is same. But space complexity of Trie is better
        -----------------------------------------------
public class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    // Constructor
    public TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];  // array of 26 null character
        childCount = 0;
    }
}
----------------------------------------------
        Create another class: Trie
        ----------------------------------------------
public class Trie {

    // Creating root ( initialized with null character)
    private TrieNode root;
    public Trie(){
        root = new TrieNode('\0');
    }

    // Add function

    // private add function for updating root each time
    private void add(TrieNode root ,String word){

        /*  Base Condition  */

        if (word.length() == 0){
            root.isTerminating = true;
            return;
        }

        // Finding index of child by subtracting ASCII of 'a' from stringCharacter
        int childIndex = word.charAt(0) - 'a';     // For UpperCase, put 'A'

        // Getting the character of child by putting childIndex at Array of root
        TrieNode child = root.children[childIndex];

        // If Array of root is null i.e child is null
        if (child == null){

            // Creating newNode for character of child corresponding to 0th character of string
            child = new TrieNode(word.charAt(0));

            // And putting character of child into Array of root
            root.children[childIndex] = child;

            root.childCount++;
        }

        /*  Recursive call   */

        add(child, word.substring(1));
    }

    // original add function

    public void add(String word){
        add(root, word);
    }

    // Search function with boolean

    // private search function for updating root each time
    private boolean search(TrieNode root, String word){

        /*  Base Condition  */

        if (word.length() == 0){
            return root.isTerminating;
        }

        // Finding index of child by subtracting ASCII of 'a' from stringCharacter
        int childIndex = word.charAt(0) - 'a';  // For UpperCase, put 'A'

        // Getting the character of child by putting childIndex at Array of root
        TrieNode child = root.children[childIndex];

        // If Array of root is null i.e child is null
        if (child == null){
            return false;
        }

        /*  Recursive call   */

        return search(child, word.substring(1));
    }

    // original search function

    public boolean search(String word){
        return search(root, word);
    }

    // No need of remove function

    // Note: Add function is compulsory to implement for "patternMatching"

    public boolean patternMatching(ArrayList<String> input, String pattern) {

        for(int i = 0 ; i<input.size();i++) {

            String str = input.get(i);
            Trie suffixTrie = new Trie();
            for(int j=0;j<str.length();j++) {
                suffixTrie.add(str.substring(j));
            }
            if(suffixTrie.search(pattern)) {
                return true;
            }
        }
        return false;
    }
}
----------------------------------------------
        Create another class: TrieUse
        ----------------------------------------------
public class TrieUse {

    public static void main(String[] args) {

        // Creating object
        Trie t = new Trie();
        ArrayList<String> output = new ArrayList<>();
        output.add("abc");
        output.add("def");
        output.add("ghi");
        output.add("hg");
        System.out.println(t.patternMatching(output, "hi"));
    }
}
---------------------------------------------
        Output:
        true

