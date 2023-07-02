import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
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
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (i < j) {
                    if (tmp < 0) {
                        sum -= tmp;
                        union(i, j);
                    } else
                        graph.add(new Node(i, j, tmp));
                }
            }
        }

        Collections.sort(graph);
        int ans = 0;

        List<Node> ansList = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            Node curr = graph.get(i);
            if (find(curr.start) != find(curr.end)) {

                ans += 1;
                sum += curr.dist;
                ansList.add(new Node(curr.start, curr.end, 0));
                union(curr.start, curr.end);
            }
        }

        System.out.println(sum + " " + ans);
        for (Node curr : ansList) {
            System.out.println(curr.start + " " + curr.end);
        }
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