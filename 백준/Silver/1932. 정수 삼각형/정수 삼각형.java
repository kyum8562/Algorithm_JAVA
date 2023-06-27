import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][N + 1];
        int[][] map = new int[N + 1][N + 1];
        List<Node> list = new ArrayList<>();

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                list.add(new Node(i, j));
            }

        }
        dp[1][1] = map[1][1];

//        for (int i = 1; i < N; i++){
//            int curr = 0;
//            for (int j = i; j <= i+1; j++){
//                if(i==j) curr = dp[i][j];
//                dp[i+1][j] = Math.max(map[i+1][j] + curr, dp[i+1][j]);
//            }
//        }

        for(int i = 0 ; i < list.size() ; i ++){
            Node curr = list.get(i);
            if(curr.x >= N) continue;
            int tmp = dp[curr.x][curr.y];

            dp[curr.x+1][curr.y] = Math.max(map[curr.x+1][curr.y] + tmp, dp[curr.x+1][curr.y]);
            dp[curr.x+1][curr.y+1] = Math.max(map[curr.x+1][curr.y+1] + tmp, dp[curr.x+1][curr.y+1]);
        }

        int ans = 0;
        for(int i: dp[N])
            ans = Math.max(ans, i);
        System.out.println(ans);
    }

}