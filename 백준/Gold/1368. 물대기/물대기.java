import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 1368 물대기
 * N개의 논에 물을 대려고 함
 * 물을 대는 방법은 2가지
 * 1. 직접 논에 우물을 파는 것
 * 2. 이미 물을 대고 있는 다른 논으로부터 물을 끌어오는 법
 *
 */

public class Main {
    static int N;
    static long finalAns = 0;
    static int[] parents;
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

        parents = new int[N + 1];
        v = new boolean[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        graph = new ArrayList<>();

        for (int i = 1; i <= N; i++) graph.add(new Node(0, i, Integer.parseInt(br.readLine())));

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int d = Integer.parseInt(st.nextToken());

                if(d == 0) continue;
                graph.add(new Node(i, j, d));
            }
        }

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