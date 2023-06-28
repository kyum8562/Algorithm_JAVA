import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[36];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;


        for (int i = 3; i <= N; i++) {
            int s = 0;
            int e = i - 1;
            while (s < i)
                dp[i] += dp[s++] * dp[e--];
        }


        System.out.println(dp[N]);
    }
}