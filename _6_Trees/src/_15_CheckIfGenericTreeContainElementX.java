public class _15_CheckIfGenericTreeContainElementX {
}
Q.  Check if generic tree contain element x
        ---------------------------------------------
        Given a generic tree and an integer x, check if x is present in the given tree or not. Return true if x is present, return false otherwise.
        ------------------------------------------------
        Input format :
        Line 1 : Integer x
        Line 2 : Elements in level order form separated by space (as per done in class). Order is -
        Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

        Output format : true or false
        ---------------------------------------------
        Sample Input 1 :
        40
        10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output 1 :
        true

        Sample Input 2 :
        4
        10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output 2:
        false
        ---------------------------------------------

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
---------------------------------------------

        Create class: TreeUse
        ----------------------------------------------
        import java.util.*;

public class TreeUse {

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);

        //  Firstly taking rootData
        // System.out.println("Enter root data");
        int rootData = sc.nextInt();

        // Creating Queue in which we store pendingNodes whose children haven't asked yet.
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();

        // Creating Node of the tree as root using rootData
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);

        // Adding root into Queue as children of node hasn't asked yet
        pendingNodes.enqueue(root);

        // Work : As long as Queue is not empty
        while (!pendingNodes.isEmpty()){

            //  Handle the queueEmptyException of Queue by Try and Catch option
            try {

                // Work 1 : Removing frontNode from the Queue
                TreeNode<Integer> frontNode = pendingNodes.dequeue();

                // Work 2 : Asking number of children of frontNode.
                // System.out.println("Enter num of children of " + frontNode.data);
                int numChildren = sc.nextInt();

                // Work 3 : Applying loop for taking all inputs for the number of children of frontNode
                for (int i = 0; i < numChildren; i++){
                    // System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);

                    // 3.1  Taking childInput
                    int child = sc.nextInt();

                    // 3.2  Creating node for the childInput i.e childNode
                    TreeNode<Integer> childNode = new TreeNode<Integer>(child);

                    // 3.3  Linking childNode with the frontNode
                    frontNode.children.add(childNode);

                    // 3.4  Adding that childNode also into Queue as children of childNode hasn't asked yet
                    pendingNodes.enqueue(childNode);
                }
            } catch (QueueEmptyException e) {
                // Shouldn't come here
                return null;
            }
        }
        return root;
    }

//    public static boolean isPresent = false;
//    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
//        if (root == null){      // not a base case
//            return false;
//        }
//        if (root.data == x) {
//            return true;
//        }
//        for (int i = 0; i < root.children.size(); i++){  // base case is internally included
//            isPresent = checkIfContainsX(root.children.get(i), x);     // recursive call
//        }
//        return isPresent;
//    }

    //    Or
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if (root == null){      // not a base case
            return false;
        }
        if (root.data == x) {
            return true;
        }
        for (TreeNode<Integer>child: root.children){  // base case is internally included
            if (checkIfContainsX(child, x)){     // recursive call
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println(numNodes(root));
    }
}

----------------------------------------
        Input:
        15 1 3 2 3 4 1 6 1 5 1 7 0 0 1 8 0

        Output:
        false
        -----------------------------------
        Input:
        2200 1 1 200 1 32 1 40 2 5 600 1 70 1 800 1 900 2 12 10 0 0 0

        Output:
        false
        -----------------------------------
        Input:
        999999 1 3 20 3 40 1 90 2 50 6 1 100 1 150 17 1000 2000 3000 4000 5000 6000 7000 85 86 87 88 89 92 93 94 95 96 1 80 1 83 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

        Output:
        false
