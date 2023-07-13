import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, cnt = 1;
    static int[] v;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        v = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) Collections.sort(list[i]);

        bfs(K);

        for (int i = 1; i <= N; i++) System.out.println(v[i]);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int qSize = q.size();
            int curr = q.poll();

            if (v[curr] != 0) continue;
            v[curr] = cnt++;

            for (int next : list[curr]) {
                if (v[next] == 0) q.offer(next);
            }

        }
    }
}