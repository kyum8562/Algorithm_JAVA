import java.io.*;
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
    static long finalAns = 0;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int totalSum = 0;

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                int curr = tmp[j] - '0';

                if (curr == 0) continue;
                else if (curr >= 49) curr -= 48;
                else curr += 10;

                pq.add(new Node(i, j + 1, curr));
                totalSum += curr;
            }
        }

        int used = 0;
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if (find(curr.start) != find(curr.end)) {
                union(curr.start, curr.end);
                finalAns += curr.dist;
                used ++;
            }
        }

        if(used == N-1) System.out.println(totalSum - finalAns);
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