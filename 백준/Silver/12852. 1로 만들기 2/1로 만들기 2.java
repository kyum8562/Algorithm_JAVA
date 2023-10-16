import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static List<Integer>[] list;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        dp = new int[N+1];
        for(int i = 1 ; i <= N ; i ++) list[i] = new ArrayList<>();
        Arrays.fill(dp, INF);
        dp[1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for(int i = 2 ; i <= N ; i ++){
            int tmp = i;
            int cnt = 0;

            if(dp[i] == INF){
                int[] h = new int[3];
                Arrays.fill(h, 9999);
                if(tmp % 3 == 0){
                    tmp /= 3;
                    if(dp[tmp] != INF) h[0] = dp[tmp];
                    tmp *= 3;
                }
                if(tmp % 2 == 0){
                    tmp /= 2;
                    if(dp[tmp] != INF) h[1] = dp[tmp];
                    tmp *= 2;
                }
                tmp -= 1;
                if(dp[tmp] != INF) h[2] = dp[tmp];
                tmp += 1;

                int min = Integer.MAX_VALUE;
                int idx = 0;
                for(int j = 0 ; j < 3; j ++){
                    if(min > h[j]){
                        idx = j;
                        min = h[j];
                    }
                }
                dp[i] = Math.min(dp[i], min + 1);
                int addNum = 0;
                if(idx == 0) addNum = i/3;
                else if(idx == 1) addNum = i/2;
                else addNum = i-1;
                list[i].add(addNum);
            }
        }
        System.out.println(dp[N]);
        StringBuilder sb = new StringBuilder();
        while(true){
            sb.append(N+" ");
            if(N <= 1) break;
            N = list[N].get(0);
        }
        System.out.println(sb);
    }
}