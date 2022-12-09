public class _4_PrintTreeLevelWise {
}
    Q.  Print Tree Level Wise
----------------------------------------------
        For a given a Binary Tree of type integer, print the complete information of every node, when traversed in a level-order fashion.
        ----------------------------------------------
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

    // 1. First Way of printing BinaryTree WITHOUT QueueUsingLL (WITHOUT levelWise) ---Very Important---
    Output format:   1:L:2,R:3
            2:L:4,R:5
            4:
            5:
            3:R:6
            6:

    public static void printTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        String toBePrinted = root.data + ":";
        if (root.left != null){
            toBePrinted += "L:" + root.left.data + ",";
        }
        if (root.right != null){
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }


    // 2. Second Way of printing BinaryTree WITH QueueUsingLL (WITH levelWise) ---Very Important---
    Output format:   1:L:2,R:3
            2:L:4,R:5
            3:R:6
            4:
            5:
            6:
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

    // 3. Third Way of printing BinaryTree WITH QueueUsingLL (WITH levelWise) in the following format ---Very Important---
    Output format:   1
            2 3
            4 5 6
    public static void printLevelWis(BinaryTreeNode<Integer> root) {

        QueueUsingLL<BinaryTreeNode<Integer>> mainQueue = new QueueUsingLL<>();
        mainQueue.enqueue(root);

        // Work : As long as Queue is not empty
        while (!mainQueue.isEmpty()){
            // Steps: 1. dequeue  2. print  3. enqueue

            int count = mainQueue.size();
            for(int i = 0; i < count; i++){
                try {
                    BinaryTreeNode<Integer> front = mainQueue.dequeue();    // 1. dequeue
                    System.out.print(front.data + " ");          // 2. print


                    if (front.left != null){
                        mainQueue.enqueue(front.left);      // 3. enqueue
                    }

                    if (front.right != null){
                        mainQueue.enqueue(front.right);     // 3. enqueue
                    }

                } catch (QueueEmptyException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println();
        printLevelWis(root);
    }
}
---------------------------------------------
        Input:
        Enter root data
        1
        Enter left child of 1
        2
        Enter right child of 1
        3
        Enter left child of 2
        4
        Enter right child of 2
        5
        Enter left child of 3
        6
        Enter right child of 3
        7
        Enter left child of 4
        -1
        Enter right child of 4
        -1
        Enter left child of 5
        -1
        Enter right child of 5
        -1
        Enter left child of 6
        -1
        Enter right child of 6
        -1
        Enter left child of 7
        -1
        Enter right child of 7
        -1
        ------------------------
        Output:
        1:L:2,R:3
        2:L:4,R:5
        3:L:6,R:7
        4:L:-1,R:-1
        5:L:-1,R:-1
        6:L:-1,R:-1
        7:L:-1,R:-1

        1
        2 3
        4 5 6 7
