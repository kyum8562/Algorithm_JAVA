import java.io.*;
import java.util.*;
public class Main {
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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] map = new Node[N];
        for(int i = 0 ; i < N ;i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i] = new Node(a, b);
        }

        for(int i = 0 ; i < N ; i ++){
            int rank = 1;

            for(int j = 0 ; j < N ; j ++){
                if(i == j) continue;
                if(map[i].r < map[j].r && map[i].c < map[j].c)
                    rank++;
            }
            System.out.print(rank + " ");
        }
    }
}