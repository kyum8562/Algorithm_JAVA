package com.company;

import java.io.*;
import java.util.*;

public class _16398_행성연결kruskal_list {
    static int N;
    static long ans;
    static List<Node> graph;
    static int[] parents;
    static int[][] map;
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

        parents = new int[N+1];
        for(int i = 1 ; i <= N ; i ++) parents[i] = i;
        graph = new ArrayList<>();
        map = new int[N+1][N+1];

        for(int i = 1 ; i <= N ;i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j ++){
//                map[i][j] = Integer.parseInt(st.nextToken());
                graph.add(new Node(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        Collections.sort(graph);

        for(int i = 0 ; i < graph.size() ; i ++){
            Node curr = graph.get(i);

            if(find(curr.start) != find(curr.end)){
                ans += curr.dist;
                union(curr.start, curr.end);
            }
        }

        System.out.println(ans);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) parents[y] = x;
        else parents[x] = y;
    }

    private static int find(int x) {
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
}
