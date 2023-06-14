package com.company;

import java.util.*;
import java.io.*;
public class _1922_네트워크연결prim {
    static int N, M, ans;
    static List<Node>[] graph;
    static boolean[] v;
    static class Node implements Comparable<Node>{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N+1];
        graph = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        prim(1);
        System.out.println(ans);
    }

    private static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int node = currNode.node;
            int dist = currNode.dist;

            if(v[node]) continue;
            v[node] = true;
            ans += dist;

            for(Node next: graph[node]){
                if(!v[next.node]){
                    pq.add(next);
                }
            }
        }
    }
}
