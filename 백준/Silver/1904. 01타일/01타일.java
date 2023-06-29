import java.io.*;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[1000001];
        dp[1]=1;
        dp[2]=2;
        for(int i = 3 ; i <= N ; i ++){
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }
        System.out.println(dp[N]);
    }
}