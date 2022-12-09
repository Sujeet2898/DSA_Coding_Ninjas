public class _9_DeleteNodeInLL {
}
    Q.  Delete Node in LL
------------------------
        You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'POS'.

        Note :
        1. Assume that the Indexing for the linked list always starts from 0.
        2. If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.
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

    public static Node<Integer> delete(Node<Integer> head, int pos) {

        if(pos==0){
            return head.next;
        }

        int count=0;
        Node<Integer>temp = head;
        while(temp != null && count < pos-1){
            temp = temp.next;
            count++;
        }

        if(temp.next!=null){
            temp.next = temp.next.next;
        }
        return head;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = delete(head,0);
        print(head);
    }
}
---------------------------------
        Input:
        10 20 30 -1

        Output:
        20 30