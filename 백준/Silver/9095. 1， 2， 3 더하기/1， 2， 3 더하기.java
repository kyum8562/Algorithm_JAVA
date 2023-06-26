import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T ; t ++){
            int tgt = Integer.parseInt(br.readLine());

            dp = new int[11];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i = 4 ; i <= tgt ; i ++)
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

            System.out.println(dp[tgt]);
        }
    }
}