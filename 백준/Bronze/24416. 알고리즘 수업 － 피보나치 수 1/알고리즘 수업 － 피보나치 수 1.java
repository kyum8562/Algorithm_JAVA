import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        System.out.println(func1(N) + " " + (N-2));
    }

    private static int func2(int n) {
        dp[1] = dp[2] = 1;
        for(int i = 3 ; i <= n ; i ++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static int func1(int n) {
        if(n == 1 || n == 2) return 1;
        else return func1(n-1) + func1(n-2);
    }
}