package com.company;

import java.io.*;
import java.util.*;

public class _6497_전력난prim {
    static int N, M, ans;
    static List<Node>[] graph;
    static boolean[] v;
    static class Node implements Comparable<Node> {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            v = new boolean[N + 1];
            graph = new ArrayList[N];
            ans = 0;
            int total = 0;

            for(int i = 0 ; i < N ; i ++) graph[i] = new ArrayList<>();

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
                total += d;
            }


            prim(1);
            System.out.println(total - ans);
        }
    }

    private static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.node;
            int dist = currNode.dist;

            if(v[curr]) continue;
            v[curr] = true;
            ans += dist;

            for(Node next: graph[curr]){
                if(!v[next.node]) pq.add(next);
            }
        }
    }


}
