import java.io.*;
import java.util.*;
public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int aLen = a.length();
        int bLen = b.length();

        String[] A = a.split("");
        String[] B = b.split("");

        dp = new int[aLen + 1][bLen + 1];

        for(int i = 1 ; i <= aLen ; i ++){
            for(int j = 1 ; j <= bLen ; j ++){
                // 같을 때
                if(A[i-1].equals(B[j-1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[aLen][bLen]);
    }
}