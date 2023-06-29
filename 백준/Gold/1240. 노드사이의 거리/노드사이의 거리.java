import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static List<Node>[] graph;
    static boolean[] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ans = 0;
            v = new boolean[N+1];

            boolean flag = false;

            for(Node next: graph[start]){
                if(next.end == end){
                    System.out.println(next.dist);
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            dfs(start, end, v, 0);
            System.out.println(ans);
        }
    }

    private static void dfs(int start, int end, boolean[] v, int cnt) {
        if (start == end){
            ans = cnt;
            return;
        }

        v[start] = true;

        for (Node next : graph[start]) {
            if(!v[next.end]){
                dfs(next.end, end, v, cnt+next.dist);
            }
        }
    }

}