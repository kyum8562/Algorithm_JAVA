import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static StringTokenizer st;
    static List<Integer>[] list;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0); // 늑대(W) or 양(S)
            int b = Integer.parseInt(st.nextToken()); // a의 개체 수
            int c = Integer.parseInt(st.nextToken()); // 해당 i섬에는 c로 가는 다리가 있음

            list[c].add(i);
            dp[i] = (a == 'W') ? b*-1 : b;
        }

        dfs(1, -1);
        System.out.println(dp[1]);
    }

    private static void dfs(int curr, int parent) {
        for (int next : list[curr]) {
            dfs(next, curr);
        }
        if(parent != -1){
            if(dp[curr] > 0)
                dp[parent] += dp[curr];
        }
    }
}