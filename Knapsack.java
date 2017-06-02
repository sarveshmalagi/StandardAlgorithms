import java.util.*;

class Knapsack{
    public static void main(String args[]){
        int wts[] = {12,15,17,25};
        int profit[] = {25,67,45,72};
        int cap = 40;
        knapsack(wts,profit,cap);
    }
    
    static void knapsack(int wts[],int profit[],int cap){
     int i, w;
     int n = profit.length;
     int table[][] = new int[n+1][cap+1];
     for(i=0;i<=n;i++){
        table[i][0] = 0;
     }
     for(i=0;i<=cap;i++){
        table[0][i] = 0;
     }
     for (i = 1; i <= n; i++){
         for (w = 1; w <= cap; w++){
             if (wts[i-1] <= w)
                   table[i][w] = Integer.max(profit[i-1] + table[i-1][w-wts[i-1]],  table[i-1][w]);
             else
                   table[i][w] = table[i-1][w];
         }
      }
      System.out.println(table[n][cap]);
    }
}