import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] dist;
    static int[] ans;
    static boolean[] v;
    static List<Node>[] graph;
    static class Node{
        int n;
        int d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        for(int i = 1 ; i <= N ; i ++){
            ans = new int[N+1];
            v = new boolean[N+1];
            sb = new StringBuilder();

            dijkstra(i);

            for(int j = 1 ; j <= N ; j ++){
                if(ans[j] == 0) sb.append("- ");
                else sb.append(find(j, i)).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static int find(int t, int start) {
        if(ans[t] == start) return t;
        return find(ans[t], start);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        ans[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int curr = currNode.n;

            for(Node next: graph[curr]){
                if(dist[next.n] > dist[curr] + next.d){
                    dist[next.n] = dist[curr] + next.d;
                    ans[next.n] = curr;
                    pq.offer(next);
                }
            }
        }
    }
}