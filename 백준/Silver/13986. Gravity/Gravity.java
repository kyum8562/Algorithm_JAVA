import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static List<Node> list;
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
        list = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j ++){
                char tmp = s.charAt(j);
                if(tmp == 'o'){
                    map[i][j] = '.';
                    list.add(new Node(i, j));
                }
                else map[i][j] = tmp;
            }
        }

        int len = list.size();
        for(int i = len-1 ; i >= 0 ; i --){
            Node curr = list.get(i);

            while(curr.r < N - 1){
                if(map[curr.r+1][curr.c] == '.') curr.r ++;
                else if(map[curr.r+1][curr.c] == '#' || map[curr.r+1][curr.c] == 'o') break;
            }

            map[curr.r][curr.c] = 'o';
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i ++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}