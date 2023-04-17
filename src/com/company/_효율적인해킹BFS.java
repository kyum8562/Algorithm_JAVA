package com.company;

import java.io.*;
import java.util.*;

public class _효율적인해킹BFS {
    static int N, M, max, cnt;
    static boolean[] v;
    static Queue<Integer> q;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(b).add(a);
        }

        int[] res = new int[N+1];
        for(int i = 1 ; i <= N ; i ++){
            v = new boolean[N + 1];

            cnt = 0;
            bfs(i);
            res[i] = cnt;
            if(cnt > max) max = cnt;
        }

        for(int i = 1 ; i <= N ; i ++){
            if(res[i] == max)
                sb.append(i + " ");
        }
        System.out.println(sb);
    }

    private static void bfs(int n) {
        q = new ArrayDeque<>();
        v[n] = true;
        q.offer(n);

        while (!q.isEmpty()){
            int curr = q.poll();

            for(int i : list.get(curr)){
                if(!v[i]){
                    v[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }

    }
}


