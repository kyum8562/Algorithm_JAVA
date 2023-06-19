package com.company;

import java.io.*;
import java.util.*;

public class _14621_나만안되는연애 {
    static int N, M, cnt, sum;
    static char[] colleage;
    static boolean[] v;
    static List<Node>[] graph;

    static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        colleage = new char[N + 1];
        graph = new ArrayList[N + 1];
        v = new boolean[N+1];
        cnt = sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) colleage[i] = st.nextToken().charAt(0);

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(colleage[b] != colleage[a]){
                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
            }
        }

        prim(1);
        boolean flag = true;
        for(int i= 1 ; i <= N; i ++){
            if(!v[i]) flag = false;
    }

        System.out.println(flag ? sum : -1);
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.node;
            int weight = currNode.weight;

            if(v[curr]) continue;
            v[curr] = true;
            sum += weight;

            for(Node next: graph[curr]){
                if(!v[next.node]) pq.offer(next);
            }

            if(++cnt == N) break;
        }
        return sum;
    }
}
