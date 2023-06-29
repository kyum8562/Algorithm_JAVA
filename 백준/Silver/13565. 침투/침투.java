import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0 ; i < M ; i ++){
            v = new boolean[N][M];
            dfs(new Node(0, i));

            if(checking()){
                System.out.println("YES");
                System.exit(0);
            }
        }

        System.out.println("NO");
    }


    private static void dfs(Node curr) {
        v[curr.r][curr.c] = true;

        for(int d = 0 ; d < 4 ; d ++){
            int nr = dr[d] + curr.r;
            int nc = dc[d] + curr.c;

            if(isValid(nr, nc) && !v[nr][nc] && map[nr][nc] == '0'){
                dfs(new Node(nr, nc));
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }

    private static boolean checking() {
        for(int i = 0 ; i < M; i ++)
            if(v[N-1][i] == true) return true;
        return false;
    }
}