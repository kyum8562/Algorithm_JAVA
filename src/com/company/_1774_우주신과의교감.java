package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1774_우주신과의교감 {
    static int N, M;
    static double ans;
//    static List<Node>[] graph;
    static double[][] map;
    static boolean[] v;
    static double[] dist;
    static class Node implements Comparable<Node>{
        int node;
        double dist;
        public Node(int node, double dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            if(this.dist > o.dist) return 1;
            else if(this.dist < o.dist) return -1;
            else return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        graph = new ArrayList[N+1];
        map = new double[N+1][N+1];
        dist = new double[N+1];
        v = new boolean[N+1];
        double[][] location = new double[N+1][2];

//        Arrays.fill(dist, Double.MAX_VALUE);

//        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            location[i][0] = x;
            location[i][1] = y;
        }

        for(int i = 1 ; i <= N ; i ++) {
            for(int j = i+1 ; j <= N ; j ++){
                if(i == j ) continue;

                double xPow = Math.pow(location[i][0] - location[j][0], 2);
                double yPow = Math.pow(location[i][1] - location[j][1], 2);
                double d = getDistance(xPow, yPow);

//                graph[i].add(new Node(j, d));
//                graph[j].add(new Node(i, d));
                map[i][j] = map[j][i] = d;
            }
        }

        for(int i = 1 ; i <= M; i ++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

//            graph[x].add(new Node(y, 0));
//            graph[y].add(new Node(x, 0));
            map[x][y] = map[y][x] = 0;
        }
        if(N != 0) prim(1);
        System.out.printf("%.2f", ans);
    }

    private static double getDistance(double xPow, double yPow) {
        return Math.sqrt(xPow + yPow);
    }

    private static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int node = curr.node;
            double dist = curr.dist;

            if(v[node]) continue;
            v[node] = true;
            ans += dist;

//            for(Node next: graph[node]){
//                if(!v[next.node]) pq.add(next);
//            }
//            for()

        }

    }
}
