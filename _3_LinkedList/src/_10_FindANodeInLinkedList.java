public class _10_FindANodeInLinkedList {
}
    Q.  Find a Node in Linked List
---------------------------------
        You have been given a singly linked list of integers. Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.

        Note :
        Assume that the Indexing for the singly linked list always starts from 0.
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

    public static int findNode(Node<Integer> head, int n) {

        Node<Integer> temp = head;
        int count=0;
        while (temp!=null){
            if (temp.data==n){
                return count;
            }else{
                temp=temp.next;
                count++;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        System.out.println(findNode(head,10));
        print(head);
    }
}
---------------------------------
        Input:
        10 20 30 -1

        Output:
        0
        10 20 30

        --------------

        Input:
        50 60 10 20 30 -1

        Output:
        2
        50 60 10 20 30