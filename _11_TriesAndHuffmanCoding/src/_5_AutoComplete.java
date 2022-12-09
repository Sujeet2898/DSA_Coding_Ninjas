public class _5_AutoComplete {
}
    Q.  Auto complete
----------------------------------------------
        Given n number of words and an incomplete word w. You need to auto-complete that word w.
        That means, find and print all the possible words which can be formed using the incomplete word w.
        Note : Order of words does not matter.
        ----------------------------------------------
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


    // Search function without boolean

    // private search function for updating root each time
    private TrieNode search(TrieNode root, String word){

        /*  Base Condition  */

        if (word.length() == 0){
            return root;
        }

        // Finding index of child by subtracting ASCII of 'a' from stringCharacter
        int childIndex = word.charAt(0) - 'a';  // For UpperCase, put 'A'

        // Getting the character of child by putting childIndex at Array of root
        TrieNode child = root.children[childIndex];

        // If Array of root is null i.e child is null
        if (child == null){
            return null;
        }

        /*  Recursive call   */

        return search(child, word.substring(1));
    }

    // original search function

    public TrieNode search(String word){
        return search(root, word);
    }

    // No need of remove function

    public void printPossibleWords(TrieNode root, String word,String output ) {

        if(root.isTerminating) {
            System.out.println(word + output);
        }
        for(int i=0;i<root.children.length;i++) {
            if(root.children[i]!=null)
                printPossibleWords(root.children[i], word, output + root.children[i].data  );
        }
    }
    public void autoComplete(ArrayList<String> input, String word) {
        // change with Trie
        Trie trie = new Trie();
        for(String string : input ) {
            trie.add(string);
        }
        TrieNode t = trie.search(word);
        if(t==null) {
            return ;
        }
        printPossibleWords(t,word,"");
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
        output.add("do");
        output.add("dont");
        output.add("no");
        output.add("not");
        output.add("note");
        output.add("notes");
        output.add("den");
        t.autoComplete(output, "no");
    }
}
---------------------------------------------
        Output:
        no
        not
        note
        notes
