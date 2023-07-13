import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, up = 1;
    static long ans = 0;
    static int[] v, v2;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        v = new int[N + 1];
        v2 = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Arrays.fill(v, -1);
        for(int i = 1 ; i <= N ; i ++) Collections.sort(list[i]);
        bfs(K);
        bfs2(K);

        for (int i = 1; i <= N; i++) ans += (long)v[i] * v2[i];
        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int cnt = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int curr = q.poll();

                if (v[curr] != -1) continue;
                v[curr] = cnt;

                for (int next : list[curr]) {
                    if (v[next] == -1) q.offer(next);
                }
            }
            cnt++;
        }
    }

    private static void bfs2(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (v2[curr] != 0) continue;
            v2[curr] = up++;

            for (int next : list[curr]) {
                if (v2[next] == 0) q.offer(next);
            }
        }
    }
}