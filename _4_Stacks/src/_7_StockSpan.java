public class _7_StockSpan {
}
    Q.  Stock Span
--------------
        Link: https://www.youtube.com/watch?v=0BsPlzqksZQ
        -----------------------------
        Afzal has been working with an organization called 'Money Traders' for the past few years. The organization is into the money trading business. His manager assigned him a task. For a given array/list of stock's prices for N days, find the stock's span for each day.

        The span of the stock's price today is defined as the maximum number of consecutive days(starting from today and going backwards) for which the price of the stock was less than today's price.

        For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85], then the stock spans will be [1, 1, 1, 2, 1, 4, 6].
        Explanation:
        On the sixth day when the price of the stock was 75, the span came out to be 4, because the last 4 prices(including the current price of 75) were less than the current or the sixth day's price.

        Similarly, we can deduce the remaining results.
        Afzal has to return an array/list of spans corresponding to each day's stock's price. Help him to achieve the task.

        ------------------------------

        Create Project: Stack

        Create Package: default

Create class: StackCollections
        ------------------------
        import java.util.Stack;

public class StackCollections {

    public static int[] stockSpan(int[] price) {
        int[] span = new int[price.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);    // push index
        span[0] = 1;      // both 0 and 1 are indices

        for(int i = 1; i < price.length; i++){

            // 1. pop
            while(!stack.isEmpty() && price[stack.peek()] < price[i]){
                stack.pop();
            }

            // 2. answer catching
            if (stack.isEmpty()){
                span[i] = i + 1;
            }
            else{
                span[i] = i - stack.peek();
            }

            // 3. push
            stack.push(i);
        }

        return span;
    }

    public static void printArray(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int price[] = {60, 70, 80, 100, 90, 75, 80, 120};
        int output[] = stockSpan(price);

        printArray(output);
    }
}
------------------
        Output:
        1 2 3 4 1 1 2 8
