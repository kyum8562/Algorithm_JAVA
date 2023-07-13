import java.io.*;
import java.util.*;

// 중심:0 위:1 왼:2 아래:3 오:4
// 중심에 있던 발이 움직(2), 인접한 지점(3), 반대편으로 움직(4), 같은지점(1)
public class Main {
    static int[] moving;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] s = br.readLine().split(" ");
        moving = new int[s.length-1];
        for(int i = 0 ; i < s.length - 1 ; i ++)
            moving[i] = Integer.parseInt(s[i]);

        dp = new int[5][5][s.length];
        for(int i = 0 ; i < 5 ; i ++){
            for(int j = 0 ; j < 5 ; j ++)
                Arrays.fill(dp[i][j], -1);
        }

        System.out.println(solve(0, 0, 0));
    }

    private static int solve(int l, int r, int cnt) {
        if(cnt == moving.length) return 0;

        if(dp[l][r][cnt] != -1) return dp[l][r][cnt];

        dp[l][r][cnt] = Math.min(
                solve(moving[cnt], r, cnt+1) + cost(l, moving[cnt]),
                solve(l, moving[cnt], cnt+1) + cost(r, moving[cnt]));

        return dp[l][r][cnt];
    }

    private static int cost(int curr, int next) {
        int n = Math.abs(curr - next);
        if(curr == 0) return 2;
        else if(n == 0) return 1;
        else if(n == 1 || n == 3) return 3;
        else return 4;
    }
}