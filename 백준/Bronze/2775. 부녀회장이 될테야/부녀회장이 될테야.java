import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            long[][] dp = new long[K+1][N+1];

            for(int i = 1 ; i <= N ; i ++) dp[0][i] = i;
            for(int i = 1 ; i <= K ; i ++) dp[i][1] = 1;

            for (int i = 1; i <= K; i++) {
                for (int j = 2; j <= N; j++) {
                    dp[i][j] += dp[i-1][j] + dp[i][j-1];
                }
            }

            System.out.println(dp[K][N]);
        }
    }
}