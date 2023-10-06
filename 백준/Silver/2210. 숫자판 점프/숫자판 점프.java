import java.io.*;
import java.util.*;
public class Main {
    static int[][] map = new int[5][5];
    static Set<String> set = new LinkedHashSet<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0 ; i < 5 ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 5 ; j ++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < 5 ; i ++) {
            for (int j = 0; j < 5; j++){
                dfs(i, j, 0, "");
            }
        }

        System.out.println(set.size());
    }

    private static void dfs(int r, int c, int cnt, String s) {
        if(cnt == 6){
            set.add(s);
            return;
        }

        for(int d = 0 ; d < 4 ; d ++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isValid(nr, nc)) continue;
            dfs(nr, nc, cnt + 1, s + map[nr][nc]);
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<5 && nc>=0 && nc<5);
    }
}