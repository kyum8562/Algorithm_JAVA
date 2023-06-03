package com.company;

import java.io.*;
import java.util.*;

public class _3187_양치기꿍 {
    static int R, C, tSheep, tWolf;
    static char[][] map;
    static boolean[][] v;
    static Queue<Coords> q;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Coords {
        int r;
        int c;

        public Coords(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[R][C];
        tSheep = tWolf = 0;

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != '#' && !v[i][j]){
                    bfs(i, j);
                }
            }
        }
        System.out.println(tSheep + " " + tWolf);
    }

    private static void bfs(int i, int j) {
        q = new ArrayDeque<>();
        q.offer(new Coords(i, j));
        v[i][j] = true;

        int sheep = 0;
        int wolf = 0;

        while(!q.isEmpty()){
            Coords curr = q.poll();

            if(map[curr.r][curr.c] == 'v') wolf++;
            if(map[curr.r][curr.c] == 'k') sheep++;

            for(int d = 0 ; d < 4 ; d ++){
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                    if(!v[nr][nc] && map[nr][nc] != '#'){
                        v[nr][nc] = true;
                        q.offer(new Coords(nr, nc));
                    }
                }
            }
        }

        if(sheep > wolf) tSheep += sheep;
        else tWolf += wolf;

    }
}
