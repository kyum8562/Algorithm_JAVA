import java.io.*;
import java.util.*;
public class Main {
    static int N, ans;
    static int[] map;
    static boolean[] v;
    static int[] delta = {-1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        v = new boolean[N+1];
        v[start] = true;
        dfs(start, 1);

        for(int i = 1 ; i <= N ; i ++)
            if(v[i]) ans ++;
        System.out.println(ans);
    }

    private static void dfs(int curr, int cnt) {
        for(int d = 0 ; d < 2 ; d ++){
            int next = curr + delta[d] * map[curr];

            if(next < 1 || next > N) continue;
            if(v[next]) continue;
            v[next] = true;
            dfs(next, cnt + 1);
        }
    }
}