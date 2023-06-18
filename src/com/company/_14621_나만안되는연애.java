package com.company;

import java.io.*;
import java.util.*;

public class _14621_나만안되는연애 {
    static int N, M;
    static char[] colleage;
    static List<Node>[] graph;
    static class Node{
        int node;
        int weight;
        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        colleage = new char[N+1];

        String s = br.readLine();
        for(int i = 1 ; i <= N ; i ++) colleage[i] = s.charAt(i);

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

    }
}
