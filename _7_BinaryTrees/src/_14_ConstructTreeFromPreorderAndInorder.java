public class _14_ConstructTreeFromPreorderAndInorder {
}
    Q.  Construct Tree from Preorder and Inorder
--------------------------------------------
        For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
        --------------------------------------------
        Note:
        Assume that the Binary Tree contains only unique elements.
        --------------------------------------------
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
        Create class: Node
        --------------------
public class Node<T> {

    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        next = null;
    }
}
----------------------------------------------

        Create class: QueueUsingLL
        ----------------------------------------------
public class QueueUsingLL<T> {

    private Node<T> front;
    private Node<T> rear;
    int size;

    public QueueUsingLL(){   // Constructor
        front = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    T front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T element){
        Node<T> newNode = new Node<>(element);
        if (front == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }

        T temp = front.data;
        front = front.next;

        if (size == 1){
            rear =null;
        }
        size--;

        return temp;
    }
}
-----------------------------------------------
        Create other class: QueueEmptyException
        ----------------------------------------------
public class QueueEmptyException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 7710094946748781333L;
}
----------------------------------------------
        Create class: BinaryTreeUse
        ----------------------------------------------
        import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);

        // Creating Queue in which we store pendingNodes whose children haven't asked yet.
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        //  Firstly taking rootData
        System.out.println("Enter root data");
        int rootData =  sc.nextInt();
        if (rootData == -1){   // Base Case
            return null;
        }

        // Creating Node of the BinaryTree as root using rootData
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        // Adding root into Queue as children of node hasn't asked yet
        pendingNodes.enqueue(root);

        // Work : As long as Queue is not empty
        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;

            //  Handle the queueEmptyException of Queue by Try and Catch option
            try {
                // Work 1 : Removing frontNode from the Queue
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }

            // Work 2 : LeftChild

            // 2.1  Taking LeftChild
            System.out.println("Enter left child of " + front.data);
            int leftChild = sc.nextInt();

            if (leftChild != -1){
                // 2.2  Creating node for the LeftChild
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);

                // 2.3  Linking leftChild with the front
                front.left = child;

                // 2.4  Adding leftChild also into Queue as children of leftChild hasn't asked yet
                pendingNodes.enqueue(child);

            }

            // Work 3 : RightChild

            // 3.1  Taking RightChild
            System.out.println("Enter right child of " + front.data);
            int rightChild = sc.nextInt();

            if (rightChild != -1){
                // 3.2  Creating node for the RightChild
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);

                // 3.3  Linking RightChild with the front
                front.right = child;

                // 3.4  Adding RightChild also into Queue as children of RightChild hasn't asked yet
                pendingNodes.enqueue(child);

            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>> mainQueue = new QueueUsingLL<>();
        mainQueue.enqueue(root);

        // Work : As long as Queue is not empty
        while (!mainQueue.isEmpty()){

            // Steps: 1. dequeue  2. print  3. enqueue
            try {
                BinaryTreeNode<Integer> front = mainQueue.dequeue();    // 1. dequeue
                System.out.print(front.data + ":");          // 2. print

                if (front.left != null){
                    mainQueue.enqueue(front.left);      // 3. enqueue
                    System.out.print("L:" + front.left.data);     // 4. print
                }else {
                    System.out.print("L:-1");
                }
                if (front.right != null){
                    mainQueue.enqueue(front.right);     // 3. enqueue
                    System.out.print(",R:" + front.right.data);    // 4. print
                }else {
                    System.out.print(",R:-1");
                }
                System.out.println();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }

    public static BinaryTreeNode<Integer> buildTreeHelper(int in[], int pre[], int inS, int inE, int preS, int preE){

        // Base Case : array is empty
        if (inS > inE){
            return null;
        }

        // rootData is at the starting of preOrder and work is to be done within range ( not 0 )
        int rootData = pre[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        // Finding index of root in InOrder
        int rootInIndex = -1;
        for (int i = inS; i <= inE; i++){
            if (in[i] == rootData){
                rootInIndex = i;
                break;
            }
        }
        if (rootInIndex == -1){
            return null;
        }

        // Necessary 8 Variables:-
        // 4 For InOrder
        int leftInS = inS;
        int leftInE = rootInIndex - 1;
        int rightInS = rootInIndex + 1;
        int rightInE = inE;

        // 4 For PreOrder
        int leftPreS = preS + 1;
        int leftPreE = (leftInE - leftInS) + leftPreS;    // leftPreE - leftPreS = leftInE - leftInS
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;

        // Recursively call on left subTree and attached to left of root
        root.left = buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);

        // Recursively call on right subTree and attached to right of root
        root.right = buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);

        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int in[], int pre[]){
        return buildTreeHelper(in, pre, 0, in.length - 1, 0, pre.length - 1);
    }

    public static void main(String[] args) {
        int in[] = {4, 2, 5, 1, 3, 7};
        int pre[] = {1, 2, 4, 5, 3, 7};
        BinaryTreeNode<Integer> root = buildTree(in, pre);
        printLevelWise(root);
    }
}
----------------------------------------------
        Output:
        1:L:2,R:3
        2:L:4,R:5
        3:L:-1,R:7
        4:L:-1,R:-1
        5:L:-1,R:-1
        7:L:-1,R:-1
