public class _18_InsertRecursively {
}
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

    public static Node<Integer> insert(Node<Integer> head, int pos, int elem){

        if (pos == 0){
            Node<Integer> newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        }

        if (head == null){
            return head;
        }

        head.next = insert(head.next, pos - 1, elem);
        return head;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        head = insert(head, 2, 10);
        print(head);
    }
}
-----------------------
        Input:
        10 20 30 40 -1

        Output:
        10 20 30 10 40
