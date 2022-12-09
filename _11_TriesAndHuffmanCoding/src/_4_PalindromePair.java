public class _4_PalindromePair {
}
    Q. Palindrome Pair
-----------------------------------------------
        Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, which itself is a palindrome.
        The function should return either true or false. You don't have to print anything.
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



    public String reverseWord(String word) {

        String reverse="";
        for(int i=word.length()-1;i>=0;i--) {
            reverse+=word.charAt(i);
        }
        return reverse;

    }
    public boolean isPalindromePair(ArrayList<String> words) {

        for(int i=0;i<words.size();i++) {

            String string = reverseWord(words.get(i));

            Trie suffixTrie = new Trie();
            for(int j=0;j<string.length();j++) {
                suffixTrie.add(string.substring(j));
            }
            for(String word : words) {
                if(suffixTrie.search(word)) {
                    return true;
                }
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
        output.add("abcm");
        output.add("cba");
        System.out.println(t.isPalindromePair(output));
    }
}
---------------------------------------------
        Output:
        true
