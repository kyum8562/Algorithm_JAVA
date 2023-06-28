import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int zeroCnt, oneCnt;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 4; i <= N ; i ++)
                dp[i] = dp[i-2] + dp[i-3];
            System.out.println(dp[N]);
        }
    }
}