public class _3_PrintTreeRecursive {
}
    Create Project: Trees

        Create Package: default

Create class: TreeNode
        ----------------------------------------------
        import java.util.ArrayList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}
----------------------------------------------
        Create class: TreeUse
        ----------------------------------------------
        import java.util.*;

public class TreeUse {

    public static TreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter next node data");
        int nodeData = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(nodeData);    // Firstly creating rootNode (base case)

        System.out.println("Enter number of children for " + nodeData);
        int childrenCount = sc.nextInt();
        for (int i = 0; i < childrenCount; i++){     // Recursively creating descendants of root
            TreeNode<Integer> child = takeInput();   // creating node for each descendant of root
            root.children.add(child);           // for making parent-children link

        }
        return root;
    }

    public static void print(TreeNode<Integer> root){
        String str = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {   // traversing through children of root (Only Sibling)
            str = str + root.children.get(i).data + ",";   // rootData: child1, child2, child3 and so on (Only Sibling)
        }                                                  //      |
        System.out.println(str);                       // Printing above Sibling

        for (int i = 0; i < root.children.size(); i++){
            print(root.children.get(i));    // recursive approach for printing & traversing through each descendant of root
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        print(root);
    }
}
----------------------------------------
        Output:
        ----------------------------------------
        Enter next node data
        4
        Enter number of children for 4
        3
        Enter next node data
        2
        Enter number of children for 2
        0
        Enter next node data
        1
        Enter number of children for 1
        2
        Enter next node data
        5
        Enter number of children for 5
        0
        Enter next node data
        6
        Enter number of children for 6
        0
        Enter next node data
        3
        Enter number of children for 3
        0
        4:2,1,3,
        2:
        1:5,6,
        5:
        6:
        3:

        ************************************

        Better Approach: Avoiding Scanner after each call during taking inputs
        ----------------------------------------------------------------------
        Create Project: Trees

        Create Package: default

Create class: TreeNode
        ----------------------------------------------
        import java.util.ArrayList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}
----------------------------------------------
        Create class: TreeUse
        ----------------------------------------------
        import java.util.*;

public class TreeUse {

    public static TreeNode<Integer> takeInput(Scanner sc){

        System.out.println("Enter next node data");
        int nodeData = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(nodeData);    // Firstly creating rootNode (base case)

        System.out.println("Enter number of children for " + nodeData);
        int childrenCount = sc.nextInt();
        for (int i = 0; i < childrenCount; i++){     // Recursively creating descendants of root
            TreeNode<Integer> child = takeInput(sc);   // creating node for each descendant of root
            root.children.add(child);           // for making parent-children link

        }
        return root;
    }

    public static void print(TreeNode<Integer> root){
        String str = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {   // traversing through children of root (Only Sibling)
            str = str + root.children.get(i).data + ",";   // rootData: child1, child2, child3 and so on (Only Sibling)
        }                                                  //      |
        System.out.println(str);                       // Printing above Sibling

        for (int i = 0; i < root.children.size(); i++){
            print(root.children.get(i));    // recursive approach for printing & traversing through each descendant of root
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(sc);
        print(root);
    }
}
----------------------------------------
        Input:

        4 3 2 0 1 2 5 0 6 0 3 0

        Output:

        Enter number of children for 4
        Enter next node data
        Enter number of children for 2
        Enter next node data
        Enter number of children for 1
        Enter next node data
        Enter number of children for 5
        Enter next node data
        Enter number of children for 6
        Enter next node data
        Enter number of children for 3
        4:2,1,3,
        2:
        1:5,6,
        5:
        6:
        3:

        --------------------

        Input:
        4 2 1 0 2 0

        Output:
        Enter number of children for 4
        Enter next node data
        Enter number of children for 1
        Enter next node data
        Enter number of children for 2
        4:1,2,
        1:
        2:
