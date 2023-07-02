import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parents;
    static List<Node> graph;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int dist;
        int isMarried;

        public Node(int start, int end, int dist, int isMarried) {
            this.start = start;
            this.end = end;
            this.dist = dist;
            this.isMarried = isMarried;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;

        int sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                sum += d;
                graph.add(new Node(a, b, d, k));
            } else union(a,b);

        }

        Collections.sort(graph, Collections.reverseOrder());
        int ans = 0;

        for (int i = 0; i < graph.size(); i++) {
            Node curr = graph.get(i);
            if (find(curr.start) != find(curr.end)) {

                ans += curr.dist;
                union(curr.start, curr.end);
            }
        }

        System.out.println(sum-ans);
    }

    static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parents[y] = x;
        else parents[x] = y;
    }
}