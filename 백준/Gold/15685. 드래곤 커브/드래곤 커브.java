import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] map = new boolean[101][101];
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int sg = Integer.parseInt(st.nextToken());

            dragonCurve(sc, sr, sd, sg);
        }

        int ans = 0;
        for(int i = 0 ; i < 100 ; i ++){
            for(int j = 0 ; j < 100 ; j ++){
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
                    ans ++;
            }
        }

        System.out.println(ans);
    }

    private static void dragonCurve(int r, int c, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
               list.add((list.get(j) + 1) % 4);
            }
        }

        map[r][c] = true;
        for(Integer dir: list){
            r += dr[dir];
            c += dc[dir];
            map[r][c] = true;
        }
    }
}