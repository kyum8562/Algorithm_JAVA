package com.company;

import java.io.*;
import java.util.*;

public class _21924_도시건설 {
    static int N, M;
    static List<Node> graph;
    static int[] parents;
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int dist;
        public Node(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parents = new int[N+1];

        for(int i = 1 ; i <= N ; i ++) parents[i] = i;

        long total = 0;
        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            total += d;
            graph.add(new Node(a, b, d));
        }

        Collections.sort(graph);

        long ans = 0;
        for(int i = 0 ; i < M ; i ++){
            Node curr = graph.get(i);
            if(find(curr.start) != find(curr.end)){
                ans += curr.dist;
                union(curr.start, curr.end);
            }
        }


        for(int i=1;i<N;i++) {
            if( find(i) != find(i+1)) {
                System.out.println("-1");
                return ;
            }
        }

        if(total - ans < 0) {
            System.out.println("0");
        }else {
            System.out.println(total - ans);
        }
    }
    private static int find(int x){
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
        else parents[x] = y;
    }
}
