import java.io.*;
import java.util.*;
public class Main {
    static int N, ans = Integer.MAX_VALUE;
    static int[] choice;
    static boolean[] v;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j ++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        choice = new int[N/2 + 1];
        v = new boolean[N + 1];
        perm(0, 1);

        System.out.println(ans);
    }

    private static void perm(int depth, int start) {
        if(depth == N/2){
            play();
            return;
        }

        for(int i = start ; i <= N ; i ++){
            if(v[i]) continue;
            v[i] = true;

            perm(depth + 1, i + 1);
            v[i] = false;
        }
    }

    private static void play() {

        int[] t1 = new int[N/2];
        int[] t2 = new int[N/2];
        int cnt1 = 0 , cnt2 = 0;
        for(int i = 1 ; i <= N ; i ++){
            if(v[i]) t1[cnt1++] = i;
            else t2[cnt2++] = i;
        }

        int team1 = calc(t1);
        int team2 = calc(t2);

        ans = Math.min(ans, Math.abs(team2 - team1));
    }

    private static int calc(int[] arr) {
        int sum = 0;
        for(int i = 0 ; i < N/2 ; i ++){
            for(int j = 0 ; j < i ; j ++){
                sum += map[arr[i]][arr[j]] + map[arr[j]][arr[i]];
            }
        }
        return sum;
    }
}