import java.io.*;
import java.math.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        if(N == 0) sb.append(0);
        else if(N == 1) sb.append(1);
        else{
            BigInteger[] dp = new BigInteger[N+1];
            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;
            for(int i = 2 ; i <= N ; i ++)
                dp[i] = dp[i-1].add(dp[i-2]);
            sb.append(dp[N]);
        }
        System.out.println(sb);
    }
}