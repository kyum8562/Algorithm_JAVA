import java.io.*;
import java.util.*;

public class Main {

    static int[] dp, map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[1000+1];
        map = new int[1000+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j <= i ; j ++)
                dp[i] = Math.max(dp[i], dp[i-j] + map[j]);
        }

        System.out.println(dp[N]);
    }
}