import java.util.*;

class SubsetSum{
  public static void main (String args[]){
    int elements[] = {12,6,4,3};
    int sum = 19;
    System.out.println(isSubsetSum(elements,sum));
  }
  static boolean isSubsetSum(int elements[],int sum){
    int n = elements.length;
    boolean table[][] = new boolean[sum+1][n+1];
    for (int i = 0; i <= n; i++)
      table[0][i] = true;
    for (int i = 1; i <= sum; i++)
      table[i][0] = false;
    for (int i = 1; i <= sum; i++){
      for (int j = 1; j <= n; j++){
        table[i][j] = table[i][j-1];
        if (i >= elements[j-1])
          table[i][j] = table[i][j] || table[i - elements[j-1]][j-1];
      }
    }
    return table[sum][n];
  }
}