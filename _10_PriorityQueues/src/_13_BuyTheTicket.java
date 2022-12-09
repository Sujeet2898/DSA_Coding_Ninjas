public class _13_BuyTheTicket {
}
    Q.  Buy the ticket
        ----------------------------------------------
        You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
        A queue is maintained for buying the tickets and every person is attached with a priority (an integer, 1 being the lowest priority).

        The tickets are sold in the following manner -
        1. The first person (pi) in the queue requests for the ticket.
        2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
        3. Otherwise, give him the ticket (and don't make him stand in queue again).

        Giving a ticket to a person takes exactly 1 minute and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
        Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.
        ----------------------------------------------
        Input Format:
        The first line of input contains an integer, that denotes the value of total number of people standing in queue or the size of the array of priorities. Let us denote it with the symbol N.
        The following line contains N space separated integers, that denote the value of the elements of the array of priorities.
        The following contains an integer, that denotes the value of index of your priority. Let us denote it with symbol k.
        ----------------------------------------------
        Output Format :
        The first and only line of output contains the time required for you to get the ticket.
        ----------------------------------------------
        Create Project: Priority_Queue

        Create Package: default

Create class: PriorityQueueUse
        -----------------------------------------------
        Time Complexity: O(N * logN)
        -----------------------------------------------
        import java.util.Collections;
        import java.util.LinkedList;
        import java.util.PriorityQueue;
        import java.util.Queue;

public class PriorityQueueUse {

    static class Pair{
        int value;
        int index;
    }

    public static int buyTicket(int input[], int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i < input.length;i++) {
            Pair pair = new Pair();
            pair.value = input[i];
            pair.index = i;
            priorityQueue.add(input[i]);
            queue.add( pair );
        }
        int count = 0;
        while(!queue.isEmpty()) {

            if(priorityQueue.peek() == queue.peek().value) {
                priorityQueue.remove();
                Pair pair = queue.remove();
                count++;
                if( pair.index == k ) {
                    return count;
                }
            }
            else {

                queue.add(queue.remove());

            }

        }

        return count ;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {2, 3, 2, 2, 4};
        System.out.println(buyTicket(arr,3));
    }
}
--------------------------------------------
        Output:
        4