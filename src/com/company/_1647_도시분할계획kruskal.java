package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1647_도시분할계획kruskal {
    static int N, M, maxDist;
    static int ans;
    static List<Node>[] graph;
    static double[][] map;
    static boolean[] v;
    static double[] dist;
    static class Node{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        v = new boolean[N+1];

        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        if(N != 0) prim(1);
        System.out.println(ans - maxDist);
    }

    private static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int node = curr.node;
            int dist = curr.dist;

            if(v[node]) continue;
            v[node] = true;
            ans += dist;
            maxDist = Math.max(maxDist, dist);

            for(Node next: graph[node]){
                if(!v[next.node]) pq.add(next);
            }

        }

    }
}
