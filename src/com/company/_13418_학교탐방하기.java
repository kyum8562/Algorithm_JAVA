package com.company;

import java.io.*;
import java.util.*;

public class _13418_학교탐방하기 {
    static int N, M;
    static List<Node> graph;
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
        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken()) + 1;

        parents = new int[N];
        graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.add(new Node(s, e, d));
        }

        Collections.sort(graph);
        makeSet();

        // 오름차순 정렬: 최악 케이스(오름차순 0이 많아짐)
        int ans = 0;
        for (int i = 0; i < M; i++) {
            Node curr = graph.get(i);
            if (find(curr.start) != find(curr.end)) {

                if (curr.dist == 0) ans ++;
                union(curr.start, curr.end);
            }
        }

        makeSet();

        // 내림차순: 최선 케이스(오름차순 0이 적어짐)
        int ans2 = 0;
        for (int i = M-1; i >= 0; i--) {
            Node curr = graph.get(i);
            if (find(curr.start) != find(curr.end)) {

                if (curr.dist == 0) ans2 ++;
                union(curr.start, curr.end);
            }
        }

        System.out.println(Math.abs(ans * ans - ans2 * ans2));

    }

    private static void makeSet() {
        for (int i = 0; i < N; i++) parents[i] = i;
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

