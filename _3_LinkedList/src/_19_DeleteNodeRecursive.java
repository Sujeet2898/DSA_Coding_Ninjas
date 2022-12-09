public class _19_DeleteNodeRecursive {
}
    Q.  Delete node (recursive)
---------------------------
        Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' position in the linked list recursively.

        Note :
        Assume that the Indexing for the linked list always starts from 0.

        No need to print the list, it has already been taken care. Only return the new head to the list.
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
        --------------------------
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

    public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {

        if (head == null) {
            return head;
        }

        if (pos==0) {
            head=head.next;
            return head;
        }
        else {
            Node<Integer> smallerHead=deleteNodeRec(head.next,pos-1);
            head.next=smallerHead;
            return head;
        }
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = deleteNodeRec(head, 2);
        print(head);
    }
}
-----------------------
        Input:
        10 20 30 40 -1

        Output:
        10 20 40
