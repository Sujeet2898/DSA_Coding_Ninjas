public class _14_LargestBST {
}
    Q.  Largest BST
----------------------------------------------
        Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
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
        Create other class: Pair
        ----------------------------------------------
public class Pair<T,V>{
    public T first;     // first means Boolean
    public V second;    // second means Pair
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

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSTSubtree1(root).second.second;
    }
    private static Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> largestBSTSubtree1(BinaryTreeNode<Integer> root) {
        if (root==null) {
            Pair<Pair<Integer,Integer>, Pair<Boolean, Integer>> output = new Pair<Pair<Integer,Integer>, Pair<Boolean, Integer>>();
            output.first = new Pair<Integer, Integer>();
            output.first.first = Integer.MAX_VALUE;
            output.first.second = Integer.MIN_VALUE;
            output.second = new Pair<Boolean, Integer>();
            output.second.first = true;
            output.second.second = 0;
            return output;
        }

        Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> leftOutput = largestBSTSubtree1(root.left);
        Pair<Pair<Integer,Integer>,Pair<Boolean,Integer>> rightOutput = largestBSTSubtree1(root.right);

        int min = Math.min(root.data, Math.min( leftOutput.first.first, rightOutput.first.first));
        int max = Math.max(root.data, Math.max( leftOutput.first.second, rightOutput.first.second));

        boolean isBST = (root.data > leftOutput.first.second)
                && (root.data <= rightOutput.first.first)
                && leftOutput.second.first
                && rightOutput.second.first;

        int height = Math.max(leftOutput.second.second, rightOutput.second.second);
        if (isBST){
            height = height + 1;
        }else {
            height = height;
        }

        Pair<Pair<Integer,Integer>, Pair<Boolean, Integer>> output = new Pair<Pair<Integer,Integer>, Pair<Boolean, Integer>>();
        output.first = new Pair<Integer, Integer>();
        output.first.first = min;
        output.first.second = max;
        output.second = new Pair<Boolean, Integer>();
        output.second.first = isBST;
        output.second.second = height;
        return output;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println();
        System.out.println(largestBSTSubtree(root));
    }
}
---------------------------------------------
        Input:
        Enter root data
        5
        Enter left child of 5
        6
        Enter right child of 5
        10
        Enter left child of 6
        2
        Enter right child of 6
        3
        Enter left child of 10
        -1
        Enter right child of 10
        -1
        Enter left child of 2
        -1
        Enter right child of 2
        -1
        Enter left child of 3
        -1
        Enter right child of 3
        9
        Enter left child of 9
        -1
        Enter right child of 9
        -1
        ------------------------
        Output:
        5:L:6,R:10
        6:L:2,R:3
        10:L:-1,R:-1
        2:L:-1,R:-1
        3:L:-1,R:9
        9:L:-1,R:-1

        2
