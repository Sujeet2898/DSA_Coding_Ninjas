public class _10_BSTClassSearchInsertDeletePrint {
}
    Q.  BST Class
----------------------------------------------
        Implement the BST class which includes following functions :-

        1. search
        Given an element, find if that is present in BST or not. Return true or false.

        2. insert -
        Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.

        3. delete -
        Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.

        4. printTree (recursive) -
        Print the BST in ithe following format -
        For printing a node with data N, you need to follow the exact format -
        N:L:x,R:y
        where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
        There is no space in between.
        You need to print all nodes in the recursive format in different lines
        ----------------------------------------------
        Create Project: BinaryTrees

        Create Package: default

Create class: BinarySearchTree
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


    BinaryTreeNode<Integer> root;

    private BinaryTreeNode<Integer> deleteDataHelper(int data, BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }

        if (data < root.data){
            // Call delete function on leftSide and attach the null on rootLeft
            root.left = deleteDataHelper(data, root.left);
            return root;
        }else if (data > root.data){
            // Call delete function on rightSide and attach the null on rootRight
            root.right = deleteDataHelper(data, root.right);
            return root;
        }else {
            // data == root.data
            if (root.left == null && root.right == null){
                return null;
            }else if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else {
                // (root.left != null) && (root.right != null)
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null){
                    // we sent minNode to left till its left is null
                    minNode = minNode.left;
                }
                // change the rootData with minNodeData
                root.data = minNode.data;

                // Call delete function on rightSide and attach the null on rootRight
                root.right = deleteDataHelper(minNode.data, root.right);
                return root;
            }
        }
    }
    public void deleteData(int data){
        // update the root
        root = deleteDataHelper(data, root);
    }

    private BinaryTreeNode<Integer> insertDataHelper(int data, BinaryTreeNode<Integer> root){
        if (root == null){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode;
        }
        if (data <= root.data){
            // Call insert function on leftSide and attach the null on rootLeft
            root.left = insertDataHelper(data, root.left);
        }else {
            // (data > root.data)
            // Call insert function on rightSide and attach the null on rootRight
            root.right = insertDataHelper(data, root.right);
        }
        return root;
    }
    public void insertData(int data){
        // update the root
        root = insertDataHelper(data, root);
    }

    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root){
        if (root == null){
            return false;
        }
        if (data == root.data){
            return true;
        }else if (data > root.data){
            // call right
            return hasDataHelper(data, root.right);
        }else {
            // call left i.e data <= root.data
            return hasDataHelper(data, root.left);
        }
    }
    public boolean hasData(int data){
        return hasDataHelper(data, root);
    }


    private void printLevelWise(BinaryTreeNode<Integer> root){
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
    public void printTree(){
        printLevelWise(root);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertData(10);
        bst.insertData(20);
        bst.insertData(5);
        bst.insertData(15);
        bst.insertData(3);
        bst.insertData(7);
        bst.printTree();
        System.out.println();
        bst.deleteData(10);
        bst.printTree();
    }
}
---------------------------------------------
        Output:
        10:L:5,R:20
        5:L:3,R:7
        20:L:15,R:-1
        3:L:-1,R:-1
        7:L:-1,R:-1
        15:L:-1,R:-1

        15:L:5,R:20
        5:L:3,R:7
        20:L:-1,R:-1
        3:L:-1,R:-1
        7:L:-1,R:-1
