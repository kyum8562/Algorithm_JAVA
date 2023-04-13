package com.company;

import java.io.*;
import java.util.*;

public class bfsdfs_nearList {
    static int node, edge, vertax;
    static boolean[] visited;
    static List<ArrayList<Integer>> list;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        vertax = Integer.parseInt(st.nextToken());

        visited = new boolean[node+1];
        list = new ArrayList<>();

        for(int i = 0 ; i <= node ; i ++){
            list.add(new ArrayList<>());
        }

        for(int i = 1 ; i <= edge ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }


        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }

        dfs(vertax);
        visited = new boolean[node+1];
        System.out.println();
        bfs(vertax);
    }

    private static void bfs(int vertax) {
        q = new ArrayDeque<>();
        visited[vertax] = true;
        q.offer(vertax);
        while (!q.isEmpty()){
            vertax = q.poll();
            System.out.print(vertax + " ");
            for(int i = 0 ; i < list.get(vertax).size() ; i ++){
                int idx = list.get(vertax).get(i);
                if(!visited[idx]){
                    visited[idx] = true;
                    q.offer(idx);
                }
            }
        }
    }

    private static void dfs(int vertax) {
        visited[vertax] = true;
        System.out.print(vertax + " ");
        for(int i = 0 ; i < list.get(vertax).size() ; i ++){
            if(!visited[list.get(vertax).get(i)]){
                visited[list.get(vertax).get(i)] = true;
                dfs(list.get(vertax).get(i));
            }
        }
    }
}
