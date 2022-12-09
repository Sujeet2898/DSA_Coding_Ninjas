public class _22_FindNodeInLLRecursive {
}
    Q.  Find a node in LL (recursive)
---------------------------------
        Given a singly linked list of integers and an integer n, find and return the index for the first occurrence of 'n' in the linked list. -1 otherwise.
        Follow a recursive approach to solve this.
        ---------------------------------
        Solution:
        ---------------
        Create Project: LinkedList

        Create Package: default

Create class: Node
        -------------------
public class Node<T> {

    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        next = null;
    }
}
--------------------------

        Create class: LinkedListUse
        ---------------------------
        import java.util.Scanner;

public class LinkedListUse {

    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail= null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;   // Or tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head){

        while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }
    }

    public static int findNodeRec(Node<Integer> head, int n) {

        if(head==null){
            return -1;
        }
        if(head.data==n){
            return 0;
        }
        int smallAns= findNodeRec(head.next,n);
        if(smallAns==-1){
            return -1;
        }
        return 1+ smallAns;
    }


    public static void main(String args[]){
        Node<Integer> head = takeInput();
        System.out.println(findNodeRec(head, 10));
    }
}
---------------------------------
        Input:
        10 20 30 -1

        Output:
        0