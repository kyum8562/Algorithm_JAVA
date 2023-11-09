import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int pisano = 1500000;
        long N = Long.parseLong(br.readLine()) % pisano;

        long[] dp = new long[pisano+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= N ; i ++)
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
        sb.append(dp[(int) N]);
        System.out.println(sb);
    }
}