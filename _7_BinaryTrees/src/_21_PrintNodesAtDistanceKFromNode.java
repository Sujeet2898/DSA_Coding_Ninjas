public class _21_PrintNodesAtDistanceKFromNode {
}
/*
Link: https://www.youtube.com/watch?v=B89In5BctFA&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=26
Question: Print Nodes K Distance Away
1. You are given a partially written BinaryTree class.
2. You are given a value data and a value k.
3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
4. Input is managed for you.
 */

import java.util.ArrayList;
        import java.util.Scanner;

public class solution {

    static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        public BinaryTreeNode(T data){
            this.data = data;
        }
    }

    static class Node<T> {

        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            next = null;
        }
    }

    static class QueueUsingLL<T> {

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
    static class QueueEmptyException extends Exception{
        /**
         *
         */
        private static final long serialVersionUID = 7710094946748781333L;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);

        // Creating Queue in which we store pendingNodes whose children haven't asked yet.
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        //  Firstly taking rootData
        //System.out.println("Enter root data");
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
            //System.out.println("Enter left child of " + front.data);
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
            //System.out.println("Enter right child of " + front.data);
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

    static ArrayList<BinaryTreeNode<Integer>> nodeToRootPath;
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x){
        if (root == null){
            return false;
        }
        if (root.data == x){
            nodeToRootPath.add(root);
            return true;
        }
        boolean findInLeftChild = isNodePresent(root.left, x);
        if (findInLeftChild){
            nodeToRootPath.add(root);
            return true;
        }
        boolean findInRightChild = isNodePresent(root.right, x);
        if (findInRightChild){
            nodeToRootPath.add(root);
            return true;
        }
        return false;
    }

    public static void printKLevelDown(BinaryTreeNode<Integer> root, int k, BinaryTreeNode<Integer> blocker){
        if (root == null || k < 0 || root == blocker){
            return;
        }
        if (k == 0){
            System.out.print(root.data + " ");
        }
        printKLevelDown(root.left, k - 1, blocker);
        printKLevelDown(root.right, k - 1, blocker);
    }

    public static void printKNodesFar(BinaryTreeNode<Integer> root, int data, int k){
        nodeToRootPath = new ArrayList<>();
        isNodePresent(root, data);
        for (int i = 0; i < nodeToRootPath.size() && i <= k; i++){
            printKLevelDown(nodeToRootPath.get(i), k - i, i == 0 ? null: nodeToRootPath.get(i - 1));  // for i = 0, null is blocker and for i != 0, nodeToRootPath.get(i - 1) is blocker.
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println();
        printKNodesFar(root, 10,2);
    }
}

/*
Input:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
8:L:3,R:10
3:L:1,R:6
10:L:-1,R:14
1:L:-1,R:-1
6:L:4,R:7
14:L:13,R:-1
4:L:-1,R:-1
7:L:-1,R:-1
13:L:-1,R:-1

Output:
13 3

 */



********************************************

        Q.  Print nodes at distance k from node
        ----------------------------------------------
        You are given a Binary Tree of type integer, a target node, and an integer value K.
        Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
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

    public static void printLevelWise(BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>> mainQueue = new QueueUsingLL<>();
        mainQueue.enqueue(root);

        // Work : As long as Queue is not empty
        while (!mainQueue.isEmpty()){

            // Steps: 1. dequeue  2. print  3. enqueue  4. print
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

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        nodeToRootPath(root, node, k);
    }

    // CASE-1 :
    private static void printNodesAtDistanceK(BinaryTreeNode<Integer> root, int k) {

        // For no possible solution
        if (root == null || k < 0) {
            return;
        }

        // We have reached at our final nodes
        if (k == 0) {
            System.out.println(root.data);
            return;
        }

        // For k > 0, call on left & right subTrees and is decrease at each steps by 1
        printNodesAtDistanceK(root.left,k-1);
        printNodesAtDistanceK(root.right,k-1);
    }

    // CASE-2 :
    private static int nodeToRootPath(BinaryTreeNode<Integer> root, int node, int k) {

        // distance -1 denotes, we don't find any target node
        if (root==null) {
            return -1;
        }

        // if root is equal to target node, then print subTrees of target node and return 0 distance
        int rootData = root.data;
        if (root.data == node) {
            printNodesAtDistanceK(root, k);
            return 0;
        }

        // if root is not equal to target node
        // Check target node in left subTree of root by calculating distance of left SubTree
        int leftSubTreeDist = nodeToRootPath(root.left, node, k);
        if (leftSubTreeDist != -1){

            // current node (not root) is at kth distance from target node
            if(leftSubTreeDist + 1 == k){
                System.out.println(rootData);
            }else{

                // target node is found at left of root, call on ancestor right subTree
                printNodesAtDistanceK(root.right,k-(leftSubTreeDist+1)-1);
            }
            return leftSubTreeDist + 1;
        }

        // Check target node in right subTree of root by calculating distance of right SubTree
        int rightSubTreeDist = nodeToRootPath(root.right, node, k);
        if (rightSubTreeDist != -1) {
            if(rightSubTreeDist + 1 == k) {
                System.out.println(rootData);
            }else{

                // target node is found at right of root, call on ancestor left subTree
                printNodesAtDistanceK(root.left,k-(rightSubTreeDist+1)-1);
            }
            return rightSubTreeDist+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println();
        nodesAtDistanceK(root, 6, 1);
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
        3
        5
