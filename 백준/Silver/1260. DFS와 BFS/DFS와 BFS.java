import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] v;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1 ; i <= N ; i ++)
            Collections.sort(list[i]);

        v = new boolean[N + 1];
        v[S] = true;
        dfs(S, 0);

        sb.append("\n");
        v = new boolean[N + 1];
        bfs(S);

        System.out.println(sb);
    }

    private static void dfs(int curr, int depth) {
        if(depth == N) return;

        sb.append(curr).append(" ");

        for(int next: list[curr]){
            if(v[next]) continue;
            v[next] = true;
            dfs(next, depth + 1);
        }
    }

    private static void bfs(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        v[s] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            sb.append(curr).append(" ");

            for (int next : list[curr]) {
                if (v[next]) continue;
                v[next] = true;
                q.offer(next);
            }
        }
    }


}