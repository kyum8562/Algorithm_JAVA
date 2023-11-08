import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int N, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[N+1][2];
        dp[1][0] = 1;
        dp[2][1] = 1;
        play(N);
        int one = dp[N][0];
        int two = dp[N][1];
        for(int i = 1 ; i <= D ; i ++){
            for(int j = i+1 ; j <= D ; j ++){
                long sum = (one*i) + (two*j);
                if(sum == D){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }
    }

    private static void play(int N){
        for(int i = 3 ; i <= N ; i ++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
    }
}