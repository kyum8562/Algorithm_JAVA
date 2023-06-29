import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] map = new long[N + 1];
        long[] dp = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        dp[1] = map[1];
        long max = map[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = map[i];
            for (int j = 1; j < i; j++) {
                if (map[i] > map[j])
                    dp[i] = Math.max(dp[j] + map[i], dp[i]);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}