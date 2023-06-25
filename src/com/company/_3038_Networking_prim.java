package com.company;

import java.io.*;
import java.util.*;

public class _3038_Networking_prim {
    static int N, M;
    static int ans;
    static List<Node>[] graph;
    static boolean[] v;

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0) break;
            M = Integer.parseInt(st.nextToken());
            if (M == 0) {
                System.out.println("0");
                br.readLine();
                continue;
            }

            ans = 0;
            v = new boolean[N + 1];
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[s].add(new Node(e, d));
                graph[e].add(new Node(s, d));
            }


            prim(1);
            System.out.println(ans);
            br.readLine();
        }
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
