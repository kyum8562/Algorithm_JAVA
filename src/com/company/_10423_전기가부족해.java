package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _10423_전기가부족해 {
    static int N, M, K, cnt, sum;
    static boolean[] v;
    static int[] gene;
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
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        v = new boolean[N+1];
        gene = new int[K+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++)
            gene[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        prim(1);

        System.out.println(sum);
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
