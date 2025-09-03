//lets go with brute force first , trying all the pairs TC --O(n^2)
import java.util.*;
public class BestTime_toBuy_and_sell_stock{
    public static int maxProfit_Brute(int[]prices){
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                int profit = prices[j]-prices[i];
                if(profit>maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.print("Enter stock prices: ");
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        int ans = maxProfit_Brute(prices);
        System.out.println(ans);

        sc.close();// In small programs (like LeetCode practice), not closing Scanner won’t cause issues,
        // since the program ends right after main finishes and resources are released automatically.
       // But in larger applications that run long, not closing input/output resources can cause memory leaks or file locks.
    }

}

// Now optimal method --> single pass keeping track of price so far and compute profit
import java.util.*;

public class BestTime_toBuy_and_sell_stock {
    // Optimal: O(n) time, O(1) space
    public static int maxProfit_Optimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // update min price
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.print("Enter stock prices: ");
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        int ans = maxProfit_Optimal(prices);
        System.out.println(ans);

        sc.close();
    }
}
