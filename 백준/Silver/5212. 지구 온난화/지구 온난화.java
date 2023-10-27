import java.io.*;
import java.util.*;
public class Main {
    static int R, C;
    static int[][] map, map2;
    static List<Node> list;
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        map2 = new int[R+1][C+1];
        list = new ArrayList<>();

        for(int i = 1 ; i <= R ; i ++){
            String s = br.readLine();
            for(int j = 1 ; j <= C ; j ++){
                int curr = s.charAt(j-1);
                if(curr == '.') continue;
                map[i][j] = 1;
                list.add(new Node(i, j));
            }
        }

        int up = Integer.MAX_VALUE;
        int down = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(Node curr: list){
            int bada = 0;
            for(int d = 0; d < 4 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc)){
                    bada ++;
                    continue;
                }
                if(map[nr][nc] == 0) bada ++;
            }
            if(bada <= 2){
                map2[curr.r][curr.c] = 1;
                left = Math.min(left, curr.r);
                right = Math.max(right, curr.r);
                up = Math.min(up, curr.c);
                down = Math.max(down, curr.c);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = left ; i <= right ; i ++){
            for(int j = up ; j <= down ; j ++)
                sb.append(map2[i][j] == 1 ? "X" : '.');
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static boolean isValid(int nr, int nc){
        return (nr>=1 && nr<=R && nc>=1 && nc<=C);
    }
}