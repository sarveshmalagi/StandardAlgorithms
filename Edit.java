import java.util.*;

class Edit{
    public static void main(String args[]){
        String s1 = "abba";
        String s2 = "aba";
        edit(s1,s2);
    }
    
    static void edit(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] table = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            table[i][0] = i;
        }
        for(int i=0;i<=m;i++){
            table[0][i] = i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    table[i][j] = table[i-1][j-1];
                else
                    table[i][j] = 1+Integer.min(table[i-1][j],Integer.min(table[i][j-1],table[i-1][j-1]));
            }
        }
        System.out.println(table[n][m]);
    }
}