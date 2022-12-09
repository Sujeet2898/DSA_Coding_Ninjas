public class _21_ReverseLLIterative {
}
    Q.  Reverse LL (Iterative)
---------------------------
        Given a singly linked list of integers, reverse it iteratively and return the head to the modified list.

        Note :
        No need to print the list, it has already been taken care. Only return the new head to the list.
        --------------
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

    public static Node<Integer> reverseR(Node<Integer> head) {

        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> temp;

        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = reverseR(head);
        print(head);
    }
}
-----------------------
        Input:
        1 2 3 4 -1

        Output:
        4 3 2 1
