public class _14_PalindromeLinkedList {
}
    Q.  Palindrome LinkedList
-------------------------
        You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.
        -----------------------
        Solution:
        --------------
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

    public static boolean isPalindrome(Node<Integer> head){

        // finding middle of the LinkedList
        Node<Integer> slow = head, fast = head, mid = null;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Odd --> fast is not null
        if (fast != null){
            mid = slow.next;
        } else {
            mid = slow;
        }

        // Reversing the second half of LinkedList
        Node<Integer> prev = null, next = null;
        while (mid != null){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        // Comparing two LinkedList
        while (prev != null){
            if (prev.data != head.data){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        System.out.println(isPalindrome(head));
    }
}
-----------------------
        Input:
        10 20 10 -1

        Output:
        true
        ------
        Input:
        10 -1

        Output:
        true
        -------
        Input:
        10 20 30 -1

        Output:
        false