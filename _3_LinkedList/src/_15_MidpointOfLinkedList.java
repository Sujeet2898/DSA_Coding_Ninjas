public class _15_MidpointOfLinkedList {
}
    Q.  Midpoint of Linked list
---------------------------
        For a given singly linked list of integers, find and return the node present at the middle of the list.

        Note :
        If the length of the singly linked list is even, then return the first middle node.

        Example: Consider, 10 -> 20 -> 30 -> 40 is the given list, then the nodes present at the middle with respective data values are, 20 and 30. We return the first node with data 20.
        ------------------------
        Solution:
        -----------

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

    public static Node<Integer> midPoint(Node<Integer> head) {
        if (head==null || head.next==null){
            return head;
        }
        Node<Integer> fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){   // for odd & even
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        System.out.println(midPoint(head).data);
    }
}
-----------------------
        Input:
        10 20 30 -1

        Output:
        20

        ---------
        Input:
        10 20 30 40 -1

        Output:
        20

