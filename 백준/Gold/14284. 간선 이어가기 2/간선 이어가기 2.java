import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static boolean[] v;
    static int[] dist;
    static List<Node>[] graph;

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N + 1];
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);

        System.out.println(dijkstra(S, E));
    }

    private static int dijkstra(int S, int E) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        dist[S] = 0;
        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int curr = currNode.node;

            for (Node next : graph[curr]) {
                if (dist[next.node] > dist[curr] + next.dist) {
                    dist[next.node] = dist[curr] + next.dist;
                    pq.offer(next);
                }
            }
        }

        return dist[E];
    }
}