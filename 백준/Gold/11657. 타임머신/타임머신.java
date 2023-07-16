import java.io.*;
import java.util.*;

/**
 * 밸만-포드 알고리즘 : 다익스트라 알고리즘과 비슷하게 동작하면서도, 음의 가중치를 탐색하기 위해 정점마다 모든 간선을 탐색하는 알고리즘(음의 가중치에서도 사용 가능하며, 음수 사이클 판단 가능)
 * https://www.acmicpc.net/problem/11675
 */
public class Main {
    static List<Node>[] list;
    static long[] dist;
    static int N, M;
    static int INF = Integer.MAX_VALUE;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dist = new long[N + 1];

        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }

        // 리스트 배열 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 입력받은 출발지(a)와 목적지(b)와 거리(d)를 담아줌
            list[a].add(new Node(b, d));
        }

        StringBuilder sb = new StringBuilder();
        if (!bellmanFord()) {
            for (int i = 2; i <= N; i++)
                sb.append(dist[i] == INF ? "-1\n" : dist[i]+"\n");
        }
        else sb.append("-1");

        System.out.println(sb);
    }

    private static boolean bellmanFord() {
        // 1단계 : src에서 다른 정점으로 모든 정점 초기화
        // 시작점에 해당하는 dist 값을 0으로 초기화
        dist[1] = 0;

        // 2단계 : 모든 edge |V|-1회
        // src에서 다른 정점들까지의 간단한 최단경로는 |V|-1 이내에 도달할 수 있다.
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                for(Node next: list[j]){
                    if (dist[j] != INF && dist[next.node] > dist[j] + next.cost)
                        dist[next.node] = dist[j] + next.cost;
                }
            }
        }

        // 최단 경로를 구했는데, 한 번 더 갱신이 일어난다면 minus_cycle 존재
        for (int j = 1; j <= N; j++) {
            for(Node next: list[j]){
                if (dist[j] != INF && dist[next.node] > dist[j] + next.cost)
                    // 음의 사이클이 있다는 의미
                    return true;
            }
        }

        // 음의 사이클 X
        return false;
    }
}