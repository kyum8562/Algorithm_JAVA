import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 밸만-포드 알고리즘 : 다익스트라 알고리즘과 비슷하게 동작하면서도, 음의 가중치를 탐색하기 위해 정점마다 모든 간선을 탐색하는 알고리즘(음의 가중치에서도 사용 가능하며, 음수 사이클 판단 가능)
 * https://www.acmicpc.net/problem/1865
 */
public class Main {
    static List<Node>[] list;
    static long[] dist;
    static int N, M, W;
    static int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            dist = new long[N + 1];

            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            // 리스트 배열 초기화
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                // 도로는 양방향 그래프
                if (i < M) {
                    list[b].add(new Node(a, d));
                    list[a].add(new Node(b, d));
                }
                // 웜홀은 단방향 그래프
                else
                    list[a].add(new Node(b, -d));
            }

            boolean isMinusCycle = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }

            if (!isMinusCycle) sb.append("NO\n");

        }
        System.out.println(sb);
    }

    private static boolean bellmanFord(int start) {
        // src에서 다른 정점으로 모든 정점 초기화
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        // N-1 번 동안 최단 경로 초기화 작업 반복
        for (int i = 1; i < N; i++) {
            update = false;

            // 최단 경로 초기화
            for (int j = 1; j <= N; j++) {
                for (Node next : list[j]) {
                    if (dist[j] != INF && dist[next.node] > dist[j] + next.cost) {
                        dist[next.node] = dist[j] + next.cost;
                        update = true;
                    }
                }
            }

            // 더 이상 최단 경로 초기화가 일어나지 않았을 경우 break;
            if (!update) break;
        }

        // N-1까지 계속 업데이트가 진행됐을 경우,
        // N에서 한 번 더 갱신이 일어난다면 minus_cycle 존재
        if (update) {
            for (int j = 1; j <= N; j++) {
                for (Node next : list[j]) {
                    if (dist[j] != INF && dist[next.node] > dist[j] + next.cost)
                        // 음의 사이클이 있다는 의미
                        return true;
                }
            }
        }

        // 음의 사이클 X
        return false;
    }
}