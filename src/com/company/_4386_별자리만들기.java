package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4386_별자리만들기 {
    static int N;
    static double ans;
    static List<Node>[] graph;
    static boolean[] v;
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

        graph = new ArrayList[N+1];
        v = new boolean[N+1];
        double[][] location = new double[N+1][2];

        for(int i = 1 ; i <= N ; i ++) graph[i] = new ArrayList<>();

        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            location[i][0] = x;
            location[i][1] = y;
        }

        for(int i = 1 ; i <= N ; i ++) {
            for(int j = i+1 ; j <= N ; j ++){
                double xPow = Math.pow(location[i][0] - location[j][0], 2);
                double yPow = Math.pow(location[i][1] - location[j][1], 2);
                double d = getDistance(xPow, yPow);

                graph[i].add(new Node(j, d));
                graph[j].add(new Node(i, d));
            }
        }
        
        prim(1);
        System.out.println(ans);
    }

    private static double getDistance(double xPow, double yPow) {
        return Math.sqrt(xPow +yPow);
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

            for(Node next: graph[node]){
                if(!v[next.node]) pq.add(next);
            }

        }

    }
}
