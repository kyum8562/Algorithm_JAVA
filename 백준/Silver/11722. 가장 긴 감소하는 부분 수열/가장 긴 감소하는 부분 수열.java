import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] map = new long[N + 1];
        long[] dp = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        long max = 1;

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (map[j] > map[i])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}