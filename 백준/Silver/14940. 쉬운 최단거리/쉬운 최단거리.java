import java.io.*;
import java.util.*;
public class Main {
    static int N, M, sR, sC;
    static int[][] map, v;
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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new int[N][M];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    sR = i;
                    sC = j;
                }
            }

        }

        bfs();

        for(int i = 0 ; i < N ; i ++) {
            for (int j = 0; j < M; j++){
                if(map[i][j] == 1 && v[i][j] == 0) sb.append(-1).append(" ");
                else sb.append(v[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sR, sC));

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(int d = 0 ; d < 4 ; d ++){
                int nr = dr[d] + curr.r;
                int nc = dc[d] + curr.c;

                // map 안의 유효한 값이며 갈 수 있는 땅이며,
                if(isValid(nr, nc) && map[nr][nc] == 1 && v[nr][nc] == 0){
                    v[nr][nc] = v[curr.r][curr.c] + 1;
                    q.offer(new Node(nr, nc));
                }

            }
        }
    }

    private static boolean isValid(int nr, int nc){
        return(nr>=0 && nr<N && nc>=0 && nc<M);
    }

}