import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static List<Node> graph;
    static boolean[] v;
    static int[] parents;

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
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            v = new boolean[N + 1];
            parents = new int[N + 1];
            graph = new ArrayList<>();
            ans = 0;
            int total = 0;

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.add(new Node(a, b, d));
                total += d;
            }

            for (int i = 1; i <= N; i++) parents[i] = i;

            Collections.sort(graph);

            for (int i = 0; i < graph.size(); i++) {
                Node curr = graph.get(i);

                if (find(curr.start) != find(curr.end)) {
                    ans += curr.dist;
                    union(curr.start, curr.end);
                }
            }

            System.out.println(total - ans);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
        else parents[x] = y;
    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }


}