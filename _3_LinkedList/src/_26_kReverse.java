public class _26_kReverse {
}
Q.  kReverse
        -------------
        Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.
        'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.
        -----------------

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

    public static Node<Integer> reverse(Node<Integer> head, int k) {
        if(head == null || k == 0 || k == 1) {
            return head;
        }

        Node<Integer> current = head;
        Node<Integer> next = null;
        Node<Integer> prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }
    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = reverse(head,3);
        print(head);
    }
}
---------------------------------
        Input:
        1 2 3 4 5 6 7 -1

        Output:
        3 2 1 6 5 4 7