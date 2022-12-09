public class _2_TakeInputRecursive {
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
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
    }
}
----------------------------------------
        Output:
        ----------------------------------------
        Enter next node data
        4
        Enter number of children for 4
        2
        Enter next node data
        1
        Enter number of children for 1
        0
        Enter next node data
        3
        Enter number of children for 3
        3
        Enter next node data
        6
        Enter number of children for 6
        0
        Enter next node data
        2
        Enter number of children for 2
        0
        Enter next node data
        5
        Enter number of children for 5
        0
