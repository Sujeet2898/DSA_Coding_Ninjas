public class _2_TakeTreeInputAndPrintRecursive {
}
    Create Project: BinaryTrees

        Create Package: default

Create class: BinaryTreeNode
        ----------------------------------------------
public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data){
        this.data = data;
    }
}
----------------------------------------------
        Create class: BinaryTreeUse
        ----------------------------------------------
        import java.util.Scanner;

public class BinaryTreeUse {

    public static void printTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        String toBePrinted = root.data + "";
        if (root.left != null){
            toBePrinted += "L:" + root.left.data + ",";
        }
        if (root.right != null){
            toBePrinted += "R:" + root.right.data + ",";
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

    public static BinaryTreeNode<Integer> takeInput(Scanner sc){
        int rootData;
        System.out.println("Enter root data");
        rootData = sc.nextInt();
        if (rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(sc);
        root.right = takeInput(sc);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInput(sc);
        printTree(root);
        sc.close();
    }
}
---------------------------------------------
        Input:
        Enter root data
        1
        Enter root data
        2
        Enter root data
        4
        Enter root data
        -1
        Enter root data
        -1
        Enter root data
        5
        Enter root data
        -1
        Enter root data
        -1
        Enter root data
        3
        Enter root data
        -1
        Enter root data
        6
        Enter root data
        -1
        Enter root data
        -1
        ------------------------
        Output:
        1L:2,R:3,
        2L:4,R:5,
        4
        5
        3R:6,
        6