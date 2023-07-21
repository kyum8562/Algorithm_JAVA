import java.io.*;
import java.util.*;

public class Main {
    static int N, drinking;
    static int[] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[10000+1];
        dp = new int[10000+1];
        for (int i = 1; i <= N; i++) map[i] = Integer.parseInt(br.readLine());

        dp[1] = map[1];
        dp[2] = map[1] + map[2];

        for(int i = 3 ; i <= N ; i ++)
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + map[i-1] + map[i], dp[i-2] + map[i])) ;

        System.out.println(dp[N]);
    }
}