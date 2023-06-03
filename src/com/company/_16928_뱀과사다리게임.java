package com.company;

import java.io.*;
import java.util.*;

public class _16928_뱀과사다리게임 {
    static int[] map;
    static int L, S, ans;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new int[101];
        ans = Integer.MAX_VALUE;
        v = new boolean[101];

        for (int i = 0; i < L + S; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s] = e;
        }

        bfs(1);

        System.out.println(ans);
    }

    private static void bfs(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        v[s]= true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int curr = q.poll();

                //if(curr>100) continue;
                if (curr == 100) {
                    ans = Math.min(ans, cnt);
                    return;
                }

                for (int d = 1; d <= 6; d++) {
                    int next = curr + d;

                    if (next <= 100){
                        if(!v[map[next]] && map[next] != 0){
                            q.offer(map[next]);
                            v[map[next]] = true;
                        }
                        else if(!v[next] && map[next] == 0){
                            q.offer(next);
                            v[next] = true;
                        }
                    }
                }
            }
            cnt++;
        }
    }
}