package com.company;

import java.io.*;
import java.util.*;

public class _21924_도시건설prim {
    static int N, M;
    static long ans, total;
    static List<Node>[] graph;
    static boolean[] v;
    static class Node{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = total = 0;
        graph = new ArrayList[N+1];
        v = new boolean[N+1];

        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            total += d;

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));

        }


        prim(1);

        for(int i = 1 ; i <= N ; i ++) if(!v[i]) ans = -1;

        System.out.println(ans == -1 ? -1 : total - ans);
    }

    private static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int node = currNode.node;
            int dist = currNode.dist;

            if(v[node]) continue;
            v[node] = true;
            ans += dist;

            for(Node next: graph[node]){
                if(!v[next.node]) pq.offer(next);
            }
        }
    }
}
