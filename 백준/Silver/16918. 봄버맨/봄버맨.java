import java.io.*;
import java.util.*;
public class Main {
    static int R, C, N, time = 0;
    static char[][] map;
    static boolean[][] v;
    static List<Node> list;
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[R][C];

        for(int i = 0 ; i < R ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < C ; j ++){
                map[i][j] = s.charAt(j);
            }
        }

        while(true){
            if(++time == N) break;

            // 폭탄 위치 얻기
            list = new ArrayList<>();
            getBomb();

            // 폭탄 설치
            createBomb();
            if(++time == N) break;

            // 폭탄 터뜨리기
            explosion();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < R ; i ++){
            for(int j = 0 ; j < C ; j ++)
                sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void getBomb() {
        for(int i = 0 ; i < R ; i ++){
            for(int j = 0 ; j < C ; j ++){
                if(map[i][j] == 'O') list.add(new Node(i, j));
            }
        }
    }

    private static void explosion() {
        for(Node curr: list){
            for(int d = 0; d < 5 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc)) continue;
                map[nr][nc] = '.';
            }
        }
    }

    private static void createBomb() {
        for(int i = 0 ; i < R ; i ++){
            for(int j = 0 ; j < C ; j ++)
                map[i][j] = 'O';
        }
    }

    private static boolean isValid(int nr, int nc){
        return (nr>=0 && nr<R && nc>=0 && nc<C);
    }

}