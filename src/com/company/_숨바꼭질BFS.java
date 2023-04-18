package com.company;

import java.io.*;
import java.util.*;

public class _숨바꼭질BFS {
    static int N, M, max, cnt;
    static boolean[] v;
    static Queue<Integer> q;
    static List<List<Integer>> list;
    static int[] res;

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

            list.get(a).add(b);
            list.get(b).add(a);
        }

        res = new int[N + 1];
        v = new boolean[N + 1];
//        for (int i = 1; i <= N; i++) {
//
//            cnt = 0;
//            bfs(i);
//            if (cnt > max) max = cnt;
//        }
        bfs(1);

        int a = 0, b = 0, c = 0;
        for (int i = 1; i <= N; i++) {

            // 세번째 결과값
            if (res[i] == max)
                c++;

            // 첫번째 결과값
            if (c == 1 && res[i] == max) {
                a = i;
                b = res[i];
            }
        }
        System.out.println(a + " " + b + " " + c + " ");
    }

    private static void bfs(int n) {
        q = new ArrayDeque<>();
        v[n] = true;
        q.offer(n);
        cnt = 1;
        while (!q.isEmpty()) {

            int qSize = q.size();
            for (int qs = 1; qs <= qSize; qs++) {

                int curr = q.poll();

                for (int i : list.get(curr)) {
                    if (!v[i]) {
                        v[i] = true;
                        q.offer(i);
                        res[i] = cnt;
                        max = Math.max(res[i], max);
                    }
                }
            }
            cnt++;
        }
    }
}


