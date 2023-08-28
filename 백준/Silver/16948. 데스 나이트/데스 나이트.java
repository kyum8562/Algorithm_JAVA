import java.io.*;
import java.util.*;
public class Main {
    static int INF = Integer.MAX_VALUE;
    static int N, ans = INF;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static class Node{
        int r;
        int c;
        int d;
        Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int er = Integer.parseInt(st.nextToken());
        int ec = Integer.parseInt(st.nextToken());

        bfs(sr, sc, er, ec);
        System.out.println(ans == INF ? -1 : ans);
    }

    private static void bfs(int sr, int sc, int er, int ec) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sr, sc, 0));

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(v[curr.r][curr.c]) continue;
            v[curr.r][curr.c] = true;

            if(curr.r == er && curr.c == ec)
                ans = Math.min(ans, curr.d);

            for(int d = 0 ; d < 6 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc) || v[nr][nc]) continue;

                q.offer(new Node(nr, nc, curr.d + 1));
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<N);
    }
}