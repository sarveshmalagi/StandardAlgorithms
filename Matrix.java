import java.util.*;

class Matrix{
    public static void main(String args[]){
        int arr[] = {3, 2, 5, 6};
        MatMul(arr);
    }
    static void MatMul(int p[]){
        int n = p.length;
        int table[][] = new int[n][n];
        int j;
        for (int i=1;i<n;i++)
            table[i][i] = 0;
        for (int z=2;z<n;z++){
            for (int i=1;i<n-z+1;i++){
                j = i+z-1;
                if(j != n){
                    table[i][j] = Integer.MAX_VALUE;
                    for (int k=i; k<=j-1; k++){
                        if (table[i][j] >= table[i][k] + table[k+1][j] + p[i-1]*p[k]*p[j])
                            table[i][j] = table[i][k] + table[k+1][j] + p[i-1]*p[k]*p[j];
                    }
                }
            }
        }
        System.out.println(table[1][n-1]);
    }
}