import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v, done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N][M];
        done = new boolean[N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char tmp = s.charAt(j);
                switch (tmp){
                    case 'U':
                        map[i][j] = 0;
                        break;
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'D':
                        map[i][j] = 2;
                        break;
                    case 'L':
                        map[i][j] = 3;
                        break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j]) dfs(i, j);
            }
        }

        System.out.println(ans);
    }
    private static void dfs(int i, int j) {
        v[i][j] = true;

        int nr = i + dr[map[i][j]];
        int nc = j + dc[map[i][j]];

        if(!v[nr][nc]) dfs(nr, nc);
        else{
            if(!done[nr][nc]) ans++;
        }

        done[i][j] = true;
    }
}