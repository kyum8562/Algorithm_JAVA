import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[R+K+1][R+K+1];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;

        int ans = 0;
        for (int i = 3; i <= R+K; i++){
            for(int j = 1 ; j <= i ; j ++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for (int i = 0; i < K; i++){
            for(int j = 0 ; j <= i ; j ++){
                ans += dp[R+i][C+j];
            }
        }

        System.out.println(ans);
    }
}