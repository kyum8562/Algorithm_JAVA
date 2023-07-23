import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1368 물대기
 * N개의 논에 물을 대려고 함
 * 물을 대는 방법은 2가지
 * 1. 직접 논에 우물을 파는 것
 * 2. 이미 물을 대고 있는 다른 논으로부터 물을 끌어오는 법
 * <p>
 * 크루스칼(간선 중심) VS 프림(정점 중심)
 * 프림은 간선이 많을 때 유리
 * 간선이 적다면 -> 크루스칼
 */

public class Main {
    static int N;
    static long sum = 0;
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
        int totalSum = 0;

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        graph = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                int curr = tmp[j] - '0';

                if (curr == 0) continue;
                else if (curr >= 49) curr -= 48;
                else curr += 10;

                graph.add(new Node(i, j + 1, curr));
                totalSum += curr;
            }
        }

        Collections.sort(graph);

        int used = 0;
        for (int i = 0; i < graph.size(); i++) {
            Node curr = graph.get(i);
            if (find(curr.start) != find(curr.end)) {
                union(curr.start, curr.end);
                sum += curr.dist;
                used ++;
            }
        }

        if(used == N-1) System.out.println(totalSum - sum);
        else System.out.println(-1);
    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
    }
}