public class _21_ReverseRecursivelyDoubleNode {
}
    Time Complexity:  O(n)
        ---------------------------
        Create Project: LinkedList

        Create Package: default

Create class: DoubleNode
        -------------------------
public class DoubleNode {
    Node<Integer> head;
    Node<Integer> tail;
}
--------------------------

        Create class: LinkedListUse
        ---------------------------
        import java.util.Scanner;

public class LinkedListUse {

    public static DoubleNode reverseBetter(Node<Integer> head){
        if (head == null || head.next == null){
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }

        DoubleNode smallAns = reverseBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }

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

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        DoubleNode ans = reverseBetter(head);
        print(ans.head);
    }
}

-----------------------
        Input:
        1 3 4 -1

        Output:
        4 3 1