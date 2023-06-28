import java.io.*;

public class Main {
    static int zeroCnt, oneCnt;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            zeroCnt = oneCnt = 0;

            fibonacci(N);

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    private static void fibonacci(int n) {
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-2][j];
            }
        }
    }
    
}