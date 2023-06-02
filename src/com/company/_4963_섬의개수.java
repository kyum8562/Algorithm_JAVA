package com.company;

import java.io.*;
import java.util.*;

public class _4963_섬의개수 {
    static int R, C;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
    static StringTokenizer st;
    static BufferedReader br;
    static Queue<Coords> q;
    static class Coords{
        int r;
        int c;
        public Coords(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if(R == 0 && C == 0) break;
            int ans = 0;

            map = new int[R+1][C+1];
            v = new boolean[R+1][C+1];

            for(int i = 1 ; i <= R ; i ++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1 ; j <= C ; j ++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1 ; i <= R ; i ++){
                for(int j = 1 ; j <= C ; j ++){
                    if(!v[i][j] && map[i][j] == 1){
                        bfs(i, j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);

        }

    }

    private static void bfs(int i, int j) {
        q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new Coords(i, j));

        while(!q.isEmpty()){
            Coords curr = q.poll();

            for(int d = 0 ; d < 8 ; d ++){
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if(nr > 0 && nr <= R && nc > 0 && nc <= C){
                    if(!v[nr][nc] && map[nr][nc] == 1){
                        q.offer(new Coords(nr, nc));
                        v[nr][nc] = true;
                    }
                }
            }
        }
    }

}
