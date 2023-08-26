import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] go;
    static boolean[] v, done;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            N = Integer.parseInt(br.readLine());

            ans = 0;
            v = new boolean[N+1];
            done = new boolean[N+1];
            go = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                go[i] = Integer.parseInt(st.nextToken());

            for(int i = 1 ; i <= N ; i ++)
                if(!done[i]) dfs(i);

            System.out.println(N - ans);
        }
    }

    private static void dfs(int curr) {
        if(v[curr]){
            done[curr] = true;
            ans++;
        }
        else v[curr] = true; 

        if(!done[go[curr]])
            dfs(go[curr]);

        v[curr] = false;
        done[curr] = true;
    }
}