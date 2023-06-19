package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10423_전기가부족해kruskal {
    static int N, M, K, sum;
    static int[] parents;

    static List<Node> graph;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){return this.weight - o.weight;}
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parents = new int[N+1];

        for (int i = 1; i <= N; i++)
            parents[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++){
            parents[Integer.parseInt(st.nextToken())] = -1;
        }


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.add(new Node(a, b, d));
        }

        Collections.sort(graph);

        for(int i = 0 ; i < graph.size() ; i ++){
            Node curr = graph.get(i);

            if(find(curr.start) != find(curr.end)) {
                sum += curr.weight;
                union(curr.start, curr.end);

                if (isAllConnect()) break;
            }
        }

        System.out.println(sum);
    }

    private static boolean isAllConnect() {
        for(int i = 1 ; i <= N ; i ++){
            if(parents[i] != -1) return false;
        }
        return true;
    }

    private static int find(int x) {
        if(-1 == parents[x]) return -1;
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x == -1) parents[y] = x;
            else if(y == -1) parents[x] = y;
            else{
                if(x == -1 && y == -1) return;
                else parents[y] = x;
            }
        }
    }
}
