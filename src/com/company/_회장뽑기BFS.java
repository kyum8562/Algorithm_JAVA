package com.company;

import java.io.*;
import java.util.*;

public class _회장뽑기BFS {
    static int N, M, min = Integer.MAX_VALUE, cnt;
    static boolean[] v;
    static Queue<Integer> q;
    static List<List<Integer>> list;
    static int[] res;
    static List<Integer> resList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        resList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 || b == -1) break;

            list.get(a).add(b);
            list.get(b).add(a);
        }

        res = new int[N + 1];


        for (int i = 1; i <= N; i++)
            bfs(i);

        int minCnt = 0;
        for (int i = 1; i <= N; i++) {
            if (res[i] == min){
                minCnt++;
                resList.add(i);
            }
        }
        sb.append(min).append(" ").append(minCnt).append("\n");
        for(int v : resList){
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int n) {
        q = new ArrayDeque<>();
        v = new boolean[N + 1];
        v[n] = true;
        q.offer(n);
        cnt = 0;
        while (!q.isEmpty()) {

            int qSize = q.size();
            for (int qs = 1; qs <= qSize; qs++) {
                int curr = q.poll();

                for (int i : list.get(curr)) {
                    if (!v[i]) {
                        v[i] = true;
                        q.offer(i);
//                        max = Math.max(res[i], max);
                    }
                }
            }
            cnt++;

        }
        res[n] = cnt-1;
        min = Math.min(min, res[n]);
    }
}


