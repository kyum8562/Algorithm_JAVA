package com.company;

import java.io.*;
import java.util.*;

public class _11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static List<ArrayList<Integer>> list;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        v = new boolean[N+1];
        list = new ArrayList<>();

        for(int i = 0 ; i < N+1 ; i ++) list.add(new ArrayList<>());


        for(int i = 0 ; i < N-1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);

        for(int i = 2 ; i < N+1 ; i ++)
            System.out.println(parent[i]);
    }

    private static void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);
        v[i] = true;

        while (!q.isEmpty()){
            int curr = q.poll();
            for(int node: list.get(curr)){
                if(!v[node]){
                    q.offer(node);
                    v[node] = true;
                    parent[node] = curr;
                }
            }
        }

    }
}
