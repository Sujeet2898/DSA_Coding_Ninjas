public class _24_DeleteEveryNNodes {
}
    Q.  Delete every N nodes
-------------------------
        You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list.
        To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

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

    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {

        if (M == 0){
            return null;
        }
        if (N == 0){
            return head;
        }

        Node<Integer> t1 = head, t2 = null;

        while(t1 != null){

            for (int i = 0; i < M-1 && t1 != null; i++){
                t1 = t1.next;  // t1 is at end of M
            }
            if (t1 == null){
                break;
            }

            t2 = t1.next;    // t2 is at start of N

            for (int i = 0; i < N && t2 != null; i++){
                t2 = t2.next;   // t2 is at start of next M
            }

            t1.next = t2;     // appending next M after previous M
            t1 = t2;          // pointing head at start of next M
        }

        return head;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = skipMdeleteN(head,2,3);
        print(head);
    }
}
---------------------------------
        Input:
        1 2 3 4 5 6 7 -1

        Output:
        1 2 6 7
