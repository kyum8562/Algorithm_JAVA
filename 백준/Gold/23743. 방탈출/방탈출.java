import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static long finalAns = 0;
    static int[] times, parents;
    static boolean[] v;
    static List<Node> graph;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N + 1];
        parents = new int[N + 1];
        v = new boolean[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        graph = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.add(new Node(a, b, d));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) graph.add(new Node(0, i, Integer.parseInt(st.nextToken())));

        Collections.sort(graph);

        for(int i = 0 ; i < graph.size() ; i ++){
            Node curr = graph.get(i);
            if(find(curr.start) != find(curr.end)){
                union(curr.start, curr.end);
                finalAns += curr.dist;
            }
        }

        System.out.println(finalAns);
    }

    private static int find(int x) {
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) parents[y] = x;
    }
}