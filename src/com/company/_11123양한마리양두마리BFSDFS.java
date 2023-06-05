package com.company;

import java.io.*;
import java.util.*;

public class _11123양한마리양두마리BFSDFS {
    static int R, C, ans;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 1 ; t <= T ; t++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            v = new boolean[R][C];
            ans = 0;

            for(int i = 0 ; i < R ; i ++){
                String s = br.readLine();
                for(int j = 0 ; j < C ; j ++){
                    map[i][j] = s.charAt(j);
                }
            }

            for(int i = 0 ; i < R ; i ++){
                for(int j = 0 ; j < C ; j ++){
                    if(!v[i][j] && map[i][j] == '#'){
//                        bfs(i, j);
                        v[i][j] = true;
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void dfs(int i, int j) {

        for(int d = 0 ; d < 4 ; d ++){
            int nr = dr[d] + i;
            int nc = dc[d] + j;

            if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                if(!v[nr][nc] && map[nr][nc] == '#'){
                    v[nr][nc] = true;
                    dfs(nr, nc);
                }
            }
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        v[i][j] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int d = 0 ; d < 4 ; d ++){
                int nr = dr[d] + curr[0];
                int nc = dc[d] + curr[1];

                if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                    if(!v[nr][nc] && map[nr][nc] == '#'){
                        q.offer(new int[]{nr, nc});
                        v[nr][nc] = true;
                    }
                }
            }
        }
    }
}
