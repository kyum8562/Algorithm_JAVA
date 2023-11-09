import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        if(N == 0) sb.append(0);
        else if(N == 1) sb.append(1);
        else{
            long[] dp = new long[N+1];
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2 ; i <= N ; i ++)
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            sb.append(dp[N]);
        }
        System.out.println(sb);
    }
}