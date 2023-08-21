import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static HashMap<Integer, Integer> hash = new LinkedHashMap<>();
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for(int i = 0 ; i < K ; i ++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < L ; i ++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            hash.put(a, b.equals("L") ? 1 : 2); // L(반시계 90)은 1, D(시계 90)는 2
        }

        System.out.println(gameStart(1, 1, 0));
    }

    private static int gameStart(int sr, int sc, int sd) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sr, sc));
        int time = 0;
        map[sr][sc] = 2;

        while(true){
            time++;
            int nr = sr + dr[sd];
            int nc = sc + dc[sd];

            if(!isValid(nr, nc)) return time;
            if(map[nr][nc] == 2) return time;

            // 다음 위치에 사과가 있을 경우
            if(map[nr][nc] == 1){
                map[nr][nc] = 0;
            }
            // 사과가 없을 경우
            else{
                Node curr = q.poll();
                map[curr.r][curr.c] = 0;
            }

            map[nr][nc] = 2;
            q.offer(new Node(nr, nc));

            sr = nr;
            sc = nc;

            // 방향 전환
            if(hash.getOrDefault(time, 3) == 1)
                if(sd == 0) sd = 3;
                else sd = (sd-1) % 4;
            else if(hash.getOrDefault(time, 3) == 2)
                sd = (sd+1) % 4;

        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>0 && nr<=N && nc>0 && nc<=N);
    }

}