import java.io.*;
public class Main {
    static int N;
    static char[][] map, map2;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        v = new boolean[N][N];
        map = new char[N][N];
        map2 = new char[N][N];
        for(int i = 0 ; i < N ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j ++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'G') map2[i][j] = 'R';
                else map2[i][j] = map[i][j];
            }

        }

        int cnt = 0;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                if(v[i][j]) continue;
                dfs(i, j, map[i][j], 0);
                cnt++;
            }
        }
        System.out.print(cnt + " ");

        cnt = 0;
        v = new boolean[N][N];
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                if(v[i][j]) continue;
                dfs(i, j, map2[i][j], 1);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int i, int j, char tgt, int type) {
        v[i][j] = true;

        for(int d = 0 ; d < 4 ; d ++){
            int nr = i + dr[d];
            int nc = j + dc[d];

            if(!isValid(nr, nc) || v[nr][nc]) continue;
            if(type == 0 && map[nr][nc] != tgt) continue;
            if(type == 1 && map2[nr][nc] != tgt) continue;

            dfs(nr, nc, tgt, type);
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<N);
    }
}