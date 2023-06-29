import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static int[] ans;
    static boolean[] v;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        cnt = 1;
        v = new boolean[N + 1];
        ans = new int[N+1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1 ; i <= N ; i ++)
            Collections.sort(list[i], Collections.reverseOrder());

        dfs(R);

        for(int i = 1 ; i <= N ; i ++) System.out.println(ans[i]);

    }

    private static void dfs(int start) {
        v[start] = true;
        ans[start] = cnt++;

        for(int curr: list[start]){
            if(!v[curr]) dfs(curr);
        }
    }
}