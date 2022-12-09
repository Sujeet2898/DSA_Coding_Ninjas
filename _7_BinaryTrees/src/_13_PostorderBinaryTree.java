public class _13_PostorderBinaryTree {
}
    Q. Postorder Binary Tree
        ---------------------------------------------
        For a given Binary Tree of integers, print the post-order traversal.
        ---------------------------------------------
        Postorder: Left SubTree -> Right SubTree -> Root
        Firstly children are printed, then root is printed.
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
-----------------------------------------------
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

    public static void postOrder(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        postOrder(root);
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
        4 5 2 6 7 3 1
