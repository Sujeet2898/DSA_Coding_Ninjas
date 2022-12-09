public class _10_FindHeight {
}
Code : Find Height
        -------------------------------------------------------------------
        Given a generic tree, find and return the height of given tree.
        ------------------------------------------------------------------
        Input Format:
        The first line of input contains data of the nodes of the tree in level order form. The order is: data for root node, number of children to root node, data of each of child nodes and so on and so forth for each node. The data of the nodes of the tree is separated by space.
        ------------------------------------------------------------------------

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

    public static int getHeight(TreeNode<Integer> root){
        int height = 0;        // For fiding depth, -1 istaken instead of 0 and whole code is same.
        for (TreeNode<Integer> child: root.children){
            int childHeight = getHeight(child);
            height = Math.max(childHeight,height);
        }
        height += 1;
        return height;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println(getHeight(root));
    }
}

----------------------------------------
        Input:
        1 3 2 3 4 0 2 5 6 2 8 20 0 0 0 0

        --------------
        Output:
        3
